package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaMod;
import View.MapaView;

public class MapaCont {
	
	MapaMod m = new MapaMod();
	MapaView mv = new MapaView();
	
	
	public void setaColuna() {
		MapaMod.setColuna(Prints.digitaNumero("Digita nro de colunas "));
	}
	
	
	public void setaLinha() {
		MapaMod.setLinha(Prints.digitaNumero("Digita nro de linha "));	
	}
		
	
	public void iniciaMapa() throws Exception {
		setaColuna();
		setaLinha();
		m.criaMapa();
	}	
	
	
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprime(mostraMsgCabelho, texto);		
	}	
}
