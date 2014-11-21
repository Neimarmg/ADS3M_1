package C;

import java.util.Random;
import V.View;
import C.Estruturas.Grafo;
/**
 * Classe de criação da estrutura do grafo
 * @author Grupo
 */
public class GrafoControle {
	static Random r = new Random();
	
	/**
	 * Método de criação do grado apartir dos dados de vindo da arquivo 
	 * @param valor
	 * @param imprimir
	 */
	public static void criaGrafo(int valor, boolean imprimir) {		
		for (int i = 0; i < Grafo.getTamanho(); i++) {		        
			for (int j = 0; j < Grafo.getTamanho(); j++) {
				
				if (j == r.nextInt(Grafo.getTamanho())){
					Grafo.mapa[i][j] = valor++;
				}else {
					Grafo.mapa[i][j] = 0;
				}
				
			}
		}

		if (imprimir == true) {imprime(Grafo.mapa);}
	}


	/**
	 * Metodo de impressão de mapa
	 * @param vetor
	 * @return
	 */
	public static int [][]imprime(int vetor[][]) {
			
		View.msg("_|");

		for (int i = 0; i < Grafo.getTamanho(); i++) {
			View.msg(" " +i);			
		}

		for (int i = 0; i < Grafo.getTamanho(); i++) {			
			View.msg("\n" +i +"| ");
			for (int j = 0; j < Grafo.getTamanho(); j++) {
				
				if (j < 9) {					
					if (vetor[i][j] > 9 ) {
						View.msg(vetor[i][j]+" ");
					}else {					
						View.msg(vetor[i][j]+"  ");
					}
				}if (j > 9){
					if (vetor[i][j] > 9 ) {
						View.msg(vetor[i][j]+" ");
					}else {					
						View.msg(vetor[i][j]+"  ");
					}
				}
			}
		}
		View.msg("\n\n");
		return vetor;
	}	
}
