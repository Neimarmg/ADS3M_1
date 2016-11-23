package C.Estruturas;

/**
 * Classe de definição da matriz geradora do grafo
 * @author Grupo
 */
public class Grafo {
	static int anterior, tamanho = 20;
	static int linha, coluna;
	static boolean visitado;
	static public int mapa[][] =  new int[tamanho][tamanho];
		
	public static int getTamanho() {
		return tamanho;
	}
			
	public static int getLinha() {
		return linha;
	}

	public static int getColuna() {
		return coluna;
	}

	public static void setTamanho(int tamanho) {
		Grafo.tamanho = tamanho;
	}
	
	public static int[][] getMapa() {
		return mapa;
	}

	public static int getAnterior() {
		return anterior;
	}

	public static void setAnterior(int anterior) {
		Grafo.anterior = anterior;
	}

	public static boolean isVisitado() {
		return visitado;
	}

	public static void setVisitado(boolean visitado) {
		Grafo.visitado = visitado;
	}
	
	
}
