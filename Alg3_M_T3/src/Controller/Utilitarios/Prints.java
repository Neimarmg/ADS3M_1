package Controller.Utilitarios;

import java.util.Scanner;


public class Prints {	
	static Scanner var = new Scanner(System.in);
	
	public static void msg(Object desc) {   
		System .out.print(desc);
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
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}
	
	
	public static void opcaoInvalida() {
		System .err.println("\nOpção de comando inválido. Tente novamente.");
	}
	
	
	public static void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}
	

	/**
	 * Método de label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		System .out.println();
		if (label.equals("")){
			System .out.print("COMANDO: ");
		}else{
			System .out.print(label +": ");
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
	 * Método de retorno que recebe a label com parâmento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public static String comando(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	public static void sair(){
		System.err.print("\nVocê optou por sair do jogo. Obrigado.");
	}
	
	
	public static void menuJogar() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+"=> JOGAR\n"
		+"=> DEFINIR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+"=> INICIAR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+"=> ATIRAR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESSÃO?\n\n"
		+"=> MAPA\n"
		+"=> NAVIOS\n"		
		+"=> NIVEIS\n"
		+"=> SOLDADO\n"
		+"=> FILTRAR\n"
		+"=> TODOS\n"
		+"=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESSÃO?\n\n"
		+"=> NAVIOS\n"		
		+"=> NIVEIS\n"
		+"=> RETORNAR\n"
		+"=> SAIR\n");
	}
}