package M.Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.View;
import M.Buffers;

/**
 * Classe para edi��o e arquivos
 * @author moises
 */
public class Include {
	static String acun = "";
	private static Boolean append = false;
	
	
	public static void setAppend(Boolean append) {
		Include.append = append;
	}
	
	
	public static Boolean getAppend() {
		return append;
	}

	
	/**
	 * Insere novo registro em arquivo .txt
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public static void addNovo(String arquivo,String  desc) throws IOException {
		FileWriter f;
		BufferedWriter buff = null;
		
		try { 
			f = new FileWriter(new File(arquivo),getAppend());
			buff = new BufferedWriter(f);			
			
			if (getAppend() == true) {	
				buff.newLine();				
			}			
			buff.write(desc);			
			buff.close();	
		
		} catch (IOException e) {
			View.msg("N�o foi possiv�l inserir registro.");
		} finally {
			buff.close();
		}
	}
	
	
	/**
	 * Realiza ficheiro remo��o l�gica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public static void remove(String nomeArquivo, String  desc) throws IOException {                 
		Buffers.setFile(new FileReader(nomeArquivo));
		Buffers.setBuff(new BufferedReader(Buffers.getFile()));
		Buffers.setLinha(Buffers.getBuff().readLine());		
		
		try {				
			while(Buffers.getLinha()!= null ) {	
				
				if (Buffers.getLinha().equals(desc)) {	
					acun += "#"+Buffers.getLinha() +"\n";
					View.msge("\nRegistro excluido com sucesso!\n");
					setAppend(false);					
				} else {
					acun += Buffers.getLinha() +"\n";
					setAppend(true);
				}
				Buffers.setLinha(Buffers.getBuff().readLine());
			}			
			 Buffers.getBuff().close();
			addNovo(nomeArquivo, acun);
		
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			View.msgb("Arquivo inexistente.");
		}	  
	}    
        	
	
	/** 
	 * Realiza ficheiro salva edi��o do registro
	* 
	*/			
	public static void salva() {
		View.objetoNaoImplementado();
	} 
		
	
	/** 
	 * Realiza altera��o do registro
	* 
	*/
	public static void altera() {
		View.objetoNaoImplementado();
	} 
}
