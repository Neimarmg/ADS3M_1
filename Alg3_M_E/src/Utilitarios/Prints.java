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
	 * M�todo de retorno que recebe ficheiro label com par�mento e retorna
	 * uma string para filtros
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
	
	
	public static void mostarMenuMaim() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+"=> INSERIR   'Insere registros em arquivo'\n"
		+"=> CONSULTAR 'Conteudo do aquivo'\n"
		+"=> IMPRIMIR  'Imprim arquivo selecionado'\n"
		+"=> ARQUIVO   'Propriedades de arquivo'\n"
		+"=> SAIR\n");
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuInsert() throws Exception {
		msgb(
			"	GRAVAR DADOS EM: \n\n"	
			+"=> ARQUIVO 'Define qual arquivo o registro ser� inserido'\n"
			+"=> SAIR\n"
		);			
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuConsultas()throws Exception {	
		msgb(
			"	CONSULTAS EM: \n\n"	
			+"=> ARQUIVO 'Acessa um aquivo especificado para consulta'\n"
			+"=> BINARIA 'Realiza uma busca bin�ria em um aquivo ordendo'\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuImprimir()throws Exception {	
		msgb(
			"	MENU OP��ES DE IMPRESS�O:\n\n"	
			+"=> ARQUIVO 'Atalho para impress�o do conte�do do arquivo'\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/**	
	 * @throws Exception
	 */
	public static void  nomeArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> Nome.Exten��o\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> NOVO    'Cria um novo arquivo embranco'\n"
			+"=> BUSCAR  'Busca lista de aquivos exientes'\n"
			+"=> REMOVER 'Remove aquivo existente'\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuInserirNovo()throws Exception {	
		msgb(
			"	OP��ES PARA INSER��O DE DADOS:\n\n"	
			+"=> NOVO     'Abilita para grava novo registro'\n"
			+"=> IMPRIMIR 'Imprime dados ordenados em arquivo'\n"
			+"=> REMOVER  'remove logicamente o registro'\n"
			+"=> SAIR\n"
		);		
	}
	
	/**
	 * @throws Exception
	 */
	public static void menuConsultaArquivo()throws Exception {	
		msgb(
			"	OP��ES PARA CONSULTAR ARQUIVO:\n\n"	
			+"=> NAVEGAR  'Navega pelo arquivo com comando de teclado'\n"
			+"=> FILTRAR  'Encontra um registro especifico no arquivo'\n"
			+"=> ARQUIVO  'Imprime arquivo inteiro'\n"
			+"=> SAIR\n"
		);		
	}
}