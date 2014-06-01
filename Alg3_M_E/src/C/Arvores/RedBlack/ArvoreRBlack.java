package C.Arvores.RedBlack;

public class ArvoreRBlack<T extends Comparable<T>> {

	private Nodorb<T> raiz;

	public ArvoreRBlack() {
		raiz = null;
	}

	/**
	 * Método de rotação a esquerda
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
	 * Método de rotação a direita
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
	 * Método reponsavel pela subtituição de nodos
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
	 * Metodo resposável pela inserção de elementos na árvore
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
	 *  Caso de inserção nro 1
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
	 *  Caso de inserção nro 2
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
	 * Caso de inserção nro 3
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
	 *  Caso de inserção nro 4
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
	 *  Caso de inserção nro 5
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
	 * Imprime nodos da raiz
	 */
	public void imprimirNodos() {
		raiz.imprime();
	}
}