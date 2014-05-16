package Aplicacao;

import model.Utilitarios.Auxiliar;

/**
 * Classe de implemetação de menus do todo o sistema
 * @author Neimar, Aurélio
 */
public class Menus extends Prints {
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL ATIVIDADE?\n\n"
			+ "=> T1 'Listas Encadeadas'       " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T2 'Pesquisa Binária'        " + Auxiliar.statusAcao(7,0) + "\n"
			+ "=> T4 'Algoritmos de Ordenação' " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T5 'Arvores'                 " + Auxiliar.statusAcao(2,0) + "\n"
			+ "=> SAIR\n");
		}
		
		
		public static void mostarMenuApp() {		
			msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
			+ "=> EXECUTAR  'Executa ações nas estruturas existente'\n"
			+ "=> CONSULTAR 'Conteúdo do salvo em arquivo(s)'\n"
			+ "=> IMPRIMIR  'Imprime arquivo selecionado'\n"
			+ "=> ARQUIVO   'Propriedades de arquivo'\n"
			+ "=> SAIR\n");
		}
		
		
		/**	
		 * @throws Exception
		 */
		public static void  nomeArquivo()throws Exception {	
			msgb(
				"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
				+"=> Nome.Extensão\n"
				+"=> SAIR\n"
			);		
		}
		
		
		/** 
		 * @throws Exception
		 */
		public static void menuArquivo()throws Exception {	
			msgb(
				"	PESQUISAR SE O ARQUIVO EXISTE:\n\n"	
				+ "=> NOVO    'Cria um novo arquivo em branco'\n"
				+ "=> BUSCAR  'Busca lista de arquivos existentes'\n"
				+ "=> REMOVER 'Remove arquivo existente'\n"
				+ "=> SAIR\n"
			);		
		}
		
		
		/** 
		 * @throws Exception
		 */
		public static void menuEditarArquivo()throws Exception {	
			msgb(
				"	EDIÇÃO DE ARQUIVO COM ESTRUTURA DE " + Auxiliar.getOpcao() + ":\n\n"	
				+ "=> NOVO     'Habilita para gravar novo registro'\n"			
				+ "=> EDITAR   'Edita dados do arquivo'\n"
				+ "=> REMOVER  'Remove logicamente o registro'\n"
				+ "=> IMPRIMIR 'Imprime dados ordenados em arquivo'\n"
				+ "=> SAIR\n"
			);		
		}
		
		
		/**
		 * Menu global para consultas
		 * @throws Exception
		 */
		public static void menuConsultas()throws Exception {	
			String menu ="";
			
			switch (Auxiliar.getOpcao()) {
			case "ARVORE":			
				menu += "	OPÇÕES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> NOME  'Encontra um nome dentro da árvore'\n";
				break;
				
			case "BINARIA":	
				menu += "	OPÇÕES PARA CONSULTA(S) " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> ID 'Encontra um id através de uma busca binária'\n";
				break;
				
			case "LISTA":
				menu += "	OPÇÕES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"\n\n"
						+"=> NOME	 'Encontra um nome dentro da lista'\n"
						+"=> NAVEGAR 'Navega pelo arquivo com comando de teclado'\n"
						+"=> ARQUIVO 'Imprime arquivo inteiro'\n";
				break;
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}

		
		/**
		 * Método responsável pela execução das formas de ordenação
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"	COMO ORDENAR DADOS?\n\n"	
				+"=> BUBLE    'Ordena dados do arquivo com BubleSort'\n"
				+"=> QUICK    'Ordena dados do arquivo com QuickSort'\n"
				+"=> COMPARAR 'Imprime dados estatísticos dos dois ordenadores \n"
				+"=> SAIR\n"
			);		
		}

		
		/**
		 * Menu de definição de modo de ordenação
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