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
			raiz.insert(novo);
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
	public void travessiaPosFixa(boolean cabecalho) {
		if (cabecalho == true ) {
			View.msgc("\nTRAVESSIA P�S-FIXA - "
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprime Travassia pr�-fixa da �rvore
	 */
	public void travessiaPreFixa(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nTRAVESSIA PR�-FIXA - " 
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprime Travassia infixa da �rvore
	 */
	public void travessiaInfixa(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nTRAVESSIA INFIXA - " 
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.travessiaInfixa(raiz);
	}
	
	/**
	 * Conta nodos da �rvore
	 * @return
	 */
	public int contaNodos(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nCONTAGEM DE NODOS - " 
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}		
		return raiz.contaNodos(raiz);
	}
	
	/**
	 * Busca elemento percorrendo a �rvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome, boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nBUSCA EM ALTURA - " 
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); // Limpa contador
	}
	
	/**
	 * M�todo de impress�o de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo,boolean cabecalho) {
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}
	
	/**
	 * M�todo complementar de remo��o
	 * @param campo
	 */
	public void remove(T campo, boolean cabecalho) {
		raiz.remove(raiz, campo);
	}
}