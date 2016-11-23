package V;

/*
 *Classe de view global
 *Autor Neimar
 */
public class View {	
	
	/*
	 * método da view personalizavel 
	 * @param desc
	 */
	public static void msg(Object desc) {   
		System .out.print(desc);
	}

	/*
	 * Método de impressão de messagem de erro
	 * @param desc
	 */
	public static void msge(Object desc) {   
		System .err.print(desc);
	}

	/**
	 * Método de impressao em bloco com duas linhas divisórias
	 * @param desc
	 */
	public static void msgb(Object desc) {
		System .out.print(
			  "\n=======================================================================\n"
			+ desc
			+ "\n=======================================================================\n");
	}
	
	/**
	 * Método de impressão linha divisória no cabeçalho
	 * @param desc
	 */
	public static void msgc(Object desc) {
		System .out.print(
			  "\n======================================================================\n"
			  + desc);
	}

	/**
	 * Método de impressão linha divisória no roda pé
	 * @param desc
	 */
	public static void msgr(Object desc) {
		System .out.print(
			  desc
			  + "\n=====================================================================\n");
	}	

	/**
	 * Método de impressão de linhas divisórias
	 */
	public static void msgl() {
		System .out.print(
			    "\n=====================================================================\n");
	}

	/**
	 * Mesagem padrão
	 */
	public static void espacoInsuficiente() {
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}

	/**
	 * Mensagem padrão para comando inválidos
	 */
	public static void opcaoInvalida() {
		System .err.println("\nComando inválido!");
	}

	/**
	 * Mensãogem de alerta para objeto não implementado no sistema
	 */
	public static void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}

	/**
	 * Mensagem de finalização do programa
	 */
	public static void sair() {
		System.err.print("\nVocê optou por sair do programa.");
		System.exit(0);
	}
	
		
	/**
	 * Método global de estruturação de menus de comandos do programa
	 */
	public static void imprimeMemu(String definitCabecalho , String listarComandos) {	
				
		msgb(definitCabecalho
		 + "|----------------------------------------------------------------------\n"
		 + "|Comando           |Descrição\n"          
		 + "|------------------|---------------------------------------------------\n"
		 +  listarComandos		
		 + "|" +"=> SAIR\n");		
	}
	
	
}