package Estruturas;

import Utilitarios.Formatos;

public class ListaEncadeada<T extends Comparable<T>> {
	Formatos i = new Formatos();
	
	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	
	public Nodo<T> getHead() {
		return head;
	}

	
	public void print() {
		try {
			Nodo<?> nodo = head;
			do {
				i.msg("\n" +nodo.getData());
				nodo = nodo.getNext();
			} while (nodo != null);
			
		} catch (NullPointerException e) {
			i.msg("\nNão existem elementos na lista a serem impressos.\n");
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