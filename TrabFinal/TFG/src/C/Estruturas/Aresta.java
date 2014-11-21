package C.Estruturas;

/**
 * Clase de definição das arestas
 * @author Grupo
 */
public class Aresta {
	static int ArestaDestino, arestaOrigem;

	public static int getArestaDestino() {
		return ArestaDestino;
	}
	
	public static void setArestaDestino(int arestaDestino) {
		ArestaDestino = arestaDestino;
	}
	
	public static int getArestaOrigem() {
		return arestaOrigem;
	}
	
	public static void setArestaOrigem(int arestaOrigem) {
		Aresta.arestaOrigem = arestaOrigem;
	}
}
