package model.Arvore;

/**
 * 
 * @author Neimar, aurelio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>>{
	private Nodo<T> raiz;

	/**
	 * Método de inserção na arvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(raiz == null){
			raiz = novo;
		}else{
			raiz.insere(novo);
		}
	}
	
	/**
	 * @param impressão da árvore
	 */
	public void imprime(boolean impr){
		if (impr == true) {
			raiz.imprime();
		}		
	}
	
	
	/**
	 * Metodo responsável por armazenar em terporariamente as alteração dos dados do arquivo
	 */
	public void guardaEdicao(){
		raiz.guardaEdicao();
	}
}