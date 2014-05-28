package M.Utilitarios;

import java.util.Scanner;

import App.Menus;
import App.View;

/**
 * Classe com m�todos globais de apoio � execu��o do programa
 * @author Neimar, Aur�lio
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	static String opcao; // Vari�vel global de apoio para par�metro "strings"
	static int contador = 0; // Vari�vel global contadora de a��oes 
	
	public static void setOpcao(String opcao) {
		Auxiliar.opcao = opcao;
	}
	
	 
	public static String getOpcao() {
		return opcao;
	}
	
	
	public static void setContador(boolean contar) {
		if (contar == true)
			Auxiliar.contador++; // Conta ações em tempo de execução
		}else {
			Auxiliar.contador = 0; //Limpa váriavel contadorea
		}
	}
	
	
	public static int getContador() {
		return contador;
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
		View.msg("\n");
		if (label.equals("")) {
			View.msg("COMANDO: ");
		} else {
			View.msg(label +": ");
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
			View.opcaoInvalida();			
			return defineOrdem(ativaMenu);
		}		
	}
}
