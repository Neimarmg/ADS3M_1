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
	 * Método de retorno que recebe ficheiro label com parâmento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	
	public static void sair(){
		System.err.print("\nVocê optou por sair do programa. Obrigado.");
	}
	
	
	public static void mostarMenuMaim() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+"=> INSERIR\n"
		+"=> CONSULTAR\n"
		+"=> IMPRIMIR\n"
		+"=> ARQUIVO\n"
		+"=> SAIR\n");
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuInsert() throws Exception {
		msgb(
			"	GRAVAR DADOS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> SAIR\n"
		);			
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuConsultas()throws Exception {	
		msgb(
			"	CONSULTAS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> BINARIA\n"
			//+"=> LISTA\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuImprimir()throws Exception {	
		msgb(
			"	MENU OPÇÕES DE IMPRESSÃO:\n\n"	
			+"=> ARQUIVO\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/**	
	 * @throws Exception
	 */
	public static void  nomeArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> Nome.Extenção\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> NOVO\n"
			+"=> BUSCAR\n"
			+"=> REMOVER\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuInserirNovo()throws Exception {	
		msgb(
			"	OPÇÕES PARA INSERÇÃO DE DADOS:\n\n"	
			+"=> NOVO\n"
			+"=> IMPRIMIR\n"
			+"=> REMOVER\n"
			+"=> SAIR\n"
		);		
	}
	
	/**
	 * @throws Exception
	 */
	public static void menuConsultaArquivo()throws Exception {	
		msgb(
			"	OPÇÕES PARA CONSULTAR ARQUIVO:\n\n"	
			+"=> NAVEGAR\n"
			+"=> FILTRAR\n"
			+"=> TODOS\n"
			+"=> SAIR\n"
		);		
	}
}