package model.Arvore;

import Aplicacao.Prints;

/**
 * Classe responsavel pela pela estrrutura da arvore binária
 * @author neimar, Aurélio
 */
public class ArvoreBinaria {
	
	public static class arvore {		 
        public int raiz;
        public arvore dir, esq;
    }
 
	
    public static arvore insere(arvore aux, int r) {
        if (aux == null) {
            aux = new arvore();
            aux.raiz = r;
            aux.esq = null;
            aux.dir = null;
 
        } else if (r < aux.raiz) {
            aux.esq = insere(aux.esq, r);
            Prints.msg("\na " +r);
        } else {
            aux.dir = insere(aux.dir, r);
            Prints.msg("\nb " +r);
        }
        
        return aux;
    }
 
    
    public static void remover(arvore aux, int num) {
    	
    	
    }
    
    
    public static void imprime(arvore aux) {
        if (aux != null) {
            imprime(aux.esq);
            System.out.print(aux.raiz + ", ");
            imprime(aux.dir);           
        }
        
        
    }
    
    public static void executa() {
   	 arvore a = null;
       imprime(a); 
        a = insere(a, 32);
        a = insere(a, 4);
        a = insere(a, 15);
        a = insere(a, 8);
        a = insere(a, 65);
        a = insere(a, 3);
        a = insere(a, 9);
        imprime(a); 
        
         
        System.out.print("A : ");
        imprime(a);
        System.out.println();
       
        a = insere(a, 10);
               
        System.out.print("A : ");
        imprime(a);
        System.out.println();
   	
   }
 }
