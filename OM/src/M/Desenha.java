package M;

public class Desenha {
	
	static int v1 = Campo.mapa.length/2+1 , v2 = Campo.mapa.length ;
	
	
	
	
	
	public static void marcaPontos(boolean executar, boolean imprimir) throws Exception{
		for (int i = 0; i < Campo.mapa.length; i++) {
			for (int j = 0; j < Campo.mapa.length; j++) {
				if (i == 3 && j > 3 && j <= 10){
					Campo.mapa[i][j]= "0";
				}	
				
				if (i > 3 && v1 == j && j < v1 ){
					Campo.mapa[i][j]= "d";
					v1++;
					v2--;
				}
				
				
				/*if (j == 3 && i >= 3 && i < 17 ){
					Campo.mapa[i][j]= "0";
				}*/
							
				if (i == Campo.mapa.length/2 && j == 17){
					Campo.mapa[i][j]= "0";
				}
				/*	
				if (i == 17 && j >= 3 && j <= 10 ){
					Campo.mapa[i][j]= "0";
				}	*/
				
			}	
		}
		Campo.executaMapa(false, imprimir);
	}
}
