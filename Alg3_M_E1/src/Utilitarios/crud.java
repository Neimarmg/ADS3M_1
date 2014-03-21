package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import Aplicacao.Interface;
import Arquivos.Memoria;

public class crud {
	
	Formatos i = new Formatos();	
	
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
			i.msg("Não foi possivél inserir registro.");
		}finally{
			buff.close();
		}
	}
		
	
	/**
	 * Realiza a remoção lógica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void exclui(String arquivo, String  desc) throws IOException {
		String s = "";  

		try {                      
			FileReader f = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(f);
			String linha = br.readLine();
			while(linha != null ){
				linha = br.readLine();
				if(linha.equals(desc)){
					i.msg("\nRegistro encotrado:" +linha);
					br.reset();
					if(linha.equals("")) {
						i.msg("\nRegistro excluído com sucesso." +desc);
					}				
				}
			}
			br.close();			
		}catch(IOException e){
			i.msg("\nNão foi possivél remover o registro.");
		}catch(NullPointerException e){
			i.msg("\nNão foi possivél remover o registro.");
		}
	}  
		
	
	/** 
	 * Realiza a salva edição do registro
	* 
	*/			
	public void salva() {
		i.objetoNaoImplementado();
	} 
		
	
	/** 
	 * Realiza alteração do registro
	* 
	*/
	public void altera() {
		i.objetoNaoImplementado();
	} 
}