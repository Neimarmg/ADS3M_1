package com.senac.estruturas;

import static java.lang.System.out;

public class ListaEncadeada {

	private Nodo head;
	private Nodo tail;
	
	private Nodo getHead()
	{
		return head;
	}
	
	private void print()
	{
		Nodo nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}
	
	private void insert(Nodo novo)
	{
		novo.setNext(head);
		head = novo;
		
		if (tail == null)
			tail = head;
	}

	private void insert(Nodo novo, Nodo anterior)
	{
		if (anterior == tail)
			append(novo);
		else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	private void append(Nodo novo)
	{
		tail.setNext(novo);
		tail = novo;
	}
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.insert(new Nodo(1));
		lista.insert(new Nodo(2), lista.getHead());
		lista.append(new Nodo(3));
		
		lista.print();

	}

}
