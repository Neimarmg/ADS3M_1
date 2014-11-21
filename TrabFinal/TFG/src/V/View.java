package V;

/*
 *Classe de view global
 *Autor Neimar
 */
public class View {	
	
	/*
	 * m�todo da view personalizavel 
	 * @param desc
	 */
	public static void msg(Object desc) {   
		System .out.print(desc);
	}

	/*
	 * M�todo de impress�o de messagem de erro
	 * @param desc
	 */
	public static void msge(Object desc) {   
		System .err.print(desc);
	}

	/**
	 * M�todo de impressao em bloco com duas linhas divis�rias
	 * @param desc
	 */
	public static void msgb(Object desc) {
		System .out.print(
			  "\n=======================================================================\n"
			+ desc
			+ "\n=======================================================================\n");
	}
	
	/**
	 * M�todo de impress�o linha divis�ria no cabe�alho
	 * @param desc
	 */
	public static void msgc(Object desc) {
		System .out.print(
			  "\n======================================================================\n"
			  + desc);
	}

	/**
	 * M�todo de impress�o linha divis�ria no roda p�
	 * @param desc
	 */
	public static void msgr(Object desc) {
		System .out.print(
			  desc
			  + "\n=====================================================================\n");
	}	

	/**
	 * M�todo de impress�o de linhas divis�rias
	 */
	public static void msgl() {
		System .out.print(
			    "\n=====================================================================\n");
	}

	/**
	 * Mesagem padr�o
	 */
	public static void espacoInsuficiente() {
		System .err.print("\nEspa�o insuficiente em disco para inserir dados.\n");
	}

	/**
	 * Mensagem padr�o para comando inv�lidos
	 */
	public static void opcaoInvalida() {
		System .err.println("\nComando inv�lido!");
	}

	/**
	 * Mens�ogem de alerta para objeto n�o implementado no sistema
	 */
	public static void objetoNaoImplementado() {
		System .err.print("\nN�o implementado.\n");
	}

	/**
	 * Mensagem de finaliza��o do programa
	 */
	public static void sair() {
		System.err.print("\nVoc� optou por sair do programa.");
		System.exit(0);
	}
	
		
	/**
	 * M�todo global de estrutura��o de menus de comandos do programa
	 */
	public static void imprimeMemu(String definitCabecalho , String listarComandos) {	
				
		msgb(definitCabecalho
		 + "|----------------------------------------------------------------------\n"
		 + "|Comando           |Descri��o\n"          
		 + "|------------------|---------------------------------------------------\n"
		 +  listarComandos		
		 + "|" +"=> SAIR\n");		
	}
	
	
}