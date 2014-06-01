package C.Arvores.Binaria;

import App.View;
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
			raiz.insert(novo);
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
	public void travessiaPosFixa(boolean cabecalho) {
		if (cabecalho == true ) {
			View.msgc("\nTRAVESSIA PÓS-FIXA - "
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprime Travassia pré-fixa da árvore
	 */
	public void travessiaPreFixa(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nTRAVESSIA PRÉ-FIXA - " 
				+ Auxiliar.getOpcao().toUpperCase() + " " 
				+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprime Travassia infixa da árvore
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
	 * Conta nodos da árvore
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
	 * Busca elemento percorrendo a árvore em largura
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
	 * Método de impressão de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo,boolean cabecalho) {
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}
	
	/**
	 * Método complementar de remoção
	 * @param campo
	 */
	public void remove(T campo, boolean cabecalho) {
		raiz.remove(raiz, campo);
	}
}