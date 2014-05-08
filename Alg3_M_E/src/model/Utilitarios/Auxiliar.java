package model.Utilitarios;

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
			
<<<<<<< HEAD
		} else if (modo.equals("d")) { //Define ordem decrescente
=======
		} else if (modo.equals("dia")) { // Define ordem decrescente
>>>>>>> f2bcec69c2a9273dffdb5ffed6d1b8f1db661323
			return false;
			
		} else { // Comando de validação de modo de ordenação
			Prints.opcaoInvalida();			
			return defineOrdem(ativaMenu);
		}		
	}

}
