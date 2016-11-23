import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import static java.lang.System.*;
public class copChats {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
			
		if (args.length !=2)
		{
			out.println("Uso: copier <Arq1> <Arq1>");
			exit(1);
		}
			
		copyLaines(args[0], args[1]);		
			
	}		
		/*
		 * Metodo
		 * Letitura de carateres do arquivo		
		 */
		public static void copyLaines(String arq1,String arq2) throws IOException
		{
	
   			BufferedReader bufIn = null;
			PrintWriter prnOut = null;
						
			try{
				bufIn = new BufferedReader(new FileReader("Arq1"));
				prnOut = new PrintWriter(new PrintWriter("Arq2"));
				String linha = bufIn.readLine();
				
				while (linha != null)
				{ 
					linha= bufIn.readLine(); 
				}				

			}				
			catch(IOException ioe){die (ioe);}
			finally{
				if (bufIn != null) bufIn.close();
				if (prnOut != null) prnOut.close();
			}
		}		
		
		public static void die(IOException e)
		{
			err.print(e.getMessage());
			e.printStackTrace(err);
		}
		


		
	}
