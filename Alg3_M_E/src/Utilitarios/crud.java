package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe para edi��o e arquivos
 * @author moises
 */
public class crud {
	String acun = "";
	Boolean edita = true;
	
	/**
	 * Insere novo registro em arquivo .txt!
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void addNovo(String arquivo,String  desc) throws IOException {
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
		} catch (IOException e) {
			Prints.msg("N�o foi possiv�l inserir registro.");
		}finally{
			buff.close();
		}
	}
		
	
	/**
	 * Realiza ficheiro remo��o l�gica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public void remove(String nomeArquivo, String  desc) throws IOException {                 
		BufferedReader br;
		FileReader r = new FileReader(nomeArquivo);
		br = new BufferedReader(r);
		String linha = br.readLine();		
		try {				
			while(linha != null ){	
				
				if (linha.equals(desc)){	
					acun += "#"+linha +"\n";
					edita = true;
					}else{
					acun += linha +"\n";
					edita = false;					
				}
				linha = br.readLine();
			}
			addNovo(nomeArquivo, acun);
			br.close();
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
	  
	}    
        	
		  
		
	
	/** 
	 * Realiza ficheiro salva edi��o do registro
	* 
	*/			
	public void salva() {
		Prints.objetoNaoImplementado();
	} 
		
	
	/** 
	 * Realiza altera��o do registro
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