package Utilitarios;

public class Formatos {	
	
	public void msg(Object desc){
		// imprime na tale mem�ria dispPlanejamento inicial    
		System .out.print(desc);
	}
	
	
	/**
	 * 
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
	
	public void digitaComando(){
		System .out.println();
		System .out.print("COMANDO: ");
	}
	
	
	public void msgSair(){
		
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
		System .out.print(
			"	CONSULTAS EM: \n\n"	
			+"=> ARQUIVO\n"
			+"=> nLISTA\n"
			+"=> nSAIR\n"
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
			+"=> ESPECIFICAR\n"
			+"=> SAIR\n"
			+"=> SAIR\n"
		);		
	}
}