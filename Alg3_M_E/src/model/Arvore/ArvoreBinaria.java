package model.Arvore;

public class ArvoreBinaria<T extends Comparable<T>>{
	private Nodo<T> raiz;

	/**
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(raiz == null){
			raiz=novo;
		}else{
			raiz.insere(novo);
		}
	}
	
	/**
	 * @param impr
	 */
	public void imprime(boolean impr){
		if (impr == true) {
			raiz.imprime();
		}		
	}
}