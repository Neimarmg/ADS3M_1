package model.Utilitarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Aplicacao.Menus;
import Aplicacao.Prints;

/**
 * Classe com m�todos globais de apoio � execu��o do programa
 * @author Neimar, Aur�lio
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	static String opcao; // Vari�vel global de apoio para par�metro "strings"
	
	
	public static void setOpcao(String opcao) {
		Auxiliar.opcao = opcao;
	}
	
	public static String getOpcao() {
		return opcao;
	}
	
	
	/**
	 * M�todo de defin��o de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status, int sucesso) {
		String r, s;	
		
		if (sucesso == 7) { // Avalia��o de sucesso da atividade
			s = "com sucesso!";
		} else if(sucesso == -1) {
			s = "sem sucesso"; 
		} else {
			s = "...";
		}
		
		switch (status) { // Definidor de "status" da atividade
		
		case -1:r = "Pendente " + s; 
			break;
		case 0:	r = "N�o definido " + s; 
			break;
		case 1:	r = "Em planejamento " + s; 
			break;
		case 2:	r = "Em desenvolvimento " + s; 
			break;
		case 3:	r = "Em teste " + s; 
			break;
		case 4:	r = "Em revis�o " + s; 
			break;
		case 5:	r = "Conclu�do(a) parcialmente " + s; 
			break;
		case 6:	r = "Conclu�do(a) " + s; 
			break;
		case 7:	r = "Finalizado(a) " + s; 
			break;		
		default:
			r = "inv�lido "; break;
		}
		
		return "Status: " +r;
	}
	
	
//============================================================================	
	
	/**
	 * M�todo de Label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		Prints.msg("\n");
		if (label.equals("")) {
			Prints.msg("COMANDO: ");
		} else {
			Prints.msg(label +": ");
		}
	}
	
	/**
	 * Valores boleanos
	 * @param label
	 * @return
	 */
	public static int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();
	}
	
	/**
	 * M�todo de retorno que recebe ficheiro "label" com par�metro,
	 * e retorna uma "string" para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
//============================================================================

	/**
	 * M�todo que define a ordem de ordena��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	public static boolean defineOrdem(Boolean ativaMenu) throws Exception {	
		Menus.menuModoOrdenacao(ativaMenu);
		String modo  = Auxiliar.digita("Ordem");
		
		if (modo.equals("c")) { // Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { // Define ordem decrescente
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineOrdem(ativaMenu);
		}		
	}
	
//=====================<< Leitor global de arquivos >>========================
	
	static boolean validaArquivo; 
	static int index = 0;
	static int tamanho = 60;
 	public static String vetor[] = new String[tamanho];
	static String linha;
	static FileReader file;
	static BufferedReader buff;	
	

	public static void carregaArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Habilita execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;				
			}			
			
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor ap�s carregamento dos dados do arquivo
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; // Desabilita a execu��o de ordenador
		
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nEspa�o insufiente no array de armazenamento.\n");
		}		
	}
	
	public static void setIndex(int index) {
		Auxiliar.index = index;
	}
	
	public static int getIndex() {
		return index;
	}
	
	public static boolean getValidaArquivo() {
		return validaArquivo;
	}

	public static String[] getVetor() {
		return vetor;
	}
}