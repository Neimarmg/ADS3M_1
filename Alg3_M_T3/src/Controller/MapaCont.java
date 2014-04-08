package Controller;

import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.Prints;

/**
 * Classe de para edi��o personaliza��o do navios "N�O IMPLEMENTADA"
 * @author Neimar
 */
public class MapaCont {
	
	MapaMod m = new MapaMod();
	MapaView mv = new MapaView();
	
	
	public void setaColuna() {
		MapaMod.setColuna(Prints.digitaNumero("Digita nro de colunas "));
	}
	
	
	public void setaLinha() {
		MapaMod.setLinha(Prints.digitaNumero("Digita nro de linha "));	
	}
		
	
	/**
	 * M�todo controlador de personaliza��o do mapa
	 * @throws Exception
	 */
	public void iniciaMapa() throws Exception {
		setaColuna();
		setaLinha();
		m.criaMapa();
	}	
	
	/**
	 * M�todo de impress�o de dados
	 * @param mostraMsgCabelho
	 * @param texto
	 * @throws Exception
	 */
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprime(mostraMsgCabelho, texto);		
	}	
}
