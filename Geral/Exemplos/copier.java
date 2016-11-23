import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import sun.print.resources.serviceui;
import static java.lang.System.*;

public class copier {	
	public static void main(String[] args) throws IOException
	{
			
		if (args.length !=2)
		{
			out.println("Uso: copier <Arq1> <Arq1>");
			exit(1);
		}
			
		copyBytes(args[0],args[1]);		
	}
		
		/*
		 * Metodo
		 * Letitura de baytes do arquivo		
		 */
		public static void copyBytes(String arq1,String arq2) throws IOException
		{
				
			FileInputStream fim = null;
			FileOutputStream fout =null;
				
			try{
					
				fim = new FileInputStream("Arq1");
				fout = new FileOutputStream("Arq2");
				int c;
				for (c = fim.read(); c != -1 ;c = fim.read()); 
				{
						fout.write(c);
						
				}
			}				
			catch(IOException ioe){die (ioe);}
			finally{
				if (fim != null) fim.close();
				if (fout != null) fout.close();
			}
		}
		
		public static void die(IOException e)
		{
			err.print(e.getMessage());
			e.printStackTrace(err);
		}		
			
			
		}	
		

