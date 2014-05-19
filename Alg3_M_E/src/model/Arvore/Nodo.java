package model.Arvore;

import Aplicacao.Prints;
import Controller.Registrador;

/**
 * Classo de gravacao do nodo
 * @author Neimar, Aurelio *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>>{
	protected Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;
	
	
	/**
	 * Contrutor da classe nodo
	 * @param valor
	 */
	public Nodo(T valor){
		pai = null;
		esq = null;
		dir = null;
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
	
	
	
	public void remove(){	
		
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
	
	
	
	/**
	 * Metodo respons�vel por armazenar em terporariamente as altera��o dos dados do arquivo
	 */
	public void guardaEdicao(){
		Registrador.setAcum(Registrador.getAcum() +"\n" +valor);
		if(esq != null){			
			esq.guardaEdicao();	
		}
		
		if(dir != null){
			dir.guardaEdicao();				
		}		
	}
	
	
	
	public void travessiaPosFixa(Nodo<T> no){
		if( no == null )  
			return;  
		Prints.msg("\nTravessia p�s-fixa :" +no.valor);	
		travessiaPosFixa(no.dir);
		travessiaPosFixa(no.esq);					
		
	}
	
	
	
	public void travessiaPreFixa(Nodo<T> no){
		if( no == null )  
			return;  
		travessiaPosFixa(no.dir);
		travessiaPosFixa(no.esq);
		Prints.msg("\nTravessia pr�-fixa :" +no.valor);	
		 
	}
	
	
	
	public void buscaEmLargura(){
	
	}
	
	
	
	public void buscEmAltura(){
	
	}
	
}
