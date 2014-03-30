package Model;

public class mapa {

	
	private static final int linha = 10; 
	private static final int coluna = 10;
	
	int a = (int) 'a'; 
	char [][] alfabeto = new char [linha][coluna];
	
	public static int getColuna() {
		return coluna;
	}

	
	public static int getLinha() {
		return linha;
	}
	
	
	public String [][]campo = new String[getLinha()][getColuna()];
	
	
	public String[][] getCampo() {
		return campo;
	}
	
	public void criaCampo() {

	
		for (int i = 0; i < linha ; i++) {
			for (int j = 0; j < coluna; j++) {
				//alfabeto [i][j] = (char) ('a'+j); 
				campo[i][j]= "gf ";
			}				
		}
	}
}
