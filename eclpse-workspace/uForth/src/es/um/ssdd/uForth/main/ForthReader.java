/**
 * 
 */
package es.um.ssdd.uForth.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;

import es.um.ssdd.uForth.PlainId;
import es.um.ssdd.uForth.UForthFactory;
import es.um.ssdd.uForth.UForthPackage;
import es.um.ssdd.uForth.Word;
import es.um.ssdd.uForth.uFProgram;
import es.um.ssdd.uForth.Definition;

/**
 * @author dsevilla
 *
 */
public final class ForthReader
{
	
	private static Word interpret_word(String s)
	{
		// String?
		// Bare word?
		// Number?
		Word w;

		// Number?
		if (s.matches("(\\+|-)?((\\d+(\\.\\d+)?)|(\\.\\d+))"))
		{
			es.um.ssdd.uForth.Number n = 
					UForthFactory.eINSTANCE.createNumber();
			n.setValue(Double.parseDouble(s));
			w = (Word)n;
		}
		else if (s.startsWith("\"")) // String?
		{
			es.um.ssdd.uForth.String ss =
					UForthFactory.eINSTANCE.createString();
			ss.setStr(s.substring(1, s.length()-1));
			w = (Word)ss;
		}
		else
		{
			// Si no, plain identifier
			PlainId id = UForthFactory.eINSTANCE.createPlainId();
			id.setId(s);
			w = (Word)id;
		}
		
		return w;
	}
	
	static void write_model(uFProgram p, String filename) throws IOException
	{
		// Register the appropriate resource factory
		// to handle all file extensions.
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry()
			.getExtensionToFactoryMap()
			.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());

		// Register the package to make it available during loading.
		resourceSet.getPackageRegistry()
			.put(UForthPackage.eNS_URI,UForthPackage.eINSTANCE);
		
		Resource resource =
				resourceSet.createResource
				(URI.createFileURI(filename));
		resource.getContents().add(p);
		Map<String, Boolean> options = new HashMap<String, Boolean>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		resource.save(options);
	}
	
	static List<String> interpret_words_from_file(String filename) throws IOException
	{
		File file = new File(filename);
		List<String> words =
			ImmutableList.<String>builder()
				.addAll(
					Splitter.on(CharMatcher.WHITESPACE)
					.trimResults()
					.split(Files.toString(file, Charsets.UTF_8)))
				.build();
		
		// Test
		//System.err.println(Joiner.on(",").join(words));
		
		// Construir las cadenas de caracteres. La única
		// excepción que hacemos sobre la regla de que todo
		// son palabras separadas por espacios.
		boolean in_string = false;
		boolean in_comment = false;
		StringBuilder tempString = 
				new StringBuilder();
		
		List<String> processedWords = 
				new LinkedList<String>();
		
		for(String s: words)
		{
			// Signal the start of a comment
			if (s.startsWith("("))
				in_comment = true;

			// End of a comment?
			if (in_comment)
				in_comment = ! s.endsWith(")"); 
			else
			{
				if (in_string)
				{
					tempString.append(" ");			

					if (s.isEmpty())
						continue;

					// Si no es vacío, añadirlo  y ver si terminar la cadena
					tempString.append(s);

					// Si la cadena termina en "
					in_string = ! s.endsWith("\"");

					// Si se ha terminado esta cadena, añadirla a la lista
					if (!in_string)
					{
						processedWords.add(tempString.toString());
						tempString = new StringBuilder();
					}
				}
				else
				{
					// Si no estamos en una cadena, ignorar las cadenas vacías
					if (s.isEmpty())
						continue;

					// El string comienza aquí pero no termina
					if (s.startsWith("\"") && !s.endsWith("\""))
					{
						in_string = true;
						tempString.append(s);
					}
					else // Bien no es un String o empieza y termina con este token
						processedWords.add(s);
				}
			}
		}
		
		// Test
		//System.err.println(Joiner.on(",").join(processedWords));
		
		return processedWords;
	}
	
	private static uFProgram build_program_from_words(List<String> words) 
	{
		// Construir el modelo
		uFProgram p = UForthFactory.eINSTANCE.createuFProgram();
		
		Iterator<String> it = words.iterator();
		while (it.hasNext())
		{
			String s = it.next();
			
			// ¿Definición?
			if (s.equals(":"))
			{
				// Inicio de definición
				Definition d = UForthFactory.eINSTANCE.createDefinition();

				// Se suponer que la definición está bien construida
				// El nombre de la definición es la siguiente palabra
				d.setName(it.next());
				
				// Cuerpo
				while (it.hasNext())
				{
					String s1 = it.next();
					
					Word w = interpret_word(s1);						
					d.getWords().add(w);

					// ¿Fin de la definición?
					if (s1.equals(";"))
						break;
				}
				
				// Añadir la definición
				p.getDefinitions().add(d);
			}
			else
			{
				// Palabras normales
				// OJO: Siempre después de las definiciones
				p.getWords().add(interpret_word(s));				
			}
		}

		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			List<String> words = interpret_words_from_file(args[0]);
			
			uFProgram p = build_program_from_words(words);
			
			// Serializar el modelo
			write_model(p, args[0].replace(".forth", ".xmi"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
