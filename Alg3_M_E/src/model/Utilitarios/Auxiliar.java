package model.Utilitarios;

import java.util.Scanner;

import Wiew.Menus;
import Wiew.Prints;

/**
 * Classe com metodos globais do programa
 * @author Neimar
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	
	/**
	 * M�todo de defin��o de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status){
		String r;		
		switch (status) {
		
		case -1:	r = "Pendente "; 
			break;
		case 0:	r = "N�o definido "; 
			break;
		case 1:	r = "Em planejamento "; 
			break;
		case 2:	r = "Em desenvolvimento "; 
			break;
		case 3:	r = "Em testes "; 
			break;
		case 4:	r = "Em revis�o "; 
			break;
		case 5:	r = "Conclu�do(a) parcialmente "; 
			break;
		case 6:	r = "Conclu�do(a) "; 
			break;
		case 7:	r = "Finalizado(a) "; 
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
		if (label.equals("")){
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
	 * M�todo de retorno que recebe ficheiro label com par�metro,
	 * e retorna uma string para filtros
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
	public static boolean defineOrdem(Boolean ativaMenu) throws Exception{	
		Menus.menuModoOrdenacao(ativaMenu);
		String modo  = Auxiliar.digita("Ordem");
		
		if (modo.equals("c")) { //Define ordem crescente
			return true;
			
		} else if (modo.equals("dia")) { //Define ordem decrescente
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineOrdem(ativaMenu);
		}		
	}

}
