package C.Arvores.RedBlack;

import App.View;

public class Nodorb<T extends Comparable<T>> {
	private Nodorb<T> par;
	private Nodorb<T> dir;
	private Nodorb<T> esq;
	private boolean cor;
	private T valor;

	public Nodorb(Nodorb<T> dir, Nodorb<T> esq, T valor, boolean cor) {
		this.dir = dir;
		this.esq = esq;
		this.cor = cor;
		this.valor = valor;
		if (dir != null) {
			dir.par = this;
		}
		if (esq != null) {
			esq.par = this;
		}
		this.par = null;
	}


	public void imprimir() {
		String color = "";

		if(isCor() == true){
			color = "V";
		}

		else{
			color = "B";
		}

		View.msg("( " + valor + " " + color + "\n");

		if (esq != null) {

			esq.imprimir();
		}

		else {
			System.out.print("( )");
		}

		if (dir != null) {

			dir.imprimir();
		}

		else {
			System.out.print("( )");
		}
	}

	public Nodorb<T> avo() {
		return par.par;
	}

	public Nodorb<T> irmao() {
		if (this == par.esq) {
			return par.dir;
		} else {
			return par.esq;
		}
	}

	public Nodorb<T> tio() {
		return par.irmao();
	}

	
	public Nodorb<T> getParente() {
		return par;
	}

	public void setPar(Nodorb<T> parente) {
		this.par = parente;
	}

	public Nodorb<T> getDir() {
		return dir;
	}

	public void setDir(Nodorb<T> direita) {
		this.dir = direita;
	}

	public Nodorb<T> getEsq() {
		return esq;
	}

	public void setEsq(Nodorb<T> esquerda) {
		this.esq = esquerda;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

}