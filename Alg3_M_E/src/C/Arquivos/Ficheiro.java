package  C.Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import App.View;
import C.Registrador;
import M.Buffers;
import M.Dados;

/**
 * Classe respons�vel pela manipula��o do arquivo
 * @author Neimar, Aur�lio
 */
public class Ficheiro extends Dados {

	Memoria memoria =  new Memoria();

	
	/**
	 * Verificador de mem�ria
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			View.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica mem�ria ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo), true);
				View.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				View.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			View.msgb("N�o foi poss�vel criar um novo arquivo.");
		}		
	}
	

	/** 
	 * M�todo de remo��o de arquivo com verifica��o da exist�ncia do mesmo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			View.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			View.msgb("Arquivo n�o encontrado!\nN�o � poss�vel remover.");
		}
	} 


	/**
	 * @param nomeAquivo
	 */
	public static void validadaArquivo(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);				
		View.msg("Arquivo encontrado: " + p.toFile());
	}
	
	
	//=====================<< Leitor global de arquivos >>========================

	public static void leArquivo(String nomeArquivo, boolean criaVetor, String campo, boolean filtrar, boolean imprimir) throws Exception {
		
		try {
			setValidaArquivo(true); // Habilita execu��o de ordenador
			Buffers.setFile(new FileReader(nomeArquivo));		
			Buffers.setBuff(new BufferedReader(Buffers.getFile()));
			Buffers.setLinha(Buffers.getBuff().readLine());
			if(imprimir == true) { View.msgc(" Impress�o do arquivo: " + nomeArquivo + "\n\n");}
			
			while(Buffers.getLinha() != null ) {
				Buffers.setLinha(Buffers.getBuff().readLine());
				index++;
				
				if (criaVetor == true) {
					insertVetor(index, criaVetor); // M�todo de transfer�ncia de dados de arquivo para vetor
				} else {
					Registrador.copiaArquivo(Buffers.getLinha()); // M�todo de inser��o nas estruturas de dados
				}				
				imprimeDaDos(Buffers.getLinha(), campo, filtrar, imprimir); // M�todo de impress�o de dados. Imprime quando habilitado 			
			}
			Buffers.getBuff().close();	
			
		} catch (NullPointerException e) {
			View.msgr("\nArquivo carregado com sucesso.");

		} catch (FileNotFoundException e) {
			View.msge("\nArquivo inexistente\n");
			setValidaArquivo(false); // Desabilita a execu��o de ordenador
				
		} catch (IOException e) {
			View.msge("\nO arquivo n�o pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msge("\nEspa�o insufiente no array de armazenamento.\n");
		}		
	}
		
	
	/**
	 * M�todo de carregamento dos dados do arquivo para o vetor
	 * @param index
	 * @param criaVetor
	 */
	protected static void insertVetor(int index, boolean criaVetor) {
		if (criaVetor == true && Buffers.getLinha() != null) {
			vetor[index]= Buffers.getLinha();
		}

		if (criaVetor == true && Buffers.getLinha() == null) {
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor ap�s carregamento dos dados do arquivo
				vetor[i]= "";
			}
		}
		
	}
	
	/**
	 * M�todo global de impress�o de dados 
	 * @param linha
	 * @param campo
	 * @param filtrar
	 */
	protected static void imprimeDaDos(String linha, String campo, boolean filtrar, boolean imprimir) {
		if (imprimir == true) { // Habilita impress�o ou n�o.
			if (filtrar == true) { // Imprime dados coincidentes com o par�metro	
				if (linha.equals(campo)) {		
					View.msg("\n> " + linha  + "\n");
				}
			} else {
				View.msg("> " + linha + "\n");
			}
		}
	}
		
}