package model.Arvore;

import Aplicacao.Prints;

public class ArvoreBinariaAVL {
	
	public static class Arvore {		 
	    public String raiz;
	    public Arvore dir, esq;
	}   
	
	public static Arvore insere(Arvore aux, String raiz) {
		if (aux == null) {
			aux = new Arvore();
			aux.raiz = raiz;
			aux.dir = null;
			aux.esq = null;
			
		} else if (raiz.compareTo(aux.raiz) < 0) {
			aux.esq = insere(aux.esq, raiz);
		
		} else {
			aux.dir = insere(aux.dir, raiz);
		}		
		return aux;		
	}
	
	public static void imprime(Arvore aux) {
		if (aux != null) {
			imprime(aux.esq);
			Prints.msg("\n" +aux.esq +", ");
			imprime(aux.dir);
			//Prints.msg(aux.dir +", ");
		}
	}
	
	public static void executa(String nodo) {
		Arvore a =  null;
		a = insere(a, "Neimar");
		a = insere(a, "Jose");
		a = insere(a, "Carlos");
		a = insere(a, "Andre");
		a = insere(a, "Zando");
		
		
		
		ArvoreBinariaAVL.imprime(a);
		
		//http://manfred.com.br/index.php/bsi/estrutura-de-dados-i/141-aula-10-arvore-binaria-em-java
	}
	
	
} 