package model.Lista;

import Aplicacao.Prints;

public class ListaEncadeada<T extends Comparable<T>> {
	
	static String acum ="";
	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo
	
	
	public Nodo<T> getHead() {
		return head;
	}
	
	public static void setAcum(String acum) {
		ListaEncadeada.acum = acum;
	}
	
	public static String getAcum() {
		return acum;
	}
	
	/**
	 * imprime quando abilitado na tela e edita registros ap�s a ordena��o
	*/
	public void imprime(boolean impressaoPrevia) {
		try {
			Nodo<?> nodo = head;
			do {
				if(impressaoPrevia){Prints.msg("\n" +nodo.getData());} //Imprime a lista para consulta pr�via em tempo de execu��o}
				acum += "\n" +nodo.getData(); //Acumalador de ordena��o
				nodo = nodo.getNext();				
			} while (nodo != null);			
			
		} catch (NullPointerException e) {
			Prints.msg("\nN�o existem dados no arquivo para serem impressos.\n");
		}
	}
	
	
	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;
		
		if (tail == null)
			tail = head;
	}

	
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	
	public void append(Nodo<T> novo) {
		tail.setNext(novo);
		tail = novo;
	}
}