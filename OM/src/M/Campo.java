package M;

import V.View;

public class Campo {
	
	private static int i = 0 ,j = 0;

	private static int linha = getLinha(); 
	private static int coluna = getLinha();
	public static String [][]mapa = new String[1][10];
	
	
	public static int getColuna() {
		return coluna;
	}
	
	
	public static void setColuna(int coluna) {
		Campo.coluna = coluna;
	}
	
	
	public static void setLinha(int linha) {
		Campo.linha = linha;
	}
	
	
	public static int getLinha() {
		return linha;
	}
	
	
	public static void ml(){
		if (j < getLinha()){
			mapa[i][j] = ""+j;
			View.msg(" "+mapa[i][j]);
			j++;
			ml();
		}
	}
	
	
	
	/**
	 * Cria campo 
	 * @throws Exception
	 */
	public static void mapa(boolean imprimir) throws Exception {
		try {
			for (i = 0; i < linha; i++) {	
				//j=0;
				ml();
				//for (j = 0; j < coluna; j++) {
					//mapa[i][j] = "  ";
					//View.msg(j+mapa[i][j]);
				//}
				View.msg("\n");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msgb("Não foi possível criar o mapa!");
		}
	}

}
