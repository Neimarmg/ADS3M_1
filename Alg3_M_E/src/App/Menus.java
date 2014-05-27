package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implemeta��o de menus do todo o sistema
 * @author Neimar, Aur�lio
 */
public class Menus extends View {
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL ATIVIDADE?\n\n"
			+ "=> T1 'Listas Encadeadas'       " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T2 'Pesquisa Bin�ria'        " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T4 'Algoritmos de Ordena��o' " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T5 'Arvores'                 " + Auxiliar.statusAcao(2,0) + "\n"
			+ "=> SAIR\n");
		}
		
		/**
		 * M�todo respons�vel pela impress�o dos comando de execu��o de tar�fas
		 */
		public static void mostarMenuApp() {		
			String menu = "	O QUE VOC� DESEJA FAZER?\n\n";
				 
			if (Auxiliar.getOpcao().equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
				menu += "=> EXECUTAR  'Executa a��es nas estruturas existente'\n" +
						"=> ARQUIVO   'Propriedades de arquivo'\n";
			}
					
			if (Auxiliar.getOpcao().equals("ORDENADORES")) {
				menu += "=> ORDENAR  'Executa ordena��o de registro em arquivo(s)'\n";
			}else{
				menu += "=> CONSULTAR 'Conte�do do salvo em arquivo(s)'\n";
			}
							
			menu += "=> IMPRIMIR  'Imprime arquivo selecionado'\n" +					
					"=> SAIR\n";
			msgb(menu);		
		}

		
		/** 
		 * M�todos respons�vel pele exibi��o dos menus de include 
		 * @throws Exception
		 */
		public static void menuInclude(String include)throws Exception {	
			String menu =
					"	OP��ES DE INCLUDE\n\n"+
					"=> NOVO     'Habilita para gravar novo registro'\n"+	
					"=> REMOVER  'Remove arquivo existente'\n";					
			
			switch (include) {
			
			case "ARQUIVO":			
				menu += "=> BUSCAR   'Busca lista de arquivos existentes'\n"+
						"=> IMPRIMIR 'Imprime dados'\n";
				break;
				
			case "DADOS":	
				menu += "=> EDITAR   'Edita dados do arquivo'\n";
				break;				
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}
		
		
		/**
		 * Menu global para consultas
		 * @throws Exception
		 */
		public static void menuConsultas()throws Exception {	
			String menu ="";
			
			switch (Auxiliar.getOpcao()) {
			case "ARVORE":			
				menu += "	OP��ES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> NOME  'Encontra um nome dentro da �rvore'\n";
				break;
				
			case "BINARIA":	
				menu += "	OP��ES PARA CONSULTA(S) " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> ID 'Encontra um id atrav�s de uma busca bin�ria'\n";
				break;
				
			case "LISTA":
				menu += "	OP��ES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"\n\n"
						+"=> NOME	 'Encontra um nome dentro da lista'\n"
						+"=> NAVEGAR 'Navega pelo arquivo com comando de teclado'\n"
						+"=> ARQUIVO 'Imprime arquivo inteiro'\n";
				break;
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}

		
		/**
		 * M�todo respons�vel pela execu��o das formas de ordena��o
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"	COMO ORDENAR DADOS?\n\n"	
				+"=> BUBLE    'Ordena dados do arquivo com BubleSort'\n"
				+"=> QUICK    'Ordena dados do arquivo com QuickSort'\n"
				+"=> COMPARAR 'Imprime dados estat�sticos dos dois ordenadores \n"
				+"=> SAIR\n"
			);		
		}

		
		/**
		 * Menu de defini��o de modo de ordena��o
		 * @throws Exception
		 */
		public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
			if (ativaMenu == true) {
				msgb(
					"	DESEJA ORDENAR PARA:\n\n"	
					+ "=> C 'Exibe arquivo na ordem crescente'\n"
					+ "=> D 'Exibe arquivo na ordem decrescente'\n"
				);
			}
		}
		
}