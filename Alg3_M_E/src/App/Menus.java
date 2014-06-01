package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implementa��o de menus de todo o sistema
 * @author Neimar, Aur�lio
 */
public class Menus extends View {
	private static String sair = "=> SAIR\n";
	private static String menu ="";	
	private static String opcMenu;
	
	public static void setOpcMenu(String opcMenu) {
		Menus.opcMenu = opcMenu;
	}
	
	public static void menuSelecinaAtividade() {	
		msgb("|QUAL ATIVIDADE?\n"
		 + "|----------------------------------------------------------------------\n"
		 + "|Comando      |Descri��o               |Status atividade\n"
		 + "|-------------|------------------------|-------------------------------\n"
		 + "|=> T1        |Lista Encadeada         |" + Auxiliar.statusAcao(7,7) + "\n"
		 + "|=> T2        |Pesquisa Bin�ria        |" + Auxiliar.statusAcao(7,7) + "\n"
		 + "|=> T4        |Algoritmos de Ordena��o |" + Auxiliar.statusAcao(7,7) + "\n"
		 + "|=> T5        |�rvore Bin�ria          |" + Auxiliar.statusAcao(5,0) + "\n"
		 + "|=> T6        |�rvores AVL E RED BLACK |" + Auxiliar.statusAcao(5,0) + "\n"
		 + "|=> Glossario |Imprime gloss�rio       |" + Auxiliar.statusAcao(7,7) +"\n"
		 + "|" + sair);		
	}
	
