package Controller;

import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.Prints;

/**
 * Classe de para edição personalização do navios "NÃO IMPLEMENTADA"
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
	 * Método controlador de personalização do mapa
	 * @throws Exception
	 */
	public void iniciaMapa() throws Exception {
		setaColuna();
		setaLinha();
		m.criaMapa();
	}	
	
	/**
	 * Método de impressão de dados
	 * @param mostraMsgCabelho
	 * @param texto
	 * @throws Exception
	 */
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprime(mostraMsgCabelho, texto);		
	}	
}
