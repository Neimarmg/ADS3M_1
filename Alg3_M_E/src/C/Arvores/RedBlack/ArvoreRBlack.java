package C.Arvores.RedBlack;

import App.View;
import M.Utilitarios.Auxiliar;

public class ArvoreRBlack<T extends Comparable<T>> {

	private Nodorb<T> raiz;

	public ArvoreRBlack() {
		raiz = null;
	}


	/**
	 * M�todo de rota��o � esquerda
	 * @param no
	 */
	private void rotacionaEsquerda(Nodorb<T> no) {
		Nodorb<T> direita = no.getDir();
		substituiNodo(no, direita);
		no.setDir(direita.getEsq());

		if (direita.getEsq() != null) {
			direita.getEsq().setPar(no);
		}
		direita.setEsq(no);
		no.setPar(direita);
	}


	/**
	 * M�todo de rota��o � direita
	 * @param no
	 */
	private void rotacionaDireita(Nodorb<T> no) {
		Nodorb<T> esquerda = no.getEsq();
		substituiNodo(no, esquerda);
		no.setEsq(esquerda.getDir());

		if (esquerda.getDir() != null) {
			esquerda.getDir().setPar(no);
		}
		esquerda.setDir(no);
		no.setPar(esquerda);
	}


	/**
	 * M�todo repons�vel pela substitui��o de nodos
	 * @param x
	 * @param no
	 */
	private void substituiNodo(Nodorb<T> x, Nodorb<T> no) {
		if (x.getParente() == null) {
			raiz = no;
		} else {
			if (x == x.getParente().getEsq()) {
				x.getParente().setEsq(no);
			} else {
				x.getParente().setDir(no);
			}
		}
		if (no != null) {
			no.setPar(x.getParente());
		}
	}


	/**
	 * M�todo respos�vel pela inser��o de elementos na �rvore
	 * @param valor
	 */
	public void insere(T valor) {

		Nodorb<T> node = new Nodorb<T>(null, null, valor, false);

		if (raiz == null) {
			raiz = node;
		} else {
			Nodorb<T> n = raiz;

			while (true) {

				if (valor.compareTo(n.getValor()) == 0) {
					n.setValor(valor);
					return;

				} else if (valor.compareTo(n.getValor()) < 0) {
					if (n.getEsq() == null) {
						n.setEsq(node);
						break;
					} else {
						n = n.getEsq();
					}

				} else {
					if (n.getDir() == null) {
						n.setDir(node);
						break;
					} else {
						n = n.getDir();
					}
				}
			}
			node.setPar(n);
		}
		caso1(node);
	}


	/**
	 *  Caso de inser��o nro 1
	 * @param no
	 */
	private void caso1(Nodorb<T> no) {
		if (no.getParente() == null) {
			no.setCorNodo(true);
		} else {
			caso2(no);
		}
	}


	/**
	 *  Caso de inser��o nro 2
	 * @param no
	 */
	private void caso2(Nodorb<T> no) {

		if (no.getParente().isCorNodo() == true) {
			return;
		} else {
			caso3(no);
		}
	}


	/**
	 * Caso de inser��o nro 3
	 * @param no
	 */
	private void caso3(Nodorb<T> no) {

		if (no.tio().isCorNodo() == false) {
			no.getParente().setCorNodo(true);
			no.tio().setCorNodo(true);
			no.avo().setCorNodo(false);
			caso1(no.avo());
		} else {
			caso4(no);
		}
	}


	/**
	 *  Caso de inser��o nro 4
	 * @param no
	 */
	private void caso4(Nodorb<T> no) {

		if (no == no.getParente().getDir()
				&& no.getParente() == no.avo().getEsq()) {
			rotacionaEsquerda(no.getParente());
			no = no.getEsq();
		} else if (no == no.getParente().getEsq()
				&& no.getParente() == no.avo().getDir()) {
			rotacionaDireita(no.getParente());
			no = no.getDir();
		}
		caso5(no);
	}


	/**
	 *  Caso de inser��o nro 5
	 * @param no
	 */
	private void caso5(Nodorb<T> no) {
		no.getParente().setCorNodo(true);
		no.avo().setCorNodo(false);

		if (no == no.getParente().getEsq()
				&& no.getParente() == no.avo().getEsq()) {
			rotacionaDireita(no.avo());
		} else {
			rotacionaEsquerda(no.avo());
		}
	}


	/**
	 * Imprime nodos infixa
	 */
	public void imprimeInfixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nIMPRESS�O EM ORDEM INFIXA DA - ");
		raiz.ordemInfixa();
	}


	/**
	 * Imprime nodos em ordem pr�-fixa
	 */
	public void imprimeOrdemPreFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nIMPRESS�O EM PR�-FIXA DA - ");
		raiz.ordenPreFixa();
	}


	/**
	 * Imprime nodo em ordem p�s-fixa
	 */
	public void imprimePosFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nIMPRESS�O EM P�S-FIXA DA- ");
		raiz.ordenPosFixa();
	}

	/**
	 * Imprime contagem do nodos na �rvore
	 */
	public void imprimeContagemNodos(boolean cabecalho) {
		View.imprimeArvores(true, "\nTOTAL DE NODOS NA LISTA NA - ");
		raiz.contaNodos();
		View.msg("Qt nodos: " + Auxiliar.getContador() + "\n");
		Auxiliar.setContador(false); // Limpa contador

	}
}