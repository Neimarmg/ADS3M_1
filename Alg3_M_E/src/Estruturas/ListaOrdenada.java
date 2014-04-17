package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;
import Utilitarios.crud;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private BufferedReader buff;

	
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
	
	public void editaArquivo(String nomeArquivo) throws IOException {
		crud.setAppend(false);
		crud.addNovo(nomeArquivo, getAcum());
		ListaEncadeada.setAcum("");
	}
	
	
	/**
	 * M�todo responsavel pela leitura dos dados do arquivo
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void leArquivo(String nomeArquivo) throws IOException {
		ListaOrdenada<String> lista = new ListaOrdenada<String>();		
		
		try{
			FileReader file = new FileReader(nomeArquivo);
			buff = new BufferedReader(file);
			String linha = buff.readLine();
			
			while(linha != null ){
				linha = buff.readLine();
				lista.insert(new Nodo<String>(linha), lista.getHead());
				
			}			
			buff.close();
			
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
		lista.ordenador(false);
		editaArquivo(nomeArquivo);		
	}
}