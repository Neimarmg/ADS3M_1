package model.Arvore;
import Aplicacao.Prints;

public class ArvoreBinaria{
	
	/**
	 *  Método protegido responsável por inserir elementos na árvore
	 * @param aux
	 * @param nome
	 * @return
	 */
	public static Arvore insere(Arvore aux, String nome) {
		if (aux == null) {
			aux = new Arvore();
	        aux.setRaiz(nome);
	        aux.setEsq(null);
	        aux.setDir(null);
	 
		} else if (nome.compareTo(nome) < Arvore.getRaiz().compareTo(Arvore.getRaiz())) {
			aux.setEsq(insere(Arvore.getEsq(), nome));
	    } else {
	       	aux.setDir(insere(Arvore.getDir(), nome));
	    }
	        return aux;
	}
	
	/**
	 * Método responsável pela impressão de elementos da árvore
	 * @param aux
	 */
	public static void imprime(Arvore aux , boolean print ) {
		if (print = true) {
			if (aux != null) {
				imprime(Arvore.getEsq(), print);
		        Prints.msg("\n" +Arvore.getRaiz() + ", ");
		        imprime(Arvore.getDir(), print);
		    }
		}
	}
	
	/**
	 * Metodo responsável pela execução da árvore
	 * @param nome
	 */
	public static void executa(Arvore arvore, String nome, boolean print) {
        arvore = insere(arvore, nome);
        imprime(arvore, print);        
	}

		//http://manfred.com.br/index.php/bsi/estrutura-de-dados-i/141-aula-10-arvore-binaria-em-java
	
}