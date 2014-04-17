package Estruturas;

import Utilitarios.Prints;

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
	 * imprime quando abilitado na tela e edita registros após a ordenação
	*/
	public void ordenador(boolean impressaoPrevia) {
		try {
			Nodo<?> nodo = head;
			do {
				if(impressaoPrevia){Prints.msg("\n" +nodo.getData());}//Imprime a lista para consulta prévia em tempo de execução}
				acum += "\n" +nodo.getData(); //Acumalador de ordeção
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