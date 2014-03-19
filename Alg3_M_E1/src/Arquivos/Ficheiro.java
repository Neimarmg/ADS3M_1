package Arquivos;

import java.awt.PageAttributes;
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
	public void criaNovo(final String nomeAquivo){
		try {
			FileWriter c = new FileWriter(new File(nomeAquivo),true);
			i.msgb("Novo arquivo criado: "+c);
			c.close();
		} catch (Exception e) {
			i.msgb("Não foi possivél criar um novo arquivo!");
		}		
	}
	
	/** Metodo de remoção de arquivo com verificação de exintencia do arquivo.
	 * @param nomeArquivo
	 */
	public void removeArquivo(String nomeArquivo){
		String nome = nomeArquivo; 
		File f = new File(nome); 
		if (f.exists()){ 
			i.msgb("???" +f.getFreeSpace());
			f.delete();	
			i.msgb("O aquivo " +nome +" foi removido com sucesso!");			
		}else{			
			i.msgb("Arquivo mão encontrado!\nNão é possivél remover.");
		}
	} 
	
	
	public void buscaExistente(final String nomeAquivo){
		Path p = Paths.get(nomeAquivo);
		i.msg("Arquivo encontrado: "+p);
	}
	
	/**
	 * @param nomeAquivo
	 * @throws Exception
	 */
	public void imprimeDados(String nomeAquivo) throws Exception{
    	try {
			FileReader f = new FileReader(nomeAquivo);
			BufferedReader br = new BufferedReader(f);
			String linha = br.readLine();
			while(linha != null ){
				linha = br.readLine();
				System.out.println(linha);
			}
			br.close();			
		} catch (FileNotFoundException e) {
			i.msgb("O nome do arquivo esta incorreto ou não existe!");
			acoes a = new acoes();
			a.imprime();
		}
    }
}

