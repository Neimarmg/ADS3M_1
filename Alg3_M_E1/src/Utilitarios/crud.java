package Utilitarios;

import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Arquivos.Ficheiro;

public class crud {
	String acun = "";
		
	/**
	 * Insere novo registro em arquivo .txt!
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void addNovo(String arquivo,String  desc, Boolean edita ) throws IOException {
		FileWriter f;
		BufferedWriter buff = null;
		try {
			f = new FileWriter(new File(arquivo),edita);
			buff = new BufferedWriter(f);			
			
			if (edita == true){	
				buff.newLine();
			}			
			buff.write(desc);			
			buff.close();	
			Prints.msgb("Registro pasei:");
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
		BufferedReader br;
		
		try {
			FileReader r = new FileReader(nomeArquivo);
			br = new BufferedReader(r);
			String linha = br.readLine();			
			
			while(linha != null ){
				linha = br.readLine();
				if (linha.equals(desc)){					
					acun += "# "+linha +"\n";
					addNovo(nomeArquivo, acun, true);
				}else{
					acun += linha +"\n";
					addNovo(nomeArquivo, acun, true);
				}
			}
			//Prints.msgb("AA ." +acun);
			
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
	    System.exit(0);
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





/**
  FileReader fileReader = null;    
	    FileWriter fileWriter = null;     
	    BufferedReader leitor = null;    
	    String line = "";    
	              
	       
	    fileWriter = new FileWriter(new File(nomeArquivo));   
	    leitor = new BufferedReader(fileReader);  
	    line = "";    
	    try { 
	        	
	    	while ((line = leitor.readLine()) != null) {    
	        	if (desc.equals(leitor)){
	        		if(!line.trim().equals(desc.trim())) {   
	        			fileWriter.write(line + "\r\n");
	        			Prints.msg("ddddddddddddddddd ");
	        		}
	            }    
	        }	                
	        
	        } catch (IOException e) {    
	        	Prints.msg("sssssssssssssss "); 
	        	
	        }catch (NullPointerException e1) {    
	        	Prints.msg("sssssssssssssss ");
	        }
	    System.exit(0);
*/