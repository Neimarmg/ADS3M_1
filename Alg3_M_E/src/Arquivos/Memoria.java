package Arquivos;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import Utilitarios.Prints;

public class Memoria {
	
	FileSystem fSistem  = FileSystems.getDefault();


	/**
	 * M�todo que lista unidade de disco
	 * @return
	 */
	private String listaInidades() {
		for (FileStore store : fSistem.getFileStores()) {
			return store.toString();
		}return "?";
	}
	
	
	/**
	 * M�todo que totaliza ficheiro mem�ria total da unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int totalizaMenoria()throws Exception{			
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getTotalSpace();
		}return 0;
	}
	
	
	/**
	 * M�todo que calcula ficheiro mem�ria dispon�vel na unidade de disco
	 * @return
	 * @throws Exception
	 */
	public int calculaDisponivel()throws Exception {
		for (FileStore store : fSistem.getFileStores()) {
			return (int) store.getUsableSpace();		
		}return 0; 
	}
	
	
	public void imprime()throws Exception {
		Prints.msg("\nLista Unidades: " +listaInidades() +"\n");
		Prints.msg("Espa�o total: " +totalizaMenoria() +"\n");
		Prints.msg("Total disponivel: " +calculaDisponivel() +"\n");
	}	
}