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
	public void imprime(){
		raiz.imprime();		
	}
	
	
	/**
	 * Metodo responsável por armazenar em terporariamente as alteração dos dados do arquivo
	 */
	public void guardaEdicao(){
		raiz.guardaEdicao();
	}
	
	
	public void travessiaPosFixa(){
		raiz.travessiaPosFixa(raiz);
	}
	
	public void travessiaPreFixa(){
		raiz.travessiaPreFixa(raiz);
	}
	
	public void travessiaInfixa(){
		raiz.travessiaInfixa(raiz);
	}
	
	public int contaNodos(){
		return raiz.contaNodos(raiz);
	}
	
	public void buscaEmLargura(String nome){
		raiz.buscaEmLargura(raiz, nome);
	}
	
}