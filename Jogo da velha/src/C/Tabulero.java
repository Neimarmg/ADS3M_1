package C;

import W.View;

public class Tabulero {
	static String matriz [][] = new String [3][3];


	public static void setMatriz(int i, int j) {
		Tabulero.matriz[i][j] = " . ";
	}

	

	public static void criaTabulero(boolean imprime){
		for (int i = 0; i < 3; i++) {
			View.msg("\n");
			for (int j = 0; j < 3; j++) {
				if(imprime == false){
					Tabulero.matriz[i][j] = " . ";					
				}else{
					View.msg(matriz[i][j]);
				}				
			}
		}
	}
		
	public static void imprime(boolean imprime)	{		
		criaTabulero(imprime);
	}
}
