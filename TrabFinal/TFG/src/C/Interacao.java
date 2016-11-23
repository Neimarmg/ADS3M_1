package C;

import M.Utilitarios.Auxiliar;

/**
 * Classe responsável pela interação do sistema com usuário
 * @author Grupo *
 */
public class Interacao {

	Ficheiro ficheiro = new Ficheiro();
	
	/**
	 * Método com comandos de manipulação de dados em arquivo
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public static void munipulaRotas(String nomeArquivo) throws Exception {
		
		C.Menus.menuInclude("ARQUIVO");

		switch (Auxiliar.digita("")) {

		case "buscar":
			Ficheiro.leArquivo(nomeArquivo, false, Auxiliar.digita("Dado a ser removido"), true, true);
			munipulaRotas(nomeArquivo); // "Loop" de continuação do programa
			break;

		case "novo":
			Ficheiro.addNovo(nomeArquivo);			
			munipulaRotas(nomeArquivo); // Loop de continuação do programa
			break;

		case "remover":
			Ficheiro.remove(nomeArquivo, Auxiliar.digita("Dado a ser removido"));
			munipulaRotas(nomeArquivo); // Loop de continuação do programa
			break;

		case "imprimir":
			Ficheiro.leArquivo(nomeArquivo, false, null, false, true);			
			munipulaRotas(nomeArquivo); // Loop de continuação do programa
			break;

		case "sair":
			V.View.sair();
			break;

		default:
			V.View.opcaoInvalida();
			munipulaRotas(nomeArquivo); // Loop de continuação do programa
			break;
		}
	}
	
	
	/**
	 *	Método com definição das atividades 
	 * @throws Exception
	 */
	public static void iniciaTarefas() throws Exception {
		 
		Menus.menuInteracao();
		switch (Auxiliar.digita("")) {

		case "dados":			
			munipulaRotas(Auxiliar.digita("Nome do arquivo"));
			Menus.menuInteracao();
			break;
			
		case "rotas":
			//Ficheiro.leArquivo("Grafo.txt", false, null, false, false);
			//GrafoControle.criaGrafo(3 , false);
			Carregador.coletaCordenadas(Auxiliar.digitaNumero("Origem"), Auxiliar.digitaNumero("Destino"));
			//Menus.menuInteracao(); 
			break;
	
		case "mapa":
			//Ficheiro.leArquivo("Grafo.txt", false, null, false, false);
			GrafoControle.criaGrafo(1, true);			
			//Menus.menuInteracao();
			break;
			
		case "sair":
			V.View.sair();
			break;

		default: 
			V.View.opcaoInvalida();
			iniciaTarefas();
			break;
		}
	}
	
}