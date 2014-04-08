package Controller;

import java.util.InputMismatchException;

import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.Prints;

/**
 * Classe de para edição personalização do navios "NÃO IMPLEMENTADA"
 * @author Neimar
 */
public class MapaCont extends MapaMod {
	
	
	MapaView mapaView = new MapaView();
	
	
	public static void setaColuna() {
		try {
			MapaMod.setColuna(Prints.digitaNumero("Digita nro de colunas "));
			if (getColuna()> 30){
				Prints.msge("\nO Nro de chances deve ser mair doque " +getColuna() +"\n");
				setaColuna();
			}			
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
			setaColuna();
		}
	}
	

	public static void setaLinha() {
		try{
			MapaMod.setLinha(Prints.digitaNumero("Digita nro de linha "));	
			if (getLinha() > 30){
				Prints.msge("\nO Nro de chances deve ser mair doque " +getLinha() +"\n");
				setaLinha();
			}
			
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
			setaLinha();
		}
	}
		
	
	/**
	 * Método controlador de personalização do mapa
	 * @throws Exception
	 */
	public static void iniciaMapa() throws Exception {
		Prints.msgc("	REDEFINIR DIMENÇÕES DO MAPA");
		setaColuna();
		setaLinha();
		criaMapa();
		
	}	
	
	/**
	 * Método de impressão de dados
	 * @param mostraMsgCabelho
	 * @param texto
	 * @throws Exception
	 */
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mapaView.imprime(mostraMsgCabelho, texto);		
	}	
}
