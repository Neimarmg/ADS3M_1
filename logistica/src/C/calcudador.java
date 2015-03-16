package C;

import V.View;

public class calcudador {
	
	public static float calculaGastoTotal(float potencia, float  distancia, int capacidadeTanque){
		/*IMPLEMENTAR! Metodo de calcular o valor de combustivel total e retornar um valor float
		 *a referencias de calculo são os parametros recebido pelo metodo*/
		
		
		return 0;		
	}
	
	
	public static float calculaMediaPorLitro(float potencia, float  distancia, int capacidadeTanque){
		/*IMPLEMENTAR! Metodo de calcular media de conbustivel por litro e retornar um valor float
		 *a referencias de calculo são os parametros recebido pelo metodo*/
		
		return 0;
	}

	
	public static void executaCalculos(float potencia, float  distancia, int capacidadeTanque){
		View.msgb("Gasto médio por litro: "+calculaMediaPorLitro(potencia, distancia, capacidadeTanque)
				+"\nGasto total de combustivel: "+calculaGastoTotal(potencia, distancia, capacidadeTanque));
	}
	
	
}
