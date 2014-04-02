package Model;

import Controller.Utilitarios.Prints;

public class MapaModel {
	Prints p = new Prints();
	
	private int i = 0 ,j = 0 ;
	private static int extancaoY = 10;
	private static int linha = extancaoY; 
	private static int coluna = extancaoY;
	static String [][]mapa = new String[getLinha()][getColuna()];
	
	public static String[][] getMapa() {
		return mapa;
	}
	
	public static void setExtancaoY(int extancaoY) {
		MapaModel.extancaoY = extancaoY;
	}
	
	public static int getExtancaoY() {
		return extancaoY;
	}
	
	public static void setColuna(int coluna) {
		MapaModel.coluna = coluna;
	}
	
	public static int getColuna() {
		return coluna;
	}
	
	public static void setLinha(int linha) {
		MapaModel.linha = linha;
	}
	
	public static int getLinha() {
		return linha;
	}
	
	/**
	 * Cria tabluleiro do jogo
	 * @throws Exception
	 */
	public void criaMapa() throws Exception{
		try {
			for (i = 0; i < linha; i++) {	
				for (j = 0; j < coluna; j++) {
					mapa[i][j] = ".";
				}				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			p.msgb("N�o foi poss�vel criar o mapa!");
		}
	}
}
