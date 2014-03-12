package Arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

import Aplicacao.acoes;
import Utilitarios.Formatos;
import Utilitarios.Include;

public class Ficheiro {
	
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	Include n =  new Include();

		private void leArquivoExitente(String nomeAquivo) throws Exception {
			Path p = Paths.get(nomeAquivo);
			i.msg("Arquivo existente: "+p);
	    }
	          
	      
        public void imprimeArquivo(String nomeAquivo) throws FileNotFoundException{
        	
        	File file = new File(nomeAquivo);
        	 
        	 FileInputStream in = new FileInputStream(file);
			 Scanner scanner = new Scanner(in);  
			 
			 while (scanner.hasNext()) {
				 String readLine = scanner.next();
				 i.msg(readLine +"\n");
			 }
        }
        

 		public void executaComando(String comando) throws Exception { 
 			String nomeAquivo = "C:/Users/Guilherme/Documents/GitHub/ADS3M_1/Alg3_M_E1/lt.txt";
			String c = comando.toLowerCase();
        	
        	switch (c) {
			case "novo":
				i.msg("\nNome do aquvixo: ");
				String arquivo = var.next();
				i.msg("\nComando opçional não implementado!\n");
				break;
			
			case "existente":
				leArquivoExitente(nomeAquivo);
				break;
			
			case "imprime":
				imprimeArquivo(nomeAquivo);
				break;
				
			default:
				i.msgl();
				i.msgOpcaoInvalida();
				acoes a  = new acoes();
				a.informaArquivo();
				break;
				
			}       	
        } 

}
