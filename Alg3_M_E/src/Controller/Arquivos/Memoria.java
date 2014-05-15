package  Controller.Arquivos;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import Aplicacao.Prints;

public class Memoria {
	
	FileSystem fSistem  = FileSystems.getDefault();


	/**
	 * M�todo que lista unidade de disco existente
	 * @return
	 */
	private String listaInidades() {
		for (FileStore store : fSistem.getFileStores()) {
			return store.toString();
		} return "?";
	}
	
	
	/**
	 * M�todo que calcula total de mem�ria dispon�vel na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int calcula()throws Exception{			
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getTotalSpace();
		} return 0;
	}
	
	
	/**
	 * M�todo que executa a verifica��o de mem�ria dispon�vel na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int verifica()throws Exception {
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getUsableSpace();		
		} return 0; 
	}
	
	
	/**
	 * M�todo de impress�o do status da mem�ria
	 * @throws Exception
	 */
	public void imprime()throws Exception {
		Prints.msg("\nLista Unidades: " +listaInidades() + "\n");
		Prints.msg("Espa�o total: " + calcula() + "\n");
		Prints.msg("Total dispon�vel: " +verifica() + "\n");
	}	
}