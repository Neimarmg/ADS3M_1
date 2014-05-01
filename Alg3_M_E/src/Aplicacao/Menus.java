package Aplicacao;

import Utilitarios.Prints;

public class Menus extends Prints{
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL � ATIVIDADE?\n\n"
			+"=> T1 'Listas encadeadas'       " +Prints.status(7) +"\n"
			+"=> T2 'Pesquisa Bin�ria'        " +Prints.status(0) +"\n"
			+"=> T4 'Algoritmos de ordena��o' " +Prints.status(7) +"\n"
			+"=> T5 'Arvores'                 " +Prints.status(1) +"\n"
			+"=> SAIR\n");
		}
		
		
		public static void mostarMenuT1() {		
			msgb("	O QUE VOC� DESEJA FAZER?\n\n"
			+"=> EXECUTAR  'Executa a��es em arquivo existentes'\n"
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
			Prints.msgb(
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
		public static void menuEditarArquivo()throws Exception {	
			msgb(
				"	OP��ES PARA INSER��O DE DADOS:\n\n"	
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
				"	OP��ES PARA CONSULTAR ARQUIVO:\n\n"	
				+"=> NAVEGAR  'Navega pelo arquivo com comando de teclado'\n"
				+"=> FILTRAR  'Encontra um registro espec�fico no arquivo'\n"
				+"=> ARQUIVO  'Imprime arquivo inteiro'\n"
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
		public static void menuModoOrdenacao()throws Exception {	
			msgb(
				"	DESEJA ORDENAR PARA?\n\n"	
				+"=> C 'Exibe arquivo na ordem crescente'\n"
				+"=> D 'Exibe arquivo na ordem decrescente'\n"
			);
		}
}
