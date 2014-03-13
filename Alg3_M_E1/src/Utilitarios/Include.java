package Utilitarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Include {
	
	FileWriter fileR;
	BufferedWriter buff;
	
	//try{	
		public void insereLinha(String desc) throws IOException{
			fileR = new FileWriter("lt.txt");
			buff = new BufferedWriter(fileR);
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
