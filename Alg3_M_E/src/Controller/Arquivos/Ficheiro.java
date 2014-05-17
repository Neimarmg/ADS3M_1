package  Controller.Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import model.Dados;
import Aplicacao.Prints;

/**
 * Classe responsavel pela manupulação do arquivo
 * @author Neimar,Aurelio
 */
public class Ficheiro extends Dados {
	
	Memoria memoria =  new Memoria();	
	static String linha;
	static FileReader file;
	static BufferedReader buff;	
	
	
	/**
	 * Verificador de memória
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			Prints.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica memória ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
				Prints.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				Prints.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			Prints.msgb("Não foi possível criar um novo arquivo.");
		}		
	}
	

	/** 
	 * Método de remoção de arquivo com verificação da existência do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			Prints.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			Prints.msgb("Arquivo não encontrado!\nNão é possível remover.");
		}
	} 
	
	
	/**
	 * @param nomeAquivo
	 */
	public static void validadaArquivo(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);				
		Prints.msg("Arquivo encontrado: " + p.toFile());
	}
	
	
	//=====================<< Leitor global de arquivos >>========================

	public static void carregaArquivo(String nomeArquivo, boolean criaVetor) throws Exception {
			
		try {
			setValidaArquivo(true); // Habilita execução de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;
				criaVetor(index, criaVetor);
			}
			buff.close();
			criaVetor(index, criaVetor);
				
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			setValidaArquivo(false); // Desabilita a execução de ordenador
			
		} catch (IOException e) {
			Prints.msge("\nO arquivo não pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nEspaço insufiente no array de armazenamento.\n");
		}		
	}
		
	
	/**
	 * Método de carregamento dos dados do arquivo para o vetor e strins
	 * @param index
	 * @param criaVetor
	 */
	public static void criaVetor(int index, boolean criaVetor) {
		if (criaVetor == true && linha != null) {
			vetor[index]= linha;
		}else{
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor após carregamento dos dados do arquivo
				vetor[i]= "";
			}
		}
	}	
	
		
}