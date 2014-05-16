package model.Lista;

import java.io.IOException;

import Controller.Registrador;
import model.Utilitarios.Include;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	/**
	 * Método de ordenação de dados
	 * @param novo
	 * @return
	 */
	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		
		while (atual != null) {
			int comp = atual.compareTo(novo);
			if (comp < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			if (comp == 0)
				return atual;
			if (comp > 0)
				return anterior;
		}
		return anterior;
	}
	
	
	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}


	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}
	
	
	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}
	
	/**
	 * Método responsável por salvar alterações 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, Registrador.getAcum());
		Registrador.setAcum(""); // Parâmetro de limpeza de "cache do acumulador" 
	}
	
}