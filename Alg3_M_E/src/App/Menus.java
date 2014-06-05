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
	private static String filtro;

	public static void setMenu(String menu) {
		Menus.menu = menu;
	}
	
	public static void setFiltro(String filtro) {
		Menus.filtro = filtro;
	}
	
	public static void setOpcMenu(String opcMenu) {
		Menus.opcMenu = opcMenu;
	}

	public static void menuSelecinaAtividade() {	
		msgb("|QUAL ATIVIDADE?\n"
		 + "|\n"
		 + "|Obs.: Todas as atividade s�o independenstes, funcionam em separado.\n"
		 + "|Comandos, estes sim, compartilham m�todos gen�ricos reaproveit�veis.\n"
		 + "|\n"
		 + "|----------------------------------------------------------------------\n"
		 + "|Comando      |Descrição               |Status atividade\n"
		 + "|-------------|------------------------|-------------------------------\n"
		 + "|=> T1        |Lista Encadeada         |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T2        |Pesquisa Bin�ria        |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T4        |Algoritmos de Ordena��o |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T5        |�rvore Bin�ria          |" + Auxiliar.statusAcao(8,7,70) + "\n"
		 + "|=> T6        |�rvores AVL e RED BLACK |" + Auxiliar.statusAcao(8,7,70) + "\n"
		 + "|=> G         |Imprime gloss�rio       |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|" + sair);		
	}

	/**
	 * M�todo respons�vel pela impress�o dos comandos de execu��o das tarefas
	 */
	public static void mostarMenuApp() {		
		menu = "|O QUE VOC� DESEJA FAZER?\n"
		     + "|--------------------------------------------------------------------\n"
			 + "|Comando      |Descri��o\n"
			 + "|-------------|------------------------------------------------------\n";

		if (opcMenu.equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
			menu += "|=> EXECUTAR  |Executa a��es nas estruturas existente\n" +
					"|=> ARQUIVO   |Propriedades de arquivo\n";
		}

		if (opcMenu.equals("ORDENADORES")) {
			menu += "|=> ORDENAR   |Executa ordena��o de registro em arquivo(s)\n";
		} else {
			menu += "|=> CONSULTAR |Executa consulta em conte�do salvo em arquivo(s)\n";
		}

		menu += "|=> IMPRIMIR  |Imprime arquivo selecionado\n"					
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
			+ "|=> NOVO     |Habilita para gravar novo registro\n"	
			+ "|=> REMOVER  |Remove arquivo existente\n";					
		
		switch (include) {

		case "ARQUIVO":			
			menu += "|=> BUSCAR   |Busca lista de arquivos existentes\n" +
					"|=> IMPRIMIR |Imprime dados\n";
			break;

		case "DADOS":	
			menu += "|=> EDITAR   |Edita dados do arquivo\n";
			break;				
		}

		menu += "|" + sair;
		msgb(menu);

		menu = "";  // Limpa vari�vel para exibi��o do pr�ximo menu
	}


	/**
	 * M�todo respons�vel pelo filtro do menu de consultas
	 * @throws Exception
	 */
	public static void menuAgrupaCosultas()throws Exception {		
		if (Auxiliar.getAbilita() == false){	
			msgb(
			    "|SELE��O DE COMANDOS DE CONSULTAS?\n"
			  + "|--------------------------------------------------------------------\n"
			  + "|Comando        |Descri��o\n"
			  + "|---------------|----------------------------------------------------\n"
			  + "|=> EDICAO      |Listas itens de edi��o de estrutura\n"
			  + "|=> TRAVESSIAS  |Seleciona trevessias em �rvores\n"
			  + "|=> ESTATISTICAS|Seleciona comendos de estatiscas\n"
			  + "|=> TODOS       |Imprmir a lista completa de comandos\n" 
			 );
			filtro = Auxiliar.digita("Op��es de comandos");
		}			
	}

	
	/**
	 * Menu global para consultas
	 * @throws Exception
	 */
	public static void menuConsultas()throws Exception {	
		String edicao = "";
		
		menuAgrupaCosultas();				

		menu = "|OP��ES PARA CONSULTA(S) EM " + Auxiliar.getOpcao() + "(S)" + "\n"
			 + "|--------------------------------------------------------------------\n"
			 + "|Comando         |Descri��o\n";
		
		if (filtro.equals("todos") || filtro.equals("edicao")  ) {
			Auxiliar.setAbilita(true);
			edicao += "|--------------------------------------------- < Edi��o >\n"
				   + "|=> NOVO         |Insere um novo elemento\n"
				   + "|=> REMOVER      |Remove um elemento\n"
				   + "|=> IMPRIMIR     |Imprime estruturas elemento\n";	
		}
		
		switch (opcMenu) {

		case "ARVORE":			
			if (filtro.equals("todos") || filtro.equals("travessias")  ) {		
				Auxiliar.setAbilita(true);
				menu += "|--------------------------------------------- < Travessias >\n"
					 +  "|=> POSFIXA      |Imprime ordem p�s-fixa\n"
					 +  "|=> PREFIXA      |Imprime ordem pr�-fixa\n"
					 +  "|=> INFIXA       |Imprime ordem infixa\n";
			}		
			
			if (filtro.equals("todos") || filtro.equals("estatisticas")  ) {	 
				Auxiliar.setAbilita(true);
				menu += "|--------------------------------------------- < Stat�sticas >\n"
					 +  "|=> CONTAR       |Conta nodos da lista\n";
			}		 
			 
			if (filtro.equals("todos") || filtro.equals("buscas")  ) {
				Auxiliar.setAbilita(true);	
				menu += "|--------------------------------------------- < Buscas >\n"
					 +  "|=> ALTURA       |Busca elementos em n�vel\n"
					 +  "|=> PROFUNDIDADE |Calcula profundidade da �rvore\n"
					 +  "|=> NOME         |Encontra um nome ou elemento\n";
			}		 
				menu += edicao;
			break;

		case "BINARIA":
			menu +=
				 "|----------------|---------------------------------------------------\n"
				+"|=> ID           |Encontra um id atrav�s de uma busca bin�ria\n";
			break;

		case "LISTA":
			menu += "|=> NAVEGAR      |Navega pelo arquivo com comando de teclado\n"
				 +  "|=> ARQUIVO      |Imprime arquivo inteiro\n"
				 +  "|=> NOME         |Encontra um nome ou elemento\n"
				 +  edicao;
			break;							
		}
		
		
		if (Auxiliar.getAbilita() == true){
			menu += "|" + sair;
			msgb(menu);	
			menu = ""; // Limpa vari�vel para exibi��o do pr�ximo menu
		}else{
			menuConsultas();
			filtro = "";// Limpa vari�vel para exibi��o do pr�ximo filtro
			menu = ""; // Limpa vari�vel para exibi��o do pr�ximo menu
		}
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
		  + "|=> BUBLE     |Ordena dados do arquivo com BubleSort\n"
		  + "|=> QUICK     |Ordena dados do arquivo com QuickSort\n"
		  + "|=> COMPARAR  |Imprime dados estat�sticos dos dois ordenadores\n"
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
				 "|COMO DESEJA ORDENAR?\n"
			   + "|--------------------------------------------------------------------\n"
			   + "|Comando   | Descri��o\n"
			   + "|----------|---------------------------------------------------------\n"
			   + "|=> C      |Exibe arquivo em ordem crescente\n"
			   + "|=> D      |Exibe arquivo em ordem decrescente\n"
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
				"|QUAL TIPO DE �RVORE � SELECIONAR?\n"
			  + "|--------------------------------------------------------------------\n"
			  + "|Comando      |Descri��o\n"
			  + "|-------------|------------------------------------------------------\n"
			  + menu 
			  + "|=> avl       |�rvore avl\n"
		      + "|=> rb        |�rvore red black\n"
			);
		}

		if (tipoArvore == true) {
			Auxiliar.setDetalhes(Auxiliar.digita("�rvore do tipo"));
		}

		menu = ""; // Limpa vari�vel para exibi��o do pr�ximo menu
	}



	/**
	 * Exibe gloss�rio do programa
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
		  + "|l.txt     |Lista telefonica\n"
		  + "|avl       |�rvore avl\n"
		  + "|rb        |�rvore red black\n"
		  + "|ab        |�rvore bin�ria\n"
		  + "|#         |Marcador de exclus�o de registro"
		);
	}
}