	/**
	 * M�todo respons�vel pela impress�o dos comando de execu��o de tarefas
	 */
	public static void mostarMenuApp() {		
		menu = "|O QUE VOC� DESEJA FAZER?\n"
		     + "|--------------------------------------------------------------------\n"
			 + "|Comando      |Descri��o\n"
			 + "|-------------|------------------------------------------------------\n";
		 
		if (opcMenu.equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
			menu += "|=> EXECUTAR  |'Executa a��es nas estruturas existente'\n" +
					"|=> ARQUIVO   |'Propriedades de arquivo'\n";
		}
					
		if (opcMenu.equals("ORDENADORES")) {
			menu += "|=> ORDENAR   |'Executa ordena��o de registro em arquivo(s)'\n";
		}else{
			menu += "|=> CONSULTAR |'Executa consulta em conte�do salvo em arquivo(s)'\n";
		}
							
		menu += "|=> IMPRIMIR  |'Imprime arquivo selecionado'\n"					
			 +  "|" + sair;
		msgb(menu);
		
		menu = ""; // Limpa vari�vel para exibi��o de pr�ximo menu
	}

		
	/** 
	 * M�todo respons�vel pele exibi��o dos menus de include 
	 * @throws Exception
	 */
	public static void menuInclude(String include)throws Exception {	
		menu =
			  "|OP��ES DE INCLUDE\n"
			+ "|--------------------------------------------------------------------\n"
			+ "|Comando     |Descri��o\n"
			+ "|------------|-------------------------------------------------------\n"
			+ "|=> NOVO     |'Habilita para gravar novo registro'\n"	
			+ "|=> REMOVER  |'Remove arquivo existente'\n";					
		
		switch (include) {
			
		case "ARQUIVO":			
			menu += "|=> BUSCAR   |'Busca lista de arquivos existentes'\n"+
					"|=> IMPRIMIR |'Imprime dados'\n";
			break;
				
		case "DADOS":	
			menu += "|=> EDITAR   |'Edita dados do arquivo'\n";
			break;				
		}
			
		menu += "|" + sair;
		msgb(menu);
		
		menu = "";  // Limpa vari�vel para exibi��o do pr�ximo menu
	}
		
		
	/**
	 * Menu global para consultas
	 * @throws Exception
	 */
	public static void menuConsultas()throws Exception {	
		String edicao;
		
		menu = "|OP��ES PARA CONSULTA(S) EM " + Auxiliar.getOpcao() + "(S)" + "\n"
			 + "|--------------------------------------------------------------------\n"
			 + "|Comando         |Descri��o\n";
		
		edicao = "|--------------------------------------------- < Edi��o >\n"
			   + "|=> NOVO         |'Insere um novo elemento'\n"
			   + "|=> REMOVER      |'Remove um elemento'\n";
					
		switch (opcMenu) {
		
		case "ARVORE":			
			menu += "|--------------------------------------------- < Travessias >\n"
				 +  "|=> POSFIXA      |'Imprime ordem p�s-fixa'\n"
				 +  "|=> PREFIXA      |'Imprime ordem pr�-fixa'\n"
				 +  "|=> INFIXA       |'Imprime ordem infixa'\n"
				 +  "|--------------------------------------------- < Stat�sticas >\n"
				 +  "|=> CONTAR       |'Conta nodos da lista'\n"
				 +  "|--------------------------------------------- < Buscas >\n"
				 +  "|=> ALTURA       |'? '\n"
				 +  "|=> PROFUNDIDADE |'Calcula profundidade da �rvore'\n"
				 +  "|=> NOME         |'Encontra um nome ou elemento'\n"
				 +  edicao;
			break;
				
		case "BINARIA":
			menu +=
				 "|----------------|---------------------------------------------------\n"
				+"|=> ID           |'Encontra um id atrav�s de uma busca bin�ria'\n";
			break;
				
		case "LISTA":
			menu += "|=> NAVEGAR      |'Navega pelo arquivo com comando de teclado'\n"
				 +  "|=> ARQUIVO      |'Imprime arquivo inteiro'\n"
				 +  "|=> NOME         |'Encontra um nome ou elemento'\n"
				 +  edicao;
			break;							
		}
			
		menu += "|" + sair;
		msgb(menu);	
		
		menu = ""; // Limpa vari�vel para exibi��o do pr�ximo menu
	}

		
	/**
	 * M�todo respons�vel pela execu��o das formas de ordena��o
	 * @throws Exception
	 */
	public static void menuOrdenadores()throws Exception {	
		msgb(
		    "|COMO ORDENAR DADOS?\n"
		  + "|--------------------------------------------------------------------\n"
		  + "|Comando      |Descri��o\n"
		  + "|-------------|------------------------------------------------------\n"
		  + "|=> BUBLE     |'Ordena dados do arquivo com BubleSort'\n"
		  + "|=> QUICK     |'Ordena dados do arquivo com QuickSort'\n"
		  + "|=> COMPARAR  |'Imprime dados estat�sticos dos dois ordenadores\n"
		  + "|" + sair
		);
	}

		
	/**
	 * Menu de defini��o de modo de ordena��o
	 * @throws Exception
	 */
	public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
		if (ativaMenu == true) {
			msgb(
				 "|DESEJA ORDENAR PARA:\n"
			   + "|--------------------------------------------------------------------\n"
			   + "|Comando   | Descri��o\n"
			   + "|----------|---------------------------------------------------------\n"
			   + "|=> C      |'Exibe arquivo em ordem crescente'\n"
			   + "|=> D      |'Exibe arquivo em ordem decrescente'\n"
			);
		}
	}
	
	
	/**
	 * M�todo impress�o de menus para selecionar as �rvores
	 * @param tipoArvore
	 * @param ativaTodosTipo
	 * @param print
	 * @throws Exception
	 */
	public static void menuArvores(boolean tipoArvore, boolean ativaTodosTipo, boolean print)throws Exception {	
		
		if (ativaTodosTipo == true) {
			menu = "|=> Binaria   |�rvore bin�ria\n";
		} else {
			menu = "";
		}
		
		if (print == true) {
			msgb(
				"|SELECIONE QUAL TIPO DE �RVORE:\n"
			  + "|--------------------------------------------------------------------\n"
			  + "|Comando      |Descri��o\n"
			  + "|-------------|------------------------------------------------------\n"
			  + menu 
			  + "|=> Avl       |�rvore avl\n"
		      + "|=> RedBlack  |�rvore rubro negra\n"
			);
		}
		
		if (tipoArvore == true) {
			Auxiliar.setDetalhes(Auxiliar.digita("�rvore do tipo"));
		}
		
		menu = ""; // Limpa vari�vel para exibi��o do pr�ximo menu
	}
	
	
	
	/**
	 * Exibe o gloss�rio do programa
	 * @throws Exception
	 */
	public static void glossario()throws Exception {	
		msgb(
		    "|GLOSS�RIO DO PROGRAMA:\n"
		  + "|--------------------------------------------------------------------\n"
		  + "|Voc�bulo  |Significado\n"
		  + "|----------|---------------------------------------------------------\n"
		  + "|C         |Controller\n"
		  + "|M         |Model\n"
	      + "|V         |View\n"
		  + "|App       |Aplica��o\n"
		  + "|Ficheiro  |Classe de manipula��o de arquivo\n"
		);
	}
}