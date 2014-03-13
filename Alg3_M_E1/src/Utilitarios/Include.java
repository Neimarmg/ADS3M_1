package Utilitarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Include {
	
	FileWriter fileR;
	BufferedWriter buff;
	
	//try{	
		public void insereLinha(String nomeArquivo, String desc, String fone) throws IOException{
			fileR = new FileWriter(nomeArquivo);
			buff = new BufferedWriter(fileR);
			buff.write(desc);
			buff.write(fone);
			//buff.close();		 
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
