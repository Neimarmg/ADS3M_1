package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import View.MapaView;

public class MapaController {
	
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	
	public void setaExtencao() {
		MapaModel.setExtancaoY(Prints.digitaNumero("Digita exteção máxima Y "));
	}
	
	
	public void setaColuna() {
		MapaModel.setColuna(Prints.digitaNumero("Digita nro de colunas "));
	}
	
	
	public void setaLinha() {
		MapaModel.setLinha(Prints.digitaNumero("Digita nro de linha "));	
	}
		
	
	public void iniciaMapa() throws Exception {
		setaExtencao();
		setaColuna();
		setaLinha();
		m.criaMapa();
	}	
	
	
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mv.imprime(mostraMsgCabelho, texto);		
	}	
}
