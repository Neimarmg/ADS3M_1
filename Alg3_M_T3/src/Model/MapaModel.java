package Model;

public class MapaModel {

	
	private static final int linha = 10; 
	private static final int coluna = 10;	
	public String [][]campo = new String[getLinha()][getColuna()];
	
	
	public static int getColuna() {
		return coluna;
	}

	
	public static int getLinha() {
		return linha;
	}
	
	
	public String[][] getCampo() {
		return campo;
	}
	
	
	public void criaCampo() {
		for (int i = 0; i < linha ; i++) {			
			for (int j = 0; j < coluna; j++) {				
				campo[i][j]= ""+j*i;
			}				
		}
	}
}
