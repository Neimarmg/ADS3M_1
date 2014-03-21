package Utilitarios;

import java.util.Scanner;

public class Formatos {	
	Scanner var = new Scanner(System.in);
	
	
	public void msg(Object desc) {   
		System .out.print(desc);
	}
	
	
	/**
	 * @param desc
	 */
	public void msgb(Object desc) {
		System .out.print(
			"\n====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public void msgl() {
		System .out.print(
			"\n====================================================\n");
	}
	
	
	public void espacoInsuficiente() {
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}
	
	public void opcaoInvalida() {
		System .err.println("\nOpção de comando inválido. Tente novamente.");
	}
	
	
	public void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}
	

	/**Metodo de label dos comandos do sistema
	 * @param label
	 */
	public void paleta(String label) {
		System .out.println();
		if (label.equals("")){
			System .out.print("COMANDO: ");
		}else{
			System .out.print(label +": ");
		}
	}
	
	
	/**Método de retorno que recebe a label com parâmento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public String comando(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}	
	
	
	public void sair(){
		System.err.print("\nVocê optou por sair do programa. Obrigado.");
	}
	
	
	public void mostarMenuMaim() {		
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
	public void menuInsert() throws Exception {
		msgb(
			"	GRAVAR DADOS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> LISTA\n"
			+"=> AMBOS\n"
			+"=> SAIR\n"
		);			
	}
	
	
	/** 
	 * @throws Exception
	 */
	public void menuConsultas()throws Exception {	
		msgb(
			"	CONSULTAS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> LISTA\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public void menuImprimir()throws Exception {	
		msgb(
			"	MENU OPÇÕES DE IMPRESSÃO:\n\n"	
			+"=> ARQUIVO\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/**	
	 * @throws Exception
	 */
	public void  nomeArquivo()throws Exception {	
		msgb(
			"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
			+"=> Nome.Extenção\n"
			+"=> SAIR\n"
		);		
	}
	
	
	/** 
	 * @throws Exception
	 */
	public void menuArquivo()throws Exception {	
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
	public void  menuInserirNovo()throws Exception {	
		msgb(
			"	OPÇÕES PARA INSERÇÃO DE DADOS:\n\n"	
			+"=> NOVO\n"
			+"=> IMPRIMIR\n"
			+"=> EXCLUIR\n"
			+"=> SAIR\n"
		);		
	}
	
	/**
	 * @throws Exception
	 */
	public void  menuConsultaArquivo()throws Exception {	
		msgb(
			"	OPÇÕES PARA CONSULTAR ARQUIVO:\n\n"	
			+"=> NAVEGAR\n"
			+"=> FILTRAR\n"
			+"=> TODOS\n"
			+"=> SAIR\n"
		);		
	}
}