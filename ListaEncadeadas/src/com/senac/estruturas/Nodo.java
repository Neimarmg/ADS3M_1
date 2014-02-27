package com.senac.estruturas;

import java.awt.print.Printable;
import static java.lang.System.out;

public class Nodo {
	int dado;
	Nodo next;
	
	private Nodo() {
		this.next = null;
		this.dado = 0;
	}
	
	private Nodo(int i){
		this.dado = i;		
	}
	
	public void setNext(Nodo novo) {
		this.next = novo;
	}
	
	public Nodo getNext() {
		return next;
	}
	
	
	private static void insetBefore(Nodo novo , Nodo next){//Metodo que insere no inicio da lista
		
	
	}
	
	
	private static void inset(Nodo anterior,Nodo novo){//Metodo que insere no meio e no fim da lista
		
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		
	}
	
	
	
	public static void main(String[] args){
		Nodo head = new Nodo();
		

		head.setData(2);
		
		insert(head,new Nodo(3));
		insert(newNodo(2));
		print(head);
		
		
	
	}	
}

/* Metodos de para se utilizr uma listas
 * 
 * insert()
 * remove()
 * search()
 * print()
 * -----------------------
 * tipo dado
 * nodo next
 * 
 * 
 *
 */		