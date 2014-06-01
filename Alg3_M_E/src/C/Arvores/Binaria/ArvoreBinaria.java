package C.Arvores.Binaria;

import M.Utilitarios.Auxiliar;


/**
 * Classe de execução da árvore binária
 * @author Neimar, Aurélio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>> {
	private Nodo<T> raiz;

	Nodo<T> nodo =  new Nodo<T>(null);
	
	
	/**
	 * Método de inserção na árvore
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
	 * @param impressão da árvore
	 * @throws Exception 
	 */
	public void imprime() throws Exception {
		raiz.imprime();			
	}	
	
	/**
	 * Método responsável por armazenar temporariamente as alterações dos dados do arquivo
	 */
	public void guardaEdicao() {
		raiz.guardaEdicao();
	}
	
	/**
	 * Imprmime travessia pós-fixa da árvore
	 */
	public void travessiaPosFixa() {
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprime Travassia pré-fixa da árvore
	 */
	public void travessiaPreFixa() {
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprime Travassia infixa da árvore
	 */
	public void travessiaInfixa() {
		raiz.travessiaInfixa(raiz);
	}
	
	/**
	 * Conta nodos da árvore
	 * @return
	 */
	public int contaNodos() {
		return raiz.contaNodos(raiz);
	}
	
	/**
	 * Busca elemento percorrendo a árvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome) {
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); // Limpa contador
	}	
	
	/**
	 * Método de impressão de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo) {
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}
	
	/**
	 * Método complementar de remoção
	 * @param campo
	 */
	public void remove(T campo) {
		raiz.remove(raiz, campo);
	}
}