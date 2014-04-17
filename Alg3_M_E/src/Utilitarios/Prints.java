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
		System .err.println("\nComando inv�lido! Tente novamente?");
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
	 * M�todo de retorno que recebe ficheiro label com paramento e retorna
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
	
	
	public static void menuSelecinaAtividade() {		
		msgb("	QUAL � ATIVIDADE?\n\n"
		+"=> T1 'Listas encadeadas'\n"
		+"=> T2 'Pesquisa Bin�ria'\n"
		+"=> T4 'Algoritmos de ordena��o'\n"
		+"=> T5 '??'\n"
		+"=> SAIR\n");
	}
	
	public static void mostarMenuT1() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+"=> INSERIR   'Insere registros em arquivo'\n"
		+"=> CONSULTAR 'Conte�do do arquivo'\n"
		+"=> IMPRIMIR  'Imprime arquivo selecionado'\n"
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
			+"=> ARQUIVO 'Acessa um arquivo especificado para consulta'\n"
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
			+"=> Nome.Extens�o\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> NOVO    'Cria um novo arquivo em branco'\n"
			+"=> BUSCAR  'Busca lista de arquivos existentes'\n"
			+"=> REMOVER 'Remove arquivo existente'\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public static void menuInserirNovo()throws Exception {	
		msgb(
			"	OP��ES PARA INSER��O DE DADOS:\n\n"	
			+"=> NOVO       'Habilita para grava novo registro'\n"
			+"=> IMPRIMIR 'Imprime dados ordenados em arquivo'\n"
			+"=> REMOVER  'Remove logicamente o registro'\n"
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
			+"=> FILTRAR      'Encontra um registro especifico no arquivo'\n"
			+"=> ARQUIVO   'Imprime arquivo inteiro'\n"
			+"=> SAIR\n"
		);		
	}

		/**
	* Metodo respons�vel pela execu��o das formas de ordena��o
	 * @throws Exception
	 */
	public static void menuOrdenadores()throws Exception {	
		msgb(
			"	ORDENAR DADOS COM?:\n\n"	
			+"=> BOBLE          'Ordena dados do arquivo com BubleSort'\n"
			+"=> QUICK           'Ordena dados do arquivo com QuickSort'\n"
			+"=> COMPARAR  'Imprime dados estat�sticos dos dois ordenadores \n"
			+"=> SAIR\n"
		);		
	}

}
