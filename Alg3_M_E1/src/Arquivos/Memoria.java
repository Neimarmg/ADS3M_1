package Arquivos;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import Utilitarios.Formatos;

public class Memoria {
	
	Formatos i = new Formatos();
	FileSystem fSistem  = FileSystems.getDefault();
	String grafico = "|||";
	
	/**Método lista unidade de disco.
	 * @return
	 */
	private String listaInidades() {
		for (FileStore store : fSistem.getFileStores()) {
			return store.toString();
		}return "?";
	}
	
	
	/**Método que totaliza a memória total unidade de disco.
	 * @return
	 * @throws Exception
	 */
	public int totalizaMenoria()throws Exception{			
		for (FileStore store : fSistem.getFileStores()) {
			grafico = grafico +"|||||";      
			return (int) store.getTotalSpace();
		}return 0;
	}
	
	
	/**Método que calcula a memória disponível na unidade de disco.
	 * @return
	 * @throws Exception
	 */
	public int calculaDisponivel()throws Exception {
		for (FileStore store : fSistem.getFileStores()) {
			grafico = grafico +"|||||";    
			return (int) store.getUsableSpace();		
		}return 0; 
	}
	
	
	/**Impressão dos dados de memória.
	 * @throws Exception
	 */
	public void pritnGrafico()throws Exception {
		i.msg(grafico); 
	}
	public void imprime()throws Exception {
		i.msg("\nLista Unidades: " +listaInidades() +"\n");
		i.msg("Espaço total: " +totalizaMenoria() +"\n");
		i.msg("Total disponivel: " +calculaDisponivel() +"\n");
	}
		
}