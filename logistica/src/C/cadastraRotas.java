package C;

import M.rotas;
import V.View;

public class cadastraRotas {
	
	public static void insereDistancia(){
		try {
			/*IMPLEMENTAR! o insert chamando os m�todo set da classe rotas que recebe um float 
			 * dica observer os metodos inset de uutro cadastros*/
			
					
		} catch (NumberFormatException e) {
			View.dadoInvalido();
			insereDistancia();
		}			
	}
	

	public static void imprime(){
		View.msg("\nDist�ncia: "+rotas.getDistancia()+"km");
	}
}
