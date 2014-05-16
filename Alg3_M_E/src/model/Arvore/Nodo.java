package model.Arvore;

import Aplicacao.Prints;

/**
 * Classo de gravacao do nodo
 * @author Neimar, Aurelio *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>>{
	private Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;
	
	/**
	 * Contrutor da classe nodo
	 * @param valor
	 */
	public Nodo(T valor){
		pai=null;
		esq=null;
		dir=null;
		this.valor = valor;
	}
	
	
	private void setPai(Nodo<T> nodo) {
		this.pai = nodo;	
	}
	
	
	public T getValor(){
		return this.valor;
	}
	
	
	public void setValor(T valor){
		this.valor = valor;
	}

	/**
	 * Metodo responsavel pela insecao dos objetos na arvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(novo.getValor().compareTo(valor) < 0 ){
			if(esq ==null){
				esq = novo;
				novo.setPai(this);
			}else{
				esq.insere(novo);
			}
		}
		
		if(novo.getValor().compareTo(valor) > 0){
			if(dir ==null){
				dir = novo;
				novo.setPai(novo);
			}else {
				dir.insere(novo);
			}
		}
		return;
	}
	
	
	public void imprime(){
		Prints.msg("\n" + valor);
		if(esq != null){
			esq.imprime();
		}

		if(dir != null){
			dir.imprime();
		}
	}
}
