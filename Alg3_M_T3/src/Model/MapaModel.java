package Model;

import Controller.Utilitarios.Prints;

public class MapaModel {

	int i,j;
	private int linha; 
	private int coluna;
	
	Prints p = new Prints();
		

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
	String [][]mapa = new String[getLinha()][getColuna()];

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
			for (i = 0; i < getLinha(); i++) {	
				for (j = 0; j < getColuna(); j++) {
					mapa[i][j] = ".";
				}				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			p.msgb("Cm4 "+ " " +getColuna()+" Lm " +getLinha());
			p.msgb("Não foi possível criar o mapa!");
		}
	}
}
