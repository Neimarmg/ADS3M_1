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
		+ "=> JOGAR        'Abilita o jogador a jogar'\n"
		+ "=> PERSONALIZAR 'Personaliza nivel inicial de jogo'\n"
		+ "=> SAIR         'Sai o programa'\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+ "=> INICIAR  'Iniciar mapa de jogo'\n"
		+ "=> IMPRIMIR 'Imprimi op��es de jogo'\n"
		+ "=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+ "=> ATIRAR   'Abilita o jogador a inserir cordenadas'\n"
		+ "=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESS�O?\n\n"
		+ "=> MAPA    'Imprime mapa atual'\n"
		+ "=> NAVIOS  'Imprime navios existentes'\n"		
		+ "=> NIVEIS  'Imprime niveis de jogo'\n"
		+ "=> SOLDADO 'Imprime dodos do jogador'\n"
		+ "=> FILTRAR 'Filtra dados'\n"
		+ "=> TODOS   'Imprime todos os dados de jogo'\n"
		+ "=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESS�O?\n\n"
		+ "=> NAVIOS   'Op�ao de filtro'\n"		
		+ "=> NIVEIS   'Op�ao de filtro'\n"
		+ "=> RETORNAR 'Retorna ao menu imprimir'\n"
		+ "=> SAIR\n");
	}
}