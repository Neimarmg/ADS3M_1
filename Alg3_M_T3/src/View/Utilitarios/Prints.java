package View.Utilitarios;

import java.util.Scanner;

/**
 * Classe respons�vel pela impress�o do programa 
 * @author Neimar, Aur�lio
 */
public class Prints {	
	static Scanner var = new Scanner(System.in);
	
	public static void msg(Object desc) {   
		System .out.print(desc);
	}
	
	
	public static void msge(Object desc) {   
		System .err.print(desc);
	}
	
	
	/**
	 * @param desc
	 */
	public static void msgb(Object desc) {
		System .out.print(
			"\n====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public static void msgc(Object desc) {
		System .out.print(
			"\n====================================================\n"
			+desc);
	}


	public static void msgr(Object desc) {
		System .out.print(
			desc
			+"\n====================================================\n");
	}	
	

	public static void msgl() {
		System .out.print(
			"\n====================================================\n");
	}
	
	
	public static void espacoInsuficiente() {
		System .err.print("\nEspa�o insuficiente em disco para inserir dados.\n");
	}
	
	
	public static void opcaoInvalida() {
		System .err.println("\nOp��o de comando inv�lido. Tente novamente.");
	}
	
	
	public static void objetoNaoImplementado() {
		System .err.print("\nN�o implementado.\n");
	}
	

	/**
	 * M�todo de label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		System .out.println();
		if (label.equals("")) {
			System .out.print("COMANDO: ");
		} else {
			System .out.print(label + ": ");
		}
	}
	
	
	/**
	 * Valores "booleans"
	 * @param label
	 * @return
	 */
	public static int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();		
	}
	
	
	/**
	 * M�todo de retorno que recebe a label com par�mento, e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	
	public static void sair() {
		System.err.print("\nVoc� optou por sair do jogo. Obrigado.");
	}
	
	
	public static void menuJogar() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+ "=> JOGAR\n"
		+ "=> PERSONALIZAR\n"
		+ "=> SAIR\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+ "=> INICIAR\n"
		+ "=> IMPRIMIR\n"
		+ "=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+ "=> ATIRAR\n"
		+ "=> IMPRIMIR\n"
		+ "=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESS�O?\n\n"
		+ "=> MAPA\n"
		+ "=> NAVIOS\n"		
		+ "=> NIVEIS\n"
		+ "=> SOLDADO\n"
		+ "=> FILTRAR\n"
		+ "=> TODOS\n"
		+ "=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESS�O?\n\n"
		+ "=> NAVIOS\n"		
		+ "=> NIVEIS\n"
		+ "=> RETORNAR\n"
		+ "=> SAIR\n");
	}
}