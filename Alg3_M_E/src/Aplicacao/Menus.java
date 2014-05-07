package Aplicacao;

import model.Utilitarios.Auxiliar;

public class Menus extends Prints{
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL É ATIVIDADE?\n\n"
			+"=> T1 'Listas encadeadas'       " +Auxiliar.statusAcao(7) +"\n"
			+"=> T2 'Pesquisa Binária'        " +Auxiliar.statusAcao(-1) +"\n"
			+"=> T4 'Algoritmos de ordenação' " +Auxiliar.statusAcao(7) +"\n"
			+"=> T5 'Arvores'                 " +Auxiliar.statusAcao(2) +"\n"
			+"=> SAIR\n");
		}
		
		
		public static void mostarMenuT1() {		
			msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
			+"=> EXECUTAR  'Executa ações em arquivo existentes'\n"
			+"=> CONSULTAR 'Conteúdo do arquivo'\n"
			+"=> IMPRIMIR  'Imprime arquivo selecionado'\n"
			+"=> ARQUIVO   'Propriedades de arquivo'\n"
			+"=> SAIR\n");
		}
		
		/** 
		 * @throws Exception
		 */
		public static void menuInsert() throws Exception {
			msgb(
				"	MANIPULAR DADOS EM: \n\n"	
				+"=> LISTA  'Utiliza a extrutura de listas'\n"
				+"=> ARVORE 'Utiliza a extrutura de listas'\n"
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
			Prints.msgb(
				"	MENU OPÇÕES DE IMPRESSÃO:\n\n"	
				+"=> ARQUIVO 'Atalho para impressão do conteúdo do arquivo'\n"
				+"=> SAIR\n"
			);		
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
				+"=> NOVO    'Cria um novo arquivo em branco'\n"
				+"=> BUSCAR  'Busca lista de arquivos existentes'\n"
				+"=> REMOVER 'Remove arquivo existente'\n"
				+"=> SAIR\n"
			);		
		}
		
		/** 
		 * @throws Exception
		 */
		public static void menuEditarArquivo()throws Exception {	
			msgb(
				"	OPÇÕES PARA INSERÇÃO DE DADOS:\n\n"	
				+"=> NOVO     'Habilita para gravar novo registro'\n"			
				+"=> EDITAR   'Editar dados do arquivo'\n"
				+"=> REMOVER  'Remove logicamente o registro'\n"
				+"=> IMPRIMIR 'Imprime dados ordenados em arquivo'\n"
				+"=> SAIR\n"
			);		
		}
		
		/**
		 * @throws Exception
		 */
		public static void menuConsultaArquivo()throws Exception {	
			msgb(
				"	OPÇÕES PARA CONSULTAR ARQUIVO:\n\n"	
				+"=> NAVEGAR  'Navega pelo arquivo com comando de teclado'\n"
				+"=> FILTRAR  'Encontra um registro específico no arquivo'\n"
				+"=> ARQUIVO  'Imprime arquivo inteiro'\n"
				+"=> SAIR\n"
			);		
		}

		/**
		* Metodo responsável pela execução das formas de ordenação
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"	ORDENAR DADOS COM?:\n\n"	
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
			if(ativaMenu == true){
				msgb(
					"	DESEJA ORDENAR PARA?\n\n"	
					+"=> C 'Exibe arquivo na ordem crescente'\n"
					+"=> D 'Exibe arquivo na ordem decrescente'\n"
				);
			}
		}
}
