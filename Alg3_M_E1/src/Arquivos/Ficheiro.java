package Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.file.Path;
import Aplicacao.Interface;
import Utilitarios.crud;
import Utilitarios.Prints;

public class Ficheiro {
	crud in =  new crud();
	Memoria memoria =  new Memoria();
	
	/**
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			Prints.msg("\nVerificando disco...\n");
			if (memoria.calculaDisponivel() >= 6000) { // Verifica mem�ria ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
				Prints.msgb("Novo arquivo criado: "+fw);
				fw.close();
			} else {
				Prints.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			Prints.msgb("N�o foi possiv�l criar um novo arquivo.");
		}		
	}
	

	/** 
	 * M�todo de remo��o de arquivo com verifica��o de exist�ncia do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) {
		String nome = nomeArquivo; 
		File file = new File(nome); 
		if (file.exists()){ 
			Prints.msgb("???" +file.getFreeSpace());
			file.delete();	
			Prints.msgb("O aquivo " +nome +" foi removido com sucesso.");			
		}else{			
			Prints.msgb("Arquivo n�o encontrado!\nN�o � poss�vel remover.");
		}
	} 
	
	
	/**
	 * @param nomeAquivo
	 */
	public void buscaExistente(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);
		Prints.msg("Arquivo encontrado: "+p);
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
			Prints.msgb("Nome do arquivo incorreto ou inexistente.");
			Interface Interface = new Interface();
			Interface.imprime();
		}
    }
}