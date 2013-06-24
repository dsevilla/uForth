/**
 * 
 */
package es.um.ssdd.uForth.main;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import es.um.ssdd.uForth.UForthPackage;
import es.um.ssdd.uForth.uFProgram;
import es.um.ssdd.uForth.interpreter.bare.Interpreter;

/**
 * @author dsevilla
 *
 */
public final class ForthInterpreterBare 
{
	
	static uFProgram read_model(String filename) throws IOException
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
				resourceSet.getResource
				(URI.createFileURI(filename),true);
		uFProgram p =(uFProgram)resource.getContents().get(0);
		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			// Serializar el modelo
			uFProgram p = read_model(args[0]);
			
			new Interpreter(p).exec();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
