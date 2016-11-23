package C.Lista;

import App.View;
import C.Registrador;
import M.Utilitarios.Auxiliar;

/**
 * Classe respons�vel pela manipula��o da lista
 * @author Neimar, Aur�lio
 * * @param <T>
 */
public class ListaEncadeada<T extends Comparable<T>> {


	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo


	public Nodo<T> getHead() {
		return head;
	}


	public void insere(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	/**
	 * M�todo de inser��o de nodos na lista
	 * @param novo
	 * @param anterior
	 */
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

	/**
	 * M�todo respons�vel por guardar as edi��es do dados em tempo de execu��o  
	 */
	public void guardaEdicao() {
		Nodo<?> nodo = head;
		do {	
			Registrador.setAcum("\n" + nodo.getData()); // Acumalador de ordena��o
			nodo = nodo.getNext();
		} while (nodo != null);	
	}

	/**
	 * Imprime na tela quando habilitado e edita registrador ap�s a ordena��o
	*/
	public void imprime(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nIMPESS�O DA - " + Auxiliar.getOpcao().toUpperCase() + "\n\n");
		}
		try {
			Nodo<?> nodo = head;
			do {
				View.msg("\n" + nodo.getData()); // Imprime a lista para consulta pr�via em tempo de execu��o
				nodo = nodo.getNext();				
			} while (nodo != null);			

		} catch (NullPointerException e) {
			View.msg("\nN�o existem dados no arquivo para serem impressos.\n");
		}
	}

}