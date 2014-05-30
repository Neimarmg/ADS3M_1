package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implemetação de menus do todo o sistema
 * @author Neimar, Aurélio
 */
public class Menus extends View {
		static String sair = "=> SAIR\n";
		
	
		public static void menuSelecinaAtividade() {		
			msgb("|	QUAL ATIVIDADE?\n"
			 +"|--------------------------------------------------------------------\n"
			 +"|  Comando |Descrição                |Status atividade\n"
			 +"|----------|-------------------------|-------------------------------\n"
			+ "|=> T1     |'Listas Encadeadas'      |" + Auxiliar.statusAcao(7,7) +"\n"
			+ "|=> T2     |'Pesquisa Binária'       |" + Auxiliar.statusAcao(7,7) +"\n"
			+ "|=> T4     |'Algoritmos de Ordenação'|" + Auxiliar.statusAcao(7,7) +"\n"
			+ "|=> T5     |'Arvores'                |" + Auxiliar.statusAcao(2,0) +"\n"
			+ "|" +sair);
		}
		
		/**
		 * Método responsável pela impressão dos comando de execução de taréfas
		 */
		public static void mostarMenuApp() {		
			String menu = "|	O QUE VOCÊ DESEJA FAZER?\n"
					+"|--------------------------------------------------------------------\n"
					+"|  Comando    |Descrição\n"
					+"|-------------|------------------------------------------------------\n";
			 
			if (Auxiliar.getOpcao().equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
				menu += "|=> EXECUTAR  |'Executa ações nas estruturas existente'\n" +
						"|=> ARQUIVO   |'Propriedades de arquivo'\n";
			}
					
			if (Auxiliar.getOpcao().equals("ORDENADORES")) {
				menu += "|=> ORDENAR   |'Executa ordenação de registro em arquivo(s)'\n";
			}else{
				menu += "|=> CONSULTAR |'Conteúdo do salvo em arquivo(s)'\n";
			}
							
			menu += "|=> IMPRIMIR  |'Imprime arquivo selecionado'\n"					
					+"|" +sair;
			msgb(menu);		
		}

		
		/** 
		 * Métodos responsável pele exibição dos menus de include 
		 * @throws Exception
		 */
		public static void menuInclude(String include)throws Exception {	
			String menu =
					"|	OPÇÕES DE INCLUDE\n"
					+"|--------------------------------------------------------------------\n"
					+"|  Comando   |Descrição\n"
					+"|------------|-------------------------------------------------------\n"
					+"|=> NOVO     |'Habilita para gravar novo registro'\n"	
					+"|=> REMOVER  |'Remove arquivo existente'\n";					
			
			switch (include) {
			
			case "ARQUIVO":			
				menu += "|=> BUSCAR   |'Busca lista de arquivos existentes'\n"+
						"|=> IMPRIMIR |'Imprime dados'\n";
				break;
				
			case "DADOS":	
				menu += "|=> EDITAR   |'Edita dados do arquivo'\n";
				break;				
			}
			
			menu +="|" +sair;
			msgb(menu);		
		}
		
		
		/**
		 * Menu global para consultas
		 * @throws Exception
		 */
		public static void menuConsultas()throws Exception {	
			String edicao , menu;
			
			menu ="|	OPÇÕES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"(S)" +"\n"
				+"|--------------------------------------------------------------------\n"
				+"|  Comando       |Descrição\n";
			
			edicao = "|--------------------------------------------- < Edição > \n"
				+"|=> NOVO         |'Insere um novo elemento'\n"
				+"|=> REMOVER      |'Remove um elemento'\n";
					
			switch (Auxiliar.getOpcao()) {
			
			case "ARVORE":			
				menu +="|--------------------------------------------- < Travessias >\n"
					+"|=> POSFIXA      |'Imprime ordem pos-fixa'\n"
					+"|=> PREFIXA      |'Imprime ordem pré-fixa'\n"
					+"|=> INFIXA       |'Imprime ordem infixa'\n"
					+"|--------------------------------------------- < Statísticas >\n"
					+"|=> CONTAR       |'Conta nodos da lista'\n"
					+"|--------------------------------------------- < Buscas > \n"
					+"|=> ALTURA       |'? '\n"
					+"|=> PROFUNDIDADE |'Calcula profundidade da arvore'\n"
					+"|=> NOME         |'Encontra um nome ou elemento'\n"
					+edicao;
				break;
				
			case "BINARIA":
				menu +=
					 "|----------------|---------------------------------------------------\n"
					+"|=> ID           |'Encontra um id através de uma busca binária'\n";
				break;
				
			case "LISTA":
				menu +="|=> NAVEGAR      |'Navega pelo arquivo com comando de teclado'\n"
					+"|=> ARQUIVO      |'Imprime arquivo inteiro'\n"
					+"|=> NOME         |'Encontra um nome ou elemento'\n"
					+edicao;
				break;							
			}
			
			menu +="|" +sair;
			msgb(menu);		
		}

		
		/**
		 * Método responsável pela execução das formas de ordenação
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"|	COMO ORDENAR DADOS?\n"
				+"|--------------------------------------------------------------------\n"
				+"|  Comando    |Descrição\n"
				+"|-------------|------------------------------------------------------\n"
				+"|=> BUBLE     |'Ordena dados do arquivo com BubleSort'\n"
				+"|=> QUICK     |'Ordena dados do arquivo com QuickSort'\n"
				+"|=> COMPARAR  |'Imprime dados estatísticos dos dois ordenadores \n"
				+"|" +sair
			);		
		}

		
		/**
		 * Menu de definição de modo de ordenação
		 * @throws Exception
		 */
		public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
			if (ativaMenu == true) {
				msgb(
					"|	DESEJA ORDENAR PARA:\n"
					 +"|--------------------------------------------------------------------\n"
					 +"|  Comando |Descrição\n"
					 +"|----------|---------------------------------------------------------\n"
					+ "|=> C      |'Exibe arquivo na ordem crescente'\n"
					+ "|=> D      |'Exibe arquivo na ordem decrescente'\n"
				);
			}
		}
		
}