package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

import Aplicacao.Interface;
import Utilitarios.Formatos;
import Utilitarios.crud;

public class Ficheiro {
	
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	crud n =  new crud();
	Memoria m =  new Memoria();
	
	/**
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			i.msg("\nVerificando disco...\n");
			if (m.calculaDisponivel() >= 6000) { // Verifica mem�ria ao inserir dados
				FileWriter c = new FileWriter(new File(nomeAquivo),true);
				i.msgb("Novo arquivo criado: "+c);
				c.close();
			} else {
				i.espacoInsuficiente();
				m.imprime();
			}
		} catch (Exception e) {
			i.msgb("N�o foi possiv�l criar um novo arquivo.");
		}		
	}
	

	/** 
	 * M�todo de remo��o de arquivo com verifica��o de exist�ncia do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) {
		String nome = nomeArquivo; 
		File f = new File(nome); 
		if (f.exists()){ 
			i.msgb("???" +f.getFreeSpace());
			f.delete();	
			i.msgb("O aquivo " +nome +" foi removido com sucesso.");			
		}else{			
			i.msgb("Arquivo n�o encontrado!\nN�o � poss�vel remover.");
		}
	} 
	
	
	/**
	 * @param nomeAquivo
	 */
	public void buscaExistente(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);
		i.msg("Arquivo encontrado: "+p);
	}
	
	/**
	 * @param nomeAquivo
	 * @throws Exception
	 */
	public void imprime(String nomeAquivo) throws Exception {
    	try {
			FileReader f = new FileReader(nomeAquivo);
			BufferedReader br = new BufferedReader(f);
			String linha = br.readLine();
			while(linha != null ) {
				linha = br.readLine();
				System.out.println(linha);
			}
			br.close();			
		} catch (FileNotFoundException e) {
			i.msgb("Nome do arquivo incorreto ou inexistente.");
			Interface a = new Interface();
			a.imprime();
		}
    }
}