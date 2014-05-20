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
	public void imprime(){
		raiz.imprime();		
	}
	
	
	/**
	 * Metodo respons�vel por armazenar em terporariamente as altera��o dos dados do arquivo
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