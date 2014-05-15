package Aplicacao;

public class Prints {	
	
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
			"\n=====================================================================\n"
			+ desc
			+ "\n=====================================================================\n");
	}
	
	public static void msgc(Object desc) {
		System .out.print(
			"\n=====================================================================\n"
			+ desc);
	}

	public static void msgr(Object desc) {
		System .out.print(
			desc
			+ "\n=====================================================================\n");
	}	
	
	public static void msgl() {
		System .out.print(
			"\n=====================================================================\n");
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
	
	
	public static void sair() {
		System.err.print("\nVoc� optou por sair do programa. Obrigado.");
	}

}