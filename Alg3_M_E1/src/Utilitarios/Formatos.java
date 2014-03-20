package Utilitarios;

import java.util.Scanner;

public class Formatos {	
	Scanner var = new Scanner(System.in);
	
	
	public void msg(Object desc){
		// imprime na tale mem�ria dispPlanejamento inicial    
		System .out.print(desc);
	}
	
	
	/**
	 * @param desc
	 */
	public void msgb(Object desc){
		System .out.print(
			"\n====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public void msgl(){
		System .out.print(
			"\n====================================================\n");
	}
	
	
	public void opcaoInvalida(){
		System .err.println("\nOp��o de comando inv�lido. Tente novamente!");
	}
	
	
	public void naoImplementado(){
		System .err.print("\nN�o implementado!\n");
	}
	
	
	/**Metodo de label dos comando do sistema
	 * @param label
	 */
	public void paleta(String label){
		System .out.println();
		if (label.equals("")){
			System .out.print("COMANDO: ");
		}else{
			System .out.print(label +": ");
		}
	}
	
	
	/**Medotodo de retorno que recebe a lobel com paramento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public String comando(String label){
		paleta(label);
		return var.next().toLowerCase();
	}	
	
	
	public void sair(){
		System.err.print("\nVoc� optou por sair do programa\n"
			+ "Obrigado!!!");;
	}
	
	
	/** 
	 * @throws Exception
	 */
	public void menuInsert() throws Exception {
		msgb(
			"	GRAVAR DADOS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> LISTA\n"
			+"=> AMBAS\n"
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
			"	MENU OP��ES DE IMPRESS�O:\n\n"	
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
			+"=> Nome.Exten��o\n"
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
			"	OP��ES PARA INSER��O DE DADOS:\n\n"	
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
			"	OP��ES PARA CONSULTAR ARQUIVO:\n\n"	
			+"=> NAVEGAR\n"
			+"=> FILTRAR\n"
			+"=> IMPRIMIR\n"
			+"=> SAIR\n"
		);		
	}
}