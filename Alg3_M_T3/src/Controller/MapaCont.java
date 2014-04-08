package Controller;

import java.util.InputMismatchException;

import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.Prints;

/**
 * Classe de para edi��o personaliza��o do navios "N�O IMPLEMENTADA"
 * @author Neimar
 */
public class MapaCont extends MapaMod {
	
	MapaView mapaView = new MapaView();
	
	
	public static void setaColuna() throws Exception{
		try{	
			MapaMod.setColuna(Prints.digitaNumero("\nDigita nro de colunas "));
			if (getColuna()<= 30){
				Prints.msge("\nO Nro de chances deve ser mair doque 30\n");
				setaColuna();
			}
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
		}
	}
	

	public static void setaLinha() throws Exception{
		try {
			MapaMod.setLinha(Prints.digitaNumero("Digita nro de linha "));	
			if (getLinha() <= 30){
				Prints.msge("\nO Nro de chances deve ser mair doque 30\n");
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
		Prints.msgc("	REDEFINIR DIMEN��ES DO MAPA");
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
