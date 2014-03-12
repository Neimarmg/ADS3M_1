package Arquivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Utilitarios.Formatos;

public class Ficheiro {
	Formatos f = new Formatos();
	//try {
	
		/**Localiza e Le arquivo existente 
		 * http://www.youtube.com/watch?v=C1sx-FEsgOk ler aquivo linha a linha
		 * @param nemeAquivo
		 * @throws FileNotFoundException 
		 */		
        private void leArquivoExitente(String nemeAquivo) throws IOException  { 
        	//Scanner sc = new Scanner(new FileReader(nemeAquivo));    	
        	FileInputStream n = new FileInputStream(nemeAquivo);
        	InputStreamReader arquivo = new InputStreamReader(n);
        	BufferedReader ln = new BufferedReader(arquivo);
        	String linha = ln.readLine();
        	while(linha != null) {
        		   String nome = linha.substring(0, linha.indexOf('|'));
        		   String cidade = linha.substring(linha.indexOf('|') + 1, linha.lastIndexOf('|'));
        		   String compras = linha.substring(linha.lastIndexOf('|') + 1, linha.length());
        		   System.out.println(nome);
        		   System.out.println(cidade);
        		   System.out.println(compras);
        		   linha = ln.readLine();
        	}        	
        }
            
        
		/** Comando inicializar so programa e de um arquivo 
		* @throws IOException 
		*/        
        public void executaComando(String comando, String nemeAquivo) throws IOException { 
        	String c = comando.toLowerCase();
        	
        	switch (c) {
			case "novo":
				f.msg("\nComando opçional não implementado!\n");
				break;
			
			case "existente":
				leArquivoExitente(nemeAquivo);
				break;
				
			default:
				f.msgOpcaoInvalida();
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
