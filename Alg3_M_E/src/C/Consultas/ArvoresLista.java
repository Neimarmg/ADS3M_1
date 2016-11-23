package C.Consultas;

import App.Menus;
import App.View;
import C.Registrador;
import C.Lista.ListaEncadeada;
import C.Lista.Nodo;
import M.Utilitarios.Auxiliar;

/**
 * Classe repons�vel pelas consultas em todas as estruturas de �rvores e listas
 * @author Neimar, Aur�lio
 */
public class ArvoresLista {

	ListaEncadeada<String> lista = new ListaEncadeada<String>();

	/**
	 * M�todo de impress�o de �rvores travessia p�s-fixa
	 * @throws Exception
	 */
	public void tPosFixa() throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				Registrador.getArvoreBinaria().travessiaPosFixa(true);
				break;

			case "avl":
				Registrador.getAvl().imprimeOrdemPosFixa(Registrador.getAvl());
				break;

			case "rb":
				Registrador.getArvoreRedBlack().imprimePosFixa(true);
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}

	/**
	 * M�todo de impress�o de �rvores travessia pr�-fixa
	 * @throws Exception
	 */
	public void tPrefixa() throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				Registrador.getArvoreBinaria().travessiaPreFixa(true);
				break;

			case "avl":
				Registrador.getAvl().imprimeOrdemPreFixa(Registrador.getAvl());
				break;

			case "rb":
				Registrador.getArvoreRedBlack().imprimeOrdemPreFixa(true);
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}


	/**
	 * M�todo de impress�o de �rvores travessia infixa
	 * @throws Exception
	 */
	public void tInfixa() throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				Registrador.getArvoreBinaria().travessiaInfixa(true);
				break;

			case "avl":
				Registrador.getAvl().imprimeOrdemInfixa(Registrador.getAvl());
				break;

			case "rb":
				Registrador.getArvoreRedBlack().imprimeInfixa(true);
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}

	
	/**
	 * M�todo de contagem de nodos existantes na extruturas
	 * @throws Exception
	 */
	public void contaDeElementos() throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				Registrador.getArvoreBinaria().contaNodos(true);
				break;

			case "avl":
				View.objetoNaoImplementado();
				break;

			case "rb":
				Registrador.getArvoreRedBlack().imprimeContagemNodos(true);
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			contaDeElementos();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}
	

	/**
	 * M�todo de busca em altura nas �rvres
	 * @throws Exception
	 */
	public void buscaEmAltura() throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				Registrador.getArvoreBinaria().buscEmAltura(Auxiliar.digita("Elemento"), true);
				break;

			case "avl":
				View.objetoNaoImplementado();
				break;

			case "rb":
				View.objetoNaoImplementado();
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}


//====================<< Include em Estruturas de dados >> =====================================	

	/**
	 * M�todo de manipula��o de estruturas lista e �rvore para inser��o de elementos em mem�ria
	 * @throws Exception
	 */
	public void manipulaEstrutura(boolean inserirElemento) throws Exception {

		switch (Auxiliar.getOpcao()) {
		case "LISTA":
			if (inserirElemento == true) {
				Registrador.getLista().insert(
						new Nodo<String>(Auxiliar.digita("Elemento")), lista.getHead());
			}
			Registrador.getLista().imprime(true);
			break;

		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				if (inserirElemento == true) {
					Registrador.getLista().insert(new Nodo<String>(Auxiliar.digita("Elemento num�rico")), lista.getHead());
				}
				Registrador.getArvoreBinaria().imprime(true);
				break;


			case "avl":
				if (inserirElemento == true) {
					Registrador.getAvl();
					Registrador.getAvl().insere(Registrador.getAvl(), Auxiliar.digitaNumero("Elemento"));
				}
				Registrador.getAvl().imprimeAvore();
				break;


			case "rb":
				if (inserirElemento == true) {
					Registrador.setArvoreRedBlack(Registrador.getArvoreRedBlack());
					Registrador.getArvoreRedBlack().insere(Auxiliar.digita("Elemento"));
				}
				Registrador.getArvoreRedBlack().imprimeInfixa(true);
				break;
			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}



	/**
	 * M�todo estruturado para implementa��o de exclus�o de elementos de todas as estruturas
	 * @throws Exception
	 */
	public void removeElemento() throws Exception {
		View.objetoNaoImplementado();
		View.msge("\nPasso a passo do plano de implementa��o:\n");

		switch (Auxiliar.getOpcao()) {
		case "LISTA":
			View.msge("\nPasso 1: Carregar o arquivo na lista \n"
					+ "\nPasso 2: Digitar o elemento � ser exclu�do\n"
					+ "\nPasso 3: Percorrer a lista\n"
					+ "\nPasso 4: Se encontrado, excluir\n"
					+ "\nPasso 5: Atualizar a lista\n");
			break;

		case "ARVORE":

			// "Case" auxlilar para sele��o de estruturas da mesma fam�lia
			switch (Auxiliar.getDetalhes()) {
			case "ab":
				View.msge("\nPasso 1: Carregar o arquivo na �rvore \n"
						+ "\nPasso 2: Digitar o elemento � ser exclu�do\n"
						+ "\nPasso 3: Percorrer a �rvore\n"
						+ "\nPasso 4: Se encontrado, excluir\n"
						+ "\nPasso 5: Atualizar e realocar elementos\n");
				break;

			case "avl":
				View.msge("\nPasso 1: Carregar o arquivo na �rvore \n"
						+ "\nPasso 2: Digitar o elemento � ser exclu�do\n"
						+ "\nPasso 3: Percorrer a �rvore\n"
						+ "\nPasso 4: Se encontrado, excluir\n"
						+ "\nPasso 5: Atualizar e realocar elementos para fazer o rebalanciamento\n");
				break;

			case "rb":
				View.msge("\nSem planejamento ainda:\n");
				break;

			}
			break;

		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}
}