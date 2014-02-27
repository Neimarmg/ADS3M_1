package com.senac.estruturas;

import static java.lang.System.out;

public class Nodo {

	private int dado;
	private Nodo next;
	
	private Nodo()
	{
		this.dado = 0;
		this.next = null;
	}
	
	private Nodo(int valor)
	{
		this.dado = valor;
		this.next = null;
	}
	
	private int getData()
	{
		return dado;
	}
	
	private void setData(int i)
	{
		this.dado = i;
	}
	
	private Nodo getNext()
	{
		return next;
	}
	private void setNext(Nodo next)
	{
		this.next = next;
	}
	
	private static void insertBefore(Nodo novo, Nodo next)
	{
		novo.setNext(next);
	}
	
	private static void insertAfter(Nodo anterior, Nodo novo)
	{
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
	}
	
	private static void print(Nodo head)
	{
		Nodo nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null); 
	}

	public static void main(String[] args)
	{
		Nodo head = new Nodo();
		head.setData(2);
		
		Nodo novo = new Nodo(3);
		insertAfter(head, novo);
		
		novo = new Nodo(1);
		insertBefore(novo, head);
		head = novo;
		
		print(head);
	}

}
