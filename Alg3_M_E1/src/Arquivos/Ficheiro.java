package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

import Utilitarios.Formatos;
import Utilitarios.Include;

public class Ficheiro {
	
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	Include n =  new Include();
	//try {
	
	    
		private void MostraArquivoTxtExitente(String nomeAquivo){
	    	Path p = Paths.get(nomeAquivo);    	
		}
	
		
		/**Localiza e Le arquivo existente 
		 * http://www.youtube.com/watch?v=C1sx-FEsgOk ler aquivo linha a linha
		 * @param nemeAquivo
		 * @throws IOException 
		 */
		private void leArquivoExitente(String nomeAquivo) throws Exception {
			MostraArquivoTxtExitente(nomeAquivo);
			 File file = new File(nomeAquivo);
			 
			 FileInputStream in = new FileInputStream(file);
			 Scanner scanner = new Scanner(in);  
			 
			 while (scanner.hasNext()) {
				 String readLine = scanner.next();
				 i.msg(readLine +"\n");
			 }
	    }
	            
        
		/** Comando inicializar so programa e de um arquivo 
		 * @throws Exception 
		*/
 		public void executaComando(String comando) throws Exception { 
        	
			String c = comando.toLowerCase();
        	
        	switch (c) {
			case "novo":
				i.msg("\nNome do aquvixo: ");
				String arquivo = var.next();
				i.msg("\nComando opçional não implementado!\n");
				break;
			
			case "existente":
				leArquivoExitente("C:/Users/Guilherme/Documents/GitHub/ADS3M_1/Alg3_M_E1/lt.txt");
				break;
				
			default:
				i.msgOpcaoInvalida();
				break;
			}       	
        }
        
        
        /**
         * 
         */
        public void imprimeArquivo(){
			//printMsg("?");
        }
	
    //} Catch(){
		//printMsg(?)
	//}
}
