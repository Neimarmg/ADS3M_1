package model.Utilitarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Aplicacao.Menus;
import Aplicacao.Prints;

/**
 * Classe com métodos globais de apoio a execução do programa
 * @author Neimar, Aurélio
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	static String opcao; // Variável global de apoio para parâmetro "strings"
	
	
	public static void setOpcao(String opcao) {
		Auxiliar.opcao = opcao;
	}
	
	public static String getOpcao() {
		return opcao;
	}
	
	
	/**
	 * Método de definção de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status) {
		String r;		
		switch (status) {
		
		case -1:	r = "Pendente "; 
			break;
		case 0:	r = "Não definido "; 
			break;
		case 1:	r = "Em planejamento "; 
			break;
		case 2:	r = "Em desenvolvimento "; 
			break;
		case 3:	r = "Em teste "; 
			break;
		case 4:	r = "Em revisão "; 
			break;
		case 5:	r = "Concluído(a) parcialmente "; 
			break;
		case 6:	r = "Concluído(a) "; 
			break;
		case 7:	r = "Finalizado(a) "; 
			break;		
		default:
			r = "inválido "; break;
		}
		return "Status: " +r;
	}
	
	
//============================================================================	
	
	/**
	 * Método de Label dos comandos do sistema
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
	 * Método de retorno que recebe ficheiro label com parâmetro,
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
	 * Método que define a ordem de ordenação para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	public static boolean defineOrdem(Boolean ativaMenu) throws Exception {	
		Menus.menuModoOrdenacao(ativaMenu);
		String modo  = Auxiliar.digita("Ordem");
		
		if (modo.equals("c")) { // Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { //Define ordem decrescente
			return false;
			
		} else { // Comando de validação de modo de ordenação
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
			validaArquivo = true; // Abilita execução de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;				
			}			
			
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor após carregamento dos dados do arquivo
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; // Desabilita a execução de ordenador
		
		} catch (IOException e) {
			Prints.msge("\nO arquivo não pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nEspaço insufiente no array de armazenamento.\n");
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
	
	public static void setVetor(String[] vetor) {
		Auxiliar.vetor = vetor;
	}
	
	public static String[] getVetor() {
		return vetor;
	}
}
