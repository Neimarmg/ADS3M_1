package C;

import java.util.InputMismatchException;

import M.MapaMod;
import V.View;

/**
 * Classe para edi��o e personaliza��o dos navios (N�O IMPLEMENTADA)
 * @author Neimar
 */
public class Gerador extends MapaMod {
	
	PrintMapa printMapa = new PrintMapa();
	
	
	public static void setaColuna() throws Exception {
		try {	
			MapaMod.setColuna(View.digitaNumero("\nDigite nro. de coluna. "));
			if (getColuna()<= 30){
				View.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaColuna();
			}
		} catch (InputMismatchException e) {
			View.msge("\nEra esperado um n�mero!\n");
		}
	}
	

	public static void setaLinha() throws Exception {
		try {
			MapaMod.setLinha(View.digitaNumero("Digite nro. de linha. "));	
			if (getLinha() <= 30) {
				View.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaLinha();
			}	
		} catch (InputMismatchException e) {
			View.msge("\nEra esperado um numero!\n");
		}					
	}
		
	
	/**
	 * M�todo controlador de personaliza��o do mapaMod
	 * @throws Exception
	 */
	public static void iniciaMapa() throws Exception {
		View.msgc("	REDEFINIR DIMENS�ES DO MAPA");
		setaColuna();
		setaLinha();
		criaMapa();		
	}	
	
	/**
	 * M�todo de impress�o de dados
	 * @param mostraMsgCabelho
	 * @param texto
	 * @throws Exception
	 */
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		printMapa.imprime(mostraMsgCabelho, texto);		
	}	
}