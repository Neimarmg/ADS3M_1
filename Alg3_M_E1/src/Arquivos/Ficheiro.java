package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	private Scanner sc;

	/**
	 * 
	 * @param nomeAquivo
	 */
	public void criaNovoArquivo(final String nomeAquivo){
		try {
			FileWriter c = new FileWriter(new File(nomeAquivo),true);
			i.msg("Novo arquivo criado: "+c);
			c.close();
		} catch (Exception e) {
			i.msg("N�o foi possiv�l criar um novo arquivo!");
		}		
	}
	
	/**
	 *   
	 * @param nomeArquivo
	 */
	public void removeArquivo(String nomeArquivo){
		String nome = nomeArquivo; 
		File f = new File(nome); 
		f.delete();
		i.msg("O aquivo " +nome +" foi removido!");
	} 
	
	
	public void buscaArquivoExistente(final String nomeAquivo){
		Path p = Paths.get(nomeAquivo);
		i.msg("Arquivo encontrado: "+p);
	}

	/**
	 * 
	 * @param nomeAquivo
	 * @throws Exception
	 */
	public void imprimeArquivo(String nomeAquivo) throws Exception{
    	try {
			FileReader f = new FileReader(nomeAquivo);
			BufferedReader br = new BufferedReader(f);
			String linha = br.readLine();
			while(linha !=null ){
				System.out.println(linha);
				linha = br.readLine();
			}
			br.close();			
		} catch (FileNotFoundException e) {
			i.msgb("O nome do arquivo esta incorreto ou n�o existe!");
			acoes a = new acoes();
			a.imprime();
		}
    }
}

