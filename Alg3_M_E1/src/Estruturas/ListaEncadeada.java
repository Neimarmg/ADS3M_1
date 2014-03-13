
package Estruturas;

import static java.lang.System.out;

import java.util.Scanner;

import Utilitarios.Formatos;
import Utilitarios.Include;
import Aplicacao.acoes;
import Arquivos.Ficheiro;

public class ListaEncadeada<T extends Comparable<T>> {
	Scanner var = new Scanner(System.in);
	
	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	
	public Nodo<T> getHead()
	{
		return head;
	}
	
	public void print()
	{
		Nodo<?> nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}
	
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		
		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo)
	{
		tail.setNext(novo);
		tail = novo;
	}
	
	
	public  void insereRegistro(String arquivo) throws Exception{
		String nomec, fone;
		Formatos f = new Formatos();
		Include i = new Include();		
		ListaEncadeada<String> lista = new ListaEncadeada<String>();
		
		f.msg("\nNome Contato: ");
		nomec =  var.next();
		lista.insert(new Nodo<String>(nomec.toUpperCase()));		
		i.insereLinha(nomec);
		
		f.msg("Telefone: ");
		fone = var.next();
		lista.insert(new Nodo<String>(fone.toUpperCase()));		
		i.insereLinha(fone);
		
		f.msgl();		
		
		acoes a = new acoes();
		a.cadastraInten();	

		
	}
}
