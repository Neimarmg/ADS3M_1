package Arquivos;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import Utilitarios.Prints;

public class Memoria {
	
	FileSystem fSistem  = FileSystems.getDefault();


	/**
	 * Método que lista unidade de disco
	 * @return
	 */
	private String listaInidades() {
		for (FileStore store : fSistem.getFileStores()) {
			return store.toString();
		} return "?";
	}
	
	
	/**
	 * Método que totaliza ficheiro memória total da unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int totalizaMenoria()throws Exception{			
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getTotalSpace();
		} return 0;
	}
	
	
	/**
	 * Método que calcula ficheiro memória disponível na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int calculaDisponivel()throws Exception {
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getUsableSpace();		
		} return 0; 
	}
	
	
	public void imprime()throws Exception {
		Prints.msg("\nLista Unidades: " +listaInidades() +"\n");
		Prints.msg("Espaço total: " +totalizaMenoria() +"\n");
		Prints.msg("Total disponivel: " +calculaDisponivel() +"\n");
	}	
}