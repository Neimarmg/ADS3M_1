package  Controller.Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Dados;
import model.Utilitarios.Auxiliar;
import Aplicacao.Prints;
import Controller.Registrador;

/**
 * Classe responsavel pela manupula��o do arquivo
 * @author Neimar,Aurelio
 */
public class Ficheiro extends Dados {
	
	Memoria memoria =  new Memoria();
	static String linha;
	static FileReader file;
	static BufferedReader buff;	

	/**
	 * Verificador de mem�ria
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			Prints.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica mem�ria ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
				Prints.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				Prints.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			Prints.msgb("N�o foi poss�vel criar um novo arquivo.");
		}		
	}
	

	/** 
	 * M�todo de remo��o de arquivo com verifica��o da exist�ncia do arquivo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			Prints.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			Prints.msgb("Arquivo n�o encontrado!\nN�o � poss�vel remover.");
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

	public static void leArquivo(String nomeArquivo, boolean criaVetor) throws Exception {
		
		try {
			setValidaArquivo(true); // Habilita execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;
				
				if (criaVetor == true){
					insertVetor(index, criaVetor);
				}else{
					Registrador.arquivo(linha);
				}
				
				imprimeDaDos(linha,"", false);
			
			}
			buff.close();	
			
		} catch (NullPointerException e) {
			Prints.msge("\nArquivo carregado em " +Auxiliar.getOpcao().toLowerCase() +" com sucesso!\n");
					
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			setValidaArquivo(false); // Desabilita a execu��o de ordenador
				
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nEspa�o insufiente no array de armazenamento.\n");
		}		
	}
		
	
	/**
	 * M�todo de carregamento dos dados do arquivo para o vetor e strins
	 * @param index
	 * @param criaVetor
	 */
	public static void insertVetor(int index, boolean criaVetor) {
		if (criaVetor == true && linha != null) {
			vetor[index]= linha;			
		}
		
		if (criaVetor == true && linha == null){
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor ap�s carregamento dos dados do arquivo
				vetor[i]= "";
			}
		}
		
	}	
	
	
	public static void imprimeDaDos(String linha, String campo, boolean filtrar) {
		
		if (filtrar == true) { // Imprime dados coincidentes com o par�metro	
			if (linha.equals(campo)) {				
				Prints.msg("> " +linha  + "\n");
			}else{
				Prints.msg("\nN�o foram encontrado dados coincidentes! " +campo  +"\n");
			}
				
		} else {
			Prints.msg("> " + linha + "\n");
		}			
	}
		
}