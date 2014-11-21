package  C;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import M.Buffers;
import M.Utilitarios.Auxiliar;
import V.View;


/**
 * Classe respons�vel pela manipula��o do arquivo
 * @author grupo
 */
public class Ficheiro extends Buffers {
		
	/**
	 * M�todo de digita��o de dados dos campos a serem salvos no arquivo
	 * @param arquivo
	 * @param desc
	 * @throws IOException
	 */
	private static void digitaDados(String nomeArquivo) throws IOException {
		View.objetoNaoImplementado(); // Remover ap�s implemeta��o
		
		Buffers.setAppend(true); // Ativador de in�ers�o
		Buffers.setLinha("?"); // Formatada nova linha a ser inserida
	}
	
	
	/**
	 * Insere novo registro em arquivo .txt
	 * @param arquivo
	 * @param desc
	 * @throws IOException
	 */
	public static void addNovo(String nomeArquivo) throws IOException {
		digitaDados(nomeArquivo);
	}


	/**
	 * Realiza ficheiro remo��o l�gica do registro
	 * @param arquivo
	 * @param desc
	 * @throws IOException
	 */
	public static void remove(String nomeArquivo, String  desc) throws IOException {
		View.objetoNaoImplementado(); // Remover ap�s implemeta��o
	}


	/**
	 * M�todo global de leitura de arquivos
	 * @param nomeArquivo
	 * @param campo
	 * @param filtrar
	 * @param imprimir
	 * @throws Exception
	 */
	public static void leArquivo(String nomeArquivo, boolean criaVetor, String campo, boolean filtrar, boolean imprimir) throws Exception {
		
		try {
			
			setValidaArquivo(true); // Habilita execu��o de ordenador
			Buffers.setFile(new FileReader(nomeArquivo));		
			Buffers.setBuff(new BufferedReader(Buffers.getFile()));
			Buffers.setLinha(Buffers.getBuff().readLine());
			
			if (imprimir == true) { View.msgc("Impress�o do arquivo: " + nomeArquivo + "\n\n");}

			while (Buffers.getLinha() != null ) {
				Buffers.setLinha(Buffers.getBuff().readLine());				
				imprimeDaDos(getLinha(), campo, filtrar, imprimir);
				Carregador.carregaDados(getLinha());	
			}
			Buffers.getBuff().close();	

		} catch (NullPointerException e) {
			View.msgr("\nArquivo carregado com sucesso.");

		} catch (FileNotFoundException e) {
			View.msge("\nArquivo inexistente\n");
			setValidaArquivo(false); // Desabilita a execu��o de ordenador
			leArquivo(Auxiliar.digita("Nome do arquivo"), criaVetor, campo, filtrar, imprimir); // Corre��o quando inexistente

		} catch (IOException e) {
			View.msge("\nO arquivo n�o pode ser fechado.\n");
		}
	}
		
	
	private static void setValidaArquivo(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * M�todo global de impress�o de dados privado, acessado apenas condi��es de leitura do arquivo
	 * @param linha
	 * @param campo
	 * @param filtrar
	 */
	private static void imprimeDaDos(String linha, String campo, boolean filtrar, boolean imprimir) {
		
		if (imprimir == true) { // Habilita impress�o ou n�o
			
			if (filtrar == true) { // Imprime dados coincidentes com o par�metro	
				
				if (getLinha().equals(campo)) {		
					View.msg("\n> " + getLinha()  + "\n");
				}
			
			} else {
				View.msg("> " + getLinha() + "\n");
			}
		}
	}
	
}