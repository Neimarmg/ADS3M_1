package Utilitarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Include {
	
	FileWriter fileR;
	BufferedWriter buff;
	
	//try{	
		public void insereLinha(String arquivo, String  desc) throws IOException{
			fileR = new FileWriter(arquivo);
			buff = new BufferedWriter(fileR);	
			buff.flush();
			buff.newLine();	
			buff.write(desc);					
			buff.close();		 
		}
		

	

		public void criaArquivo(String nomeArquivo){
			/** Realiza a remoção lógica do registro
			 * 
			 */
		} 

		public void removeLinha(){
			/** Realiza a remoção lógica do registro
			 * 
			 */
		}  
		
		public void removeArquivo(String nomeArquivo){
			/** Realiza a remoção lógica do registro
			 * 
			 */
		} 
		
		public void salva(){
			/** Realiza a remoção lógica do registro
			 * 
			 */
		} 
		public void altera(){
			/** Realiza a remoção lógica do registro
			 * 
			 */
		} 

	//} Catch(){
		//printMsg(?)
	//}
}
