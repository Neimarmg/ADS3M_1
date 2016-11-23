package M;

public class lc {
	private static int linha, coluna;

	public static int getLinha() {
		return linha;
	}

	public static void setLinha(int linha) {
		lc.linha = linha;
	}

	public static int getColuna() {
		return coluna;
	}

	public static void setColuna(int coluna) {
		lc.coluna = coluna;
	}
	
	public static void setLinhaColuna(int linha, int coluna) {
		lc.linha = linha;
		lc.coluna = coluna;
	}
}
