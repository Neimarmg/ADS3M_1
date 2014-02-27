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
	
	public Nodo(int valor)
	{
		this.dado = valor;
		this.next = null;
	}
	
	public int getData()
	{
		return dado;
	}
	
	private void setData(int i)
	{
		this.dado = i;
	}
	
	public Nodo getNext()
	{
		return next;
	}
	public void setNext(Nodo next)
	{
		this.next = next;
	}

}
