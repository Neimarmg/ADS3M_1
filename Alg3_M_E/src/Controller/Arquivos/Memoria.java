package  Controller.Arquivos;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import Aplicacao.Prints;

public class Memoria {
	
	FileSystem fSistem  = FileSystems.getDefault();


	/**
	 * Método que lista unidade de disco existente
	 * @return
	 */
	private String listaInidades() {
		for (FileStore store : fSistem.getFileStores()) {
			return store.toString();
		} return "?";
	}
	
	
	/**
	 * Método que calcula total de memória disponível na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int calcula()throws Exception{			
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getTotalSpace();
		} return 0;
	}
	
	
	/**
	 * Método que executa a verificação de memória disponível na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int verifica()throws Exception {
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getUsableSpace();		
		} return 0; 
	}
	
	
	/**
	 * Método de impressão do status da memória
	 * @throws Exception
	 */
	public void imprime()throws Exception {
		Prints.msg("\nLista Unidades: " +listaInidades() + "\n");
		Prints.msg("Espaço total: " + calcula() + "\n");
		Prints.msg("Total disponível: " +verifica() + "\n");
	}	
}