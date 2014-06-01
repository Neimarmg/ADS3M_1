package C.Arvores.RedBlack;

public class ArvoreRBlack<T extends Comparable<T>> {

	private Nodorb<T> raiz;

	public ArvoreRBlack() {
		raiz = null;
	}

	/**
	 * 
	 * @param n
	 */
	private void rotarEsquerda(Nodorb<T> n) {
		Nodorb<T> direita = n.getDir();
		substituirNodo(n, direita);
		n.setDir(direita.getEsq());

		if (direita.getEsq() != null) {
			direita.getEsq().setPar(n);
		}
		direita.setEsq(n);
		n.setPar(direita);
	}

	/**
	 * 
	 * @param n
	 */
	private void rotarDireita(Nodorb<T> n) {
		Nodorb<T> esquerda = n.getEsq();
		substituirNodo(n, esquerda);
		n.setEsq(esquerda.getDir());

		if (esquerda.getDir() != null) {
			esquerda.getDir().setPar(n);
		}
		esquerda.setDir(n);
		n.setPar(esquerda);
	}

	/**
	 * 
	 * @param x
	 * @param no
	 */
	private void substituirNodo(Nodorb<T> x, Nodorb<T> no) {
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
	 * 
	 * @param valor
	 */
	public void inserir(T valor) {
		
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
		case1(node);
	}

	/**
	 * 
	 * @param no
	 */
	private void case1(Nodorb<T> no) {
		if (no.getParente() == null) {
			no.setCor(true);
		} else {
			caso2(no);
		}
	}

	/**
	 * 
	 * @param no
	 */
	private void caso2(Nodorb<T> no) {
		
		if (no.getParente().isCor() == true) {
			return;
		} else {
			case3(no);
		}
	}

	
	/**
	 * 
	 * @param no
	 */
	private void case3(Nodorb<T> no) {
		
		if (no.tio().isCor() == false) {
			no.getParente().setCor(true);
			no.tio().setCor(true);
			no.avo().setCor(false);
			case1(no.avo());
		} else {
			caso4(no);
		}
	}

	/**
	 * 
	 * @param no
	 */
	private void caso4(Nodorb<T> no) {
		
		if (no == no.getParente().getDir()
				&& no.getParente() == no.avo().getEsq()) {
			rotarEsquerda(no.getParente());
			no = no.getEsq();
		} else if (no == no.getParente().getEsq()
				&& no.getParente() == no.avo().getDir()) {
			rotarDireita(no.getParente());
			no = no.getDir();
		}
		caso5(no);
	}

	/**
	 * 
	 * @param no
	 */
	private void caso5(Nodorb<T> no) {
		no.getParente().setCor(true);
		no.avo().setCor(false);
		
		if (no == no.getParente().getEsq()
				&& no.getParente() == no.avo().getEsq()) {
			rotarDireita(no.avo());
		} else {
			rotarEsquerda(no.avo());
		}
	}

	/**
	 * Imprime nodos da raiz
	 */
	public void imprimirNodos() {
		raiz.imprimir();
	}
}