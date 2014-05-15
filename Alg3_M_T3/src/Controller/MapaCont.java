package Controller;

import java.util.InputMismatchException;

import Model.MapaMod;
import View.MapaView;
import Model.Utilitarios.Prints;

/**
 * Classe para edi��o e personaliza��o dos navios (N�O IMPLEMENTADA)
 * @author Neimar
 */
public class MapaCont extends MapaMod {
	
	MapaView mapaView = new MapaView();
	
	
	public static void setaColuna() throws Exception {
		try {	
			MapaMod.setColuna(Prints.digitaNumero("\nDigite nro. de coluna. "));
			if (getColuna()<= 30){
				Prints.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaColuna();
			}
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um n�mero!\n");
		}
	}
	

	public static void setaLinha() throws Exception {
		try {
			MapaMod.setLinha(Prints.digitaNumero("Digite nro. de linha. "));	
			if (getLinha() <= 30) {
				Prints.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaLinha();
			}	
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
		}					
	}
		
	
	/**
	 * M�todo controlador de personaliza��o do mapaMod
	 * @throws Exception
	 */
	public static void iniciaMapa() throws Exception {
		Prints.msgc("	REDEFINIR DIMENS�ES DO MAPA");
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
		mapaView.imprime(mostraMsgCabelho, texto);		
	}	
}