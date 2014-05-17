package model.Arvore;

/**
 * 
 * @author Neimar, aurelio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>>{
	private Nodo<T> raiz;

	/**
	 * M�todo de inser��o na arvore
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
	 * @param impress�o da �rvore
	 */
	public void imprime(boolean impr){
		if (impr == true) {
			raiz.imprime();
		}		
	}
}