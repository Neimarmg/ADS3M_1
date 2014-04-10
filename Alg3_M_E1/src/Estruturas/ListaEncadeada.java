package Estruturas;

import Utilitarios.Prints;

public class ListaEncadeada<T extends Comparable<T>> {
	
	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo
	
	public Nodo<T> getHead() {
		return head;
	}

	
	public void print() {
		try {
			Nodo<?> nodo = head;
			do {
				Prints.msg("\n" +nodo.getData());
				nodo = nodo.getNext();
			} while (nodo != null);
			
		} catch (NullPointerException e) {
			Prints.msg("\nNão existem elementos na lista ficheiro serem impressos.\n");
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