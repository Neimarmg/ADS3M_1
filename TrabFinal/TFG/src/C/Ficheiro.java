package  C;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import M.Buffers;
import M.Utilitarios.Auxiliar;
import V.View;


/**
 * Classe responsável pela manipulação do arquivo
 * @author grupo
 */
public class Ficheiro extends Buffers {
		
	/**
	 * Método de digitação de dados dos campos a serem salvos no arquivo
	 * @param arquivo
	 * @param desc
	 * @throws IOException
	 */
	private static void digitaDados(String nomeArquivo) throws IOException {
		View.objetoNaoImplementado(); // Remover após implemetação
		
		Buffers.setAppend(true); // Ativador de inçersão
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
	 * Realiza ficheiro remoção lógica do registro
	 * @param arquivo
	 * @param desc
	 * @throws IOException
	 */
	public static void remove(String nomeArquivo, String  desc) throws IOException {
		View.objetoNaoImplementado(); // Remover após implemetação
	}


	/**
	 * Método global de leitura de arquivos
	 * @param nomeArquivo
	 * @param campo
	 * @param filtrar
	 * @param imprimir
	 * @throws Exception
	 */
	public static void leArquivo(String nomeArquivo, boolean criaVetor, String campo, boolean filtrar, boolean imprimir) throws Exception {
		
		try {
			
			setValidaArquivo(true); // Habilita execução de ordenador
			Buffers.setFile(new FileReader(nomeArquivo));		
			Buffers.setBuff(new BufferedReader(Buffers.getFile()));
			Buffers.setLinha(Buffers.getBuff().readLine());
			
			if (imprimir == true) { View.msgc("Impressão do arquivo: " + nomeArquivo + "\n\n");}

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
			setValidaArquivo(false); // Desabilita a execução de ordenador
			leArquivo(Auxiliar.digita("Nome do arquivo"), criaVetor, campo, filtrar, imprimir); // Correção quando inexistente

		} catch (IOException e) {
			View.msge("\nO arquivo não pode ser fechado.\n");
		}
	}
		
	
	private static void setValidaArquivo(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Método global de impressão de dados privado, acessado apenas condições de leitura do arquivo
	 * @param linha
	 * @param campo
	 * @param filtrar
	 */
	private static void imprimeDaDos(String linha, String campo, boolean filtrar, boolean imprimir) {
		
		if (imprimir == true) { // Habilita impressão ou não
			
			if (filtrar == true) { // Imprime dados coincidentes com o parâmetro	
				
				if (getLinha().equals(campo)) {		
					View.msg("\n> " + getLinha()  + "\n");
				}
			
			} else {
				View.msg("> " + getLinha() + "\n");
			}
		}
	}
	
}