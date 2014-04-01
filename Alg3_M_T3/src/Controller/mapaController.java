package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import View.MapaView;

public class mapaController {
	
	Prints p =  new Prints();
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	public void defineColuna(boolean defineConlunas) {
		if (defineConlunas == true){
			m.setColuna(p.digitaNumero("Digita nro de colunas "));
		}else{
			m.setColuna(10);
		}
	}
	
	
	public void defineLinha(boolean defineLinhas) {
		if (defineLinhas == true ){
			m.setLinha(p.digitaNumero("Digita nro de linha "));	
		}else{
			m.setLinha(10);
		}		
	}
	
	
	public void iniciaTabuleiro(boolean defineTabuleiro) throws Exception {
		defineColuna(defineTabuleiro);
		defineLinha(defineTabuleiro);
		m.criaTabuleiro();

		
	}	
	
	
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprimeTabuleiro(mostraMsgCabelho, texto);		
	}	
}
