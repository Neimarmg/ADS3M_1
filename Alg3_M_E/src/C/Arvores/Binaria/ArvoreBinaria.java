package C.Arvores.Binaria;

import M.Utilitarios.Auxiliar;


/**
 * Classe de execu��o da �rvore bin�ria
 * @author Neimar, Aur�lio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>> {
	private Nodo<T> raiz;

	Nodo<T> nodo =  new Nodo<T>(null);
	
	
	/**
	 * M�todo de inser��o na �rvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo) {
		if (raiz == null) {
			raiz = novo;
		} else {
			raiz.insere(novo);
		}		
	}
	
	
	/**
	 * @param impress�o da �rvore
	 * @throws Exception 
	 */
	public void imprime() throws Exception {
		raiz.imprime();			
	}	
	
	/**
	 * M�todo respons�vel por armazenar temporariamente as altera��es dos dados do arquivo
	 */
	public void guardaEdicao() {
		raiz.guardaEdicao();
	}
	
	/**
	 * Imprmime travessia p�s-fixa da �rvore
	 */
	public void travessiaPosFixa() {
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprime Travassia pr�-fixa da �rvore
	 */
	public void travessiaPreFixa() {
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprime Travassia infixa da �rvore
	 */
	public void travessiaInfixa() {
		raiz.travessiaInfixa(raiz);
	}
	
	/**
	 * Conta nodos da �rvore
	 * @return
	 */
	public int contaNodos() {
		return raiz.contaNodos(raiz);
	}
	
	/**
	 * Busca elemento percorrendo a �rvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome) {
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); // Limpa contador
	}	
	
	/**
	 * M�todo de impress�o de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo) {
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}
	
	/**
	 * M�todo complementar de remo��o
	 * @param campo
	 */
	public void remove(T campo) {
		raiz.remove(raiz, campo);
	}
}