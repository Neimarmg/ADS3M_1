package Arquivos;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

import Aplicacao.acoes;
import Utilitarios.Formatos;
import Utilitarios.Include;

public class Ficheiro {
	
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	Include n =  new Include();
	acoes a = new acoes();
	private Scanner sc;

	
	public void criaNovoArquivo(final String nomeAquivo){
		try {
			FileWriter p = new FileWriter(new File(nomeAquivo),true);
			i.msg("Novo arquivo criado: "+p);
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
	public void buscaArquivoExistente(final String nomeAquivo){
		Path p = Paths.get(nomeAquivo);
		i.msg("Arquivo encontrado: "+p);
	}
	          
	      
    public void imprimeArquivo(String nomeAquivo){
    	try {
	        File file = new File(nomeAquivo);        	 
	        FileInputStream in = new FileInputStream(file);
	        
			sc = new Scanner(in);  
			i.msgl();
			while (sc.hasNext()) {
				String readLine = sc.next();				 
				i.msg("\n" +readLine.toString());
			}
			i.msgl();
			
		} catch (FileNotFoundException e) {
			i.msg("O nome do arquivo esta incorreto ou não existe!");
			i.msgOpcaoInvalida();
		}
    }	

}
