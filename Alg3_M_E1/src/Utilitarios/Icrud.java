package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Icrud {
	
	/**
	 * Insere novo registro em arquivo .txt!
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void addNovo(String arquivo, String  desc) throws IOException {
		FileWriter f;
		BufferedWriter buff = null;
		try {
			f = new FileWriter(new File(arquivo),true);
			buff = new BufferedWriter(f);			
			buff.newLine();
			buff.write(desc);			
			buff.close();	
		} catch (IOException e) {
			Prints.msg("Não foi possivél inserir registro.");
		}finally{
			buff.close();
		}
	}
		
	
	/**
	 * Realiza ficheiro remoção lógica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void exclui(String arquivo, String  desc) throws IOException {
		try {                      
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			String linha = br.readLine();
			while(linha != null ){
				linha = br.readLine();
				if(linha.equals(desc)){
					Prints.msg("\nRegistro encotrado:" +linha);
					br.reset();
					if(linha.equals("")) {
						Prints.msg("\nRegistro excluído com sucesso." +desc);
					}				
				}
			}
			br.close();			
		}catch(IOException e){
			Prints.msg("\nNão foi possivél remover o registro.");
		}catch(NullPointerException e){
			Prints.msg("\nNão foi possivél remover o registro.");
		}
	}  
		
	
	/** 
	 * Realiza ficheiro salva edição do registro
	* 
	*/			
	public void salva() {
		Prints.objetoNaoImplementado();
	} 
		
	
	/** 
	 * Realiza alteração do registro
	* 
	*/
	public void altera() {
		Prints.objetoNaoImplementado();
	} 
}