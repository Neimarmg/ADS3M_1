package Utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Include {
	
	FileWriter fileR;
	BufferedWriter buff;
	
	//try{	
		public void insereLinha(String arquivo, String  desc) throws IOException{
			fileR = new FileWriter(new File(arquivo),true);
			buff = new BufferedWriter(fileR);	
			buff.write(desc);					
			buff.close();	
		}
		

		public void criaArquivo(String nomeArquivo){
			/** Realiza a remo��o l�gica do registro
			 * 
			 */
		} 

		
		public void removeLinha(){
			/** Realiza a remo��o l�gica do registro
			 * 
			 */
		}  
		
		
		public void removeArquivo(String nomeArquivo){
			/** Realiza a remo��o l�gica do registro
			 * 
			 */
		} 
		
		
		public void salva(){
			/** Realiza a remo��o l�gica do registro
			 * 
			 */
		} 
		
		public void altera(){
			/** Realiza a remo��o l�gica do registro
			 * 
			 */
		} 

	//} Catch(){
		//printMsg(?)
	//}
}
