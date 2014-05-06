package model.Arvore;

/**
 * Classe responsavel pela pela estrrutura da arvore binária
 * @author neimar, Aurélio
 */
public class ArvoreBinaria {
	
	private static class arvore {		 
        public int num;
        public arvore dir, esq;
    }
 
	
    public static arvore inserir(arvore aux, int num) {
        if (aux == null) {
            aux = new arvore();
            aux.num = num;
            aux.esq = null;
            aux.dir = null;
 
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
        } else {
            aux.dir = inserir(aux.dir, num);
        }
        return aux;
    }
 
    
    public static void remover(arvore aux, int num) {
    	
    	
    }
    
    
    public static void imprimir(arvore aux) {
        if (aux != null) {
            imprimir(aux.esq);
            System.out.print(aux.num + ", ");
            imprimir(aux.dir);
        }
    }
    
    
    
   }
