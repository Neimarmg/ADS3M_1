package Utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Include {
	
	Formatos i = new Formatos();

	public void novoRegistro(String arquivo, String  desc){
		try {
			FileWriter fileR;
			BufferedWriter buff;
			fileR = new FileWriter(new File(arquivo),true);
			buff = new BufferedWriter(fileR);	
			buff.newLine();
			buff.write(desc);					
			buff.close();
		} catch (IOException e) {
			i.msg("Não foi possivél inserir registro!");
		}	
	}
		
		
	public void removeRegistro(){
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
}
