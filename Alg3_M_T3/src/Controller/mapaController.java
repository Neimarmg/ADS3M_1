package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import View.MapaView;

public class mapaController {
	
	Prints p =  new Prints();
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	public void defineExtencao() {
		MapaModel.setExtancaoY(p.digitaNumero("Digita exteção máxima Y "));
	}
	
	public void defineColuna() {
		MapaModel.setColuna(p.digitaNumero("Digita nro de colunas "));
	}
	
	
	public void defineLinha() {
		MapaModel.setLinha(p.digitaNumero("Digita nro de linha "));	
	}
		
	public void iniciaTabuleiro() throws Exception {
		defineExtencao();
		defineColuna();
		defineLinha();
		m.criaTabuleiro();
	}	
	
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprimeTabuleiro(mostraMsgCabelho, texto);		
	}	
}
