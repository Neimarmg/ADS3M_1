package model.Lista;

import Aplicacao.Prints;
import Controller.Registrador;

public class ListaEncadeada<T extends Comparable<T>> {
	
	
	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo
	
	
	public Nodo<T> getHead() {
		return head;
	}
	
	/**
	 * Imprime quando habilitado na tela e edita registros ap�s a ordena��o
	*/
	public void imprime(boolean impressaoPrevia) {
		try {
			Nodo<?> nodo = head;
			do {
				if (impressaoPrevia){Prints.msg("\n" + nodo.getData());} // Imprime a lista para consulta pr�via em tempo de execu��o
				Registrador.setAcum(Registrador.getAcum() +"\n" +nodo.getData()); // Acumalador de ordena��o
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