package Model;

import Controller.Utilitarios.Prints;

public class MapaModel {

	int i,j;
	private int linha = 10; 
	private int coluna = 10;
	
	Prints p = new Prints();
	public String [][]mapa = new String[getLinha()][getColuna()];	

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public int getColuna() {
		return coluna;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public String[][] getMapa() {
		return mapa;
	}
		
	
	/**
	 * Cria tabluleiro do jogo
	 * @throws Exception
	 */
	public void criaTabuleiro() throws Exception{
		p.msgb("Cm "+ " " +getColuna()+" Lm " +getLinha());
		try {
			for (i = 0; i < 9; i++) {			
				for (j = 0; j < getLinha(); j++) {
					mapa[i][j] = "0";
				}				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			p.msgb("Não foi possível criar o mapa!");
		}
	}
}
