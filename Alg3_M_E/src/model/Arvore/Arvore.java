package model.Arvore;


public class Arvore {		 
    private static String raiz;
    private static Arvore dir;
	private static Arvore esq;
    
	
	public void setRaiz(String raiz) {
		Arvore.raiz = raiz;
	}

	public void setDir(Arvore dir) {
		Arvore.dir = dir;
	}

	public void setEsq(Arvore esq) {
		Arvore.esq = esq;
	}
    
	
	public static String getRaiz() {
		return raiz;
	}
    
	
    public static Arvore getDir() {
		return dir;
	}
    
    
    public static Arvore getEsq() {
		return esq;
	}


}