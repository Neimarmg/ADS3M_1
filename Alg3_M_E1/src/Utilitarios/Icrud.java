package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Icrud {
	int contador=0;
	
	
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
	public void remove(String nomeArquivo, String  desc) throws IOException {                 
	       
	    FileReader fileReader = null;    
	    FileWriter fileWriter = null;     
	    BufferedReader leitor = null;    
	            
	    //String nomeDoArquivo = nomeArquivo;  
	    //String arquivoConferir = "d.txt";    
	    String line = " i ";    
	              
	    try {    
	    	//fileReader = new FileReader(new File(nomeDoArquivo));    
	        fileWriter = new FileWriter(new File(nomeArquivo));   
	        leitor = new BufferedReader(fileReader);  
	        line = "";    
	                  
	        while ((line = leitor.readLine()) != null) {    
	        	if(!line.trim().equals(desc.trim())) {   
	        		
	        		fileWriter.write(line + "\r\n");
	        		//Prints.msge("dddddd  " +fileWriter);
	            }    
	        }	                
	        
	        } catch (NullPointerException e) {    
	        	e.printStackTrace(); 
	        	
	        } finally {    
	        
	        try {    
	             fileWriter.close();  
	            // fileReader.close();    
	        } catch (IOException e) {    
	        	e.printStackTrace();    
	        }      
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