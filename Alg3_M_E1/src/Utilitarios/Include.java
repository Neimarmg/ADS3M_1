package Utilitarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Include {
	//try{	
		public void insereLinha(String nomeArquivo){
			/** Insere registro na lista
			 * http://www.youtube.com/watch?v=2zHG7vhkYjI
			 */
			File arquivo = new File(nomeArquivo);
			 try( FileWriter fw = new FileWriter(arquivo) ){
			     fw.write("Nnnnnn\n");
			     fw.flush();
			 }catch(IOException ex){
			   ex.printStackTrace();
			 }
			 
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
