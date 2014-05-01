package Utilitarios;

import java.util.Scanner;

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
		System .err.println("\nComando inv�lido!");
	}
	
	
	public static void objetoNaoImplementado() {
		System .err.print("\nN�o implementado.\n");
	}
	
	/**
	 * M�todo de Label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		System .out.println();
		if (label.equals("")){
			System .out.print("COMANDO: ");
		} else {
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
	 * M�todo de retorno que recebe ficheiro label com par�metro,
	 * e retorna uma string para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	public static void sair(){
		System.err.print("\nVoc� optou por sair do programa. Obrigado.");
	}
	
	
	/**
	 * M�todo de defin��o de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String status(int status){
		String r;
		
		switch (status) {
		
		case 0:	r = "N�o definido "; break;
		case 1:	r = "Em planejamento "; break;
		case 2:	r = "Em desenvolvimento "; break;
		case 3:	r = "Em testes "; break;
		case 4:	r = "Em revis�o "; break;
		case 5:	r = "Conclu�do(a) parcialmente "; break;
		case 6:	r = "Conclu�do(a) "; break;
		case 7:	r = "Finalizado(a) "; break;
		
		default:
			r = "inv�lido "; break;
		}

		return "Status: " +r;
	}


}