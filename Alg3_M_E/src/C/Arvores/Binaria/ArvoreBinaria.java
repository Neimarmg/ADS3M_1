package C.Arvores.Binaria;

import M.Utilitarios.Auxiliar;


/**
 * Classe de execu��o da arvore bin�ria
 * @author Neimar, Aur�lio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>>{
	private Nodo<T> raiz;

	Nodo<T> nodo =  new Nodo<T>(null);
	
	
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
	 * @throws Exception 
	 */
	public void imprime() throws Exception{
		raiz.imprime();			
	}	
	
	/**
	 * Metodo respons�vel por armazenar em terporariamente as altera��o dos dados do arquivo
	 */
	public void guardaEdicao(){
		raiz.guardaEdicao();
	}
	
	/**
	 * Imprmir travessia p�s fixa da �rvore
	 */
	public void travessiaPosFixa(){
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprimr Travassia pr� fixa da �rvore
	 */
	public void travessiaPreFixa(){
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprimr Travassia infixa da �rvore
	 */
	public void travessiaInfixa(){
		raiz.travessiaInfixa(raiz);
	}
	
	/**
	 * Conta toda de nodos da arvore
	 * @return
	 */
	public int contaNodos(){
		return raiz.contaNodos(raiz);
	}
	
	/**
	 * Busca elemento percorrendo a arvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome){
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); //Limpa contador
	}	
	
	/**
	 * M�todo e impressao de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo){
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); //Limpa contador
	}
	
	/**
	 * M�do complementar de remo��o
	 * @param campo
	 */
	public void remove(T campo){
		raiz.remove(raiz, campo);
	}
}