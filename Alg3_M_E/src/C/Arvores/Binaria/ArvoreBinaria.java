package C.Arvores.Binaria;

import App.View;
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
	public void imprime(boolean cabecalho) throws Exception {
		View.imprimeArvores(true, "\nIMPESS�O DA - ");
		raiz.imprime();			
	}	

	/**
	 * M�todo respons�vel por armazenar temporariamente as altera��es dos dados do arquivo
	 */
	public void guardaEdicao() {
		raiz.guardaEdicao();
	}

	/**
	 * Imprime travessia p�s-fixa da �rvore
	 */
	public void travessiaPosFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA P�S-FIXA - ");
		raiz.travessiaPosFixa(raiz);
	}

	/**
	 * Imprime travessia pr�-fixa da �rvore
	 */
	public void travessiaPreFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA PR�-FIXA - ");
		raiz.travessiaPreFixa(raiz);
	}

	/**
	 * Imprime travessia infixa da �rvore
	 */
	public void travessiaInfixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA INFIXA - ");
		raiz.travessiaInfixa(raiz);
	}

	/**
	 * Conta nodos da �rvore
	 * @return
	 */
	public int contaNodos(boolean cabecalho) {
		View.imprimeArvores(true, "\nCONTAGEM DE NODOS - ");
		return raiz.contaNodos(raiz);
	}

	/**
	 * Busca elemento percorrendo a �rvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome, boolean cabecalho) {
		View.imprimeArvores(true, "\nBUSCA EM ALTURA - ");
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); // Limpa contador
	}

	/**
	 * M�todo de impress�o de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo,boolean cabecalho) {
		View.imprimeArvores(true, "\nBUSCA DADOS - ");
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}

	/**
	 * M�todo complementar de remo��o
	 * @param campo
	 */
	public void remove(T campo, boolean cabecalho) {
		View.imprimeArvores(true, "\nREMOC�O DE NODO - ");
		raiz.remove(raiz, campo);
	}
}