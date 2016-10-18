/**
 * 
 */
package es.um.ssdd.uForth.interpreter.bare;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import es.um.ssdd.uForth.Definition;
import es.um.ssdd.uForth.uFProgram;

/**
 * @author dsevilla
 *
 */
public class Interpreter 
{
	// Program running stack
	Stack<Word> stack;
	Stack<Integer> call_stack;
	
	// Memory
	Word[] memory;
	
	uFProgram the_program;
	
	// Higher addr in memory
	int higher_addr;
	
	// Program starts where in the memory?
	int start;

	// Instruction Pointer
	int ip;
	
	// Variable map
	Map<String,Integer> variable_map;
	Map<String,DefinedWord> definition_map;
	
	// Classes for predefined words
	// I could have used different classes, but they happen to be
	// small and this way I don't have to create a protocol between
	// the interpreter and the predefined words
	abstract class DefinedWord
	{
		public abstract void apply();
	}
	
	// Where sum types went in Java? :(
	abstract class PredefinedWord extends DefinedWord
	{
	}
	
	class W_DUP extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			push(top());
			++ip;
		}
		
	}
	
	class W_EMIT extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			emit_word(pop());
			++ip;
		}
	}
	
	class W_PRINTLN extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			println_word(pop());
			++ip;
		}
	}
	
	class W_PRINT extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			print_word(pop());
			++ip;
		}
	}
	
	class W_SEMI extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			// End of definition, return.
			// The address of return should be in the stack
			ip = call_stack.pop();
		}
	}

	class W_DO extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			// TODO: ignore 0
			pop();
			++ip;
			call_stack.push(ip);
		}
	}
	
	class W_LOOP extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			Word w = pop();
			assert (w instanceof Number);
			int n = (int)((Number)w).getValue();

			if (n == 0)
			{
				// End of loop, remove loop address
				call_stack.pop();
				++ip;
			}
			else
			{
				n--;
				push(new Number(n));
				ip = call_stack.peek();
			}
		}
	}
	
	class W_SWAP extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			Word w1 = pop();
			Word w2 = pop();
			push(w1);
			push(w2);
			++ip;
		}
	}
	
	class W_DROP extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			pop();
			++ip;
		}
	}
	
	class W_IF extends PredefinedWord
	{
		private int find_else_or_then_counting_ifs()
		{
			// Empezar después del IF
			int testing_ip = ip+1;
			int ifs = 0;
			
			while (true)
			{
				Word considering_word = memory[testing_ip];
				if (considering_word instanceof PlainId)
				{
					String id2 = ((PlainId)considering_word).getId();
					
					// Comprobar primero el ID que buscamos (THEN ó ELSE)
					// para evitar que el contador llegue a negativo, es decir
					// retornar directamente si es el IF que le toca
					if ((id2.equals("THEN") 
							|| id2.equals("ELSE"))							
							&& ifs == 0)
						return testing_ip + 1;
					else if (id2.equals("IF"))
						++ifs;
					else if (id2.equals("THEN")) // un IF anidado termina
						--ifs;
				}
				
				++testing_ip;
			}
		}
		
		@Override
		public void apply() 
		{
			Word w = pop();
			boolean truthness = true;
			if (w instanceof Number) // Valor false
			{
				int value = (int)((Number)w).getValue();
				truthness = value != 0;
			}
			
			if (truthness)
				++ip;  // Normal
			else
				ip = find_else_or_then_counting_ifs();
		}
	}

	class W_ELSE extends PredefinedWord
	{
		private int find_then_counting_ifs()
		{
			// Empezar después del IF
			int testing_ip = ip+1;
			int ifs = 0;
			
			while (true)
			{
				Word considering_word = memory[testing_ip];
				if (considering_word instanceof PlainId)
				{
					String id2 = ((PlainId)considering_word).getId();
					
					// Comprobar primero el ID que buscamos THEN
					// para evitar que el contador llegue a negativo, es decir
					// retornar directamente si es el IF que le toca
					if (id2.equals("THEN") && ifs == 0)
						return testing_ip + 1;
					else if (id2.equals("IF"))
						++ifs;
					else if (id2.equals("THEN")) // un IF anidado termina
						--ifs;
				}
				
				++testing_ip;
			}
		}
		
		@Override
		public void apply() 
		{
			ip = find_then_counting_ifs();
		}
	}

	class W_THEN extends PredefinedWord
	{
		@Override
		public void apply() 
		{
			++ip;
		}
	}
	
	////////////////////////////// USER DEFINED WORDS
	
	class W_USERDEFINED extends DefinedWord
	{
		@Override
		public void apply() 
		{
			call_stack.push(ip+1);
			ip = the_address;
		}
		
		private int the_address;
		
		public DefinedWord with_address(int addr)
		{
			the_address = addr;
			return this;
		}
	}
	
	public Interpreter(uFProgram p)
	{
		the_program = p;
		
		// Initialize the memory
		memory = new Word[1024 * 1024]; // 1M locations
		higher_addr = 0;
		
		// Maps
		variable_map = new HashMap<String,Integer>(20);
		definition_map = new HashMap<String,DefinedWord>(20);
		
		// The stack!
		stack = new Stack<Word>();
		// Call stack
		call_stack = new Stack<Integer>();
		
		// Fill the predefined word dictionary
		definition_map.put(";", new W_SEMI());
		definition_map.put("EMIT", new W_EMIT());
		definition_map.put("DUP", new W_DUP());
		definition_map.put("PRINTLN", new W_PRINTLN());
		definition_map.put("PRINT", new W_PRINT());
		definition_map.put("DO", new W_DO());
		definition_map.put("LOOP", new W_LOOP());
		definition_map.put("SWAP", new W_SWAP());
		definition_map.put("DROP", new W_DROP());
		definition_map.put("IF", new W_IF());
		definition_map.put("THEN", new W_THEN());
		definition_map.put("ELSE", new W_ELSE());
		
		// Compile Program
		compile();
	}

	private void word_to_memory(es.um.ssdd.uForth.Word w, int pos)
	{
		if (w instanceof es.um.ssdd.uForth.Number)
			memory[pos] = new Number(((es.um.ssdd.uForth.Number)w).getValue());
		else if(w instanceof es.um.ssdd.uForth.String)
			memory[pos] = new FString(((es.um.ssdd.uForth.String)w).getStr());
		else if(w instanceof es.um.ssdd.uForth.PlainId)
			memory[pos] = new PlainId(((es.um.ssdd.uForth.PlainId)w).getId());
	}
	
	private void compile()
	{
		// Fill maps, program start and memory
		
		// Definitions
		for (Definition d : the_program.getDefinitions())
		{
			// Memory start for this definition
			int def_start = higher_addr;
			
			for (es.um.ssdd.uForth.Word w: d.getWords())
			{
				word_to_memory(w, higher_addr);
				++higher_addr;
			}
			
			definition_map.put(d.getName(),
					new W_USERDEFINED().with_address(def_start));
		}
		
		// Start of the program
		start = higher_addr;
		
		for (es.um.ssdd.uForth.Word w: the_program.getWords())
		{
			word_to_memory(w, higher_addr);
			++higher_addr;
		}
	}

	private void push(Word w)
	{
		stack.push(w);
	}
	
	private Word top()
	{
		return stack.peek();
	}
	
	private Word pop()
	{
		return stack.pop();
	}
	
	// Interpret current word
	private boolean interpret()
	{
		Word current_word = memory[ip];
		
		if (current_word instanceof Number 
				|| current_word instanceof FString)
		{
			push(current_word);
			++ip;
			return true;
		}
		
		String id = ((PlainId)current_word).getId();
		if (id.equals("END"))
			return false;
		else if (definition_map.containsKey(id))
			definition_map.get(id).apply();
		else // Fallback case for IDs
		{
			// Ponerlo en la cima de la pila
			push(current_word);
			++ip;
		}
		
		return true;
	}
	
	private void emit_word(Word w)
	{
		if (w instanceof FString)
			System.out.print(((FString)w).getValue());
		else
			System.out.print(Character.toString((char)((Number)w).getValue()));	
	}
	
	private void println_word(Word w) 
	{
		if (w instanceof FString)
			System.out.println(((FString)w).getValue());
		else if (w instanceof Number)
			System.out.println(((Number)w).getValue());
	}

	private void print_word(Word w) 
	{
		if (w instanceof FString)
			System.out.print(((FString)w).getValue());
		else if (w instanceof Number)
			System.out.print(((Number)w).getValue());
	}

	public void exec()
	{
		// Comenzar en start
		ip = start;
		
		while (interpret())
			;
	}
}
