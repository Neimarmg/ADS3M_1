package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import View.MapaView;
/**
 * Classe resposavel pelas distribuição das embarcaçãoe no mapa
 * @author moises
 */
public class TaticaInimigo {
	
	Prints p = new Prints();
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	private int contNivel;
	private int contUnidades;
	
	
	private void mudaNivel() {
		
	}
	
	private void posiscionaNavio() {
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j <  MapaModel.getColuna(); j++) {				
				if (i == 1 && j < 5){
					m.mapa[i][j] = "-";				
				}
				if (i == 2 && j > 5){
					m.mapa[i][j] = "-";				
				}
				if (i == 3 && j < 5){
					m.mapa[i][j] = "-";				
				}
				if (i == 7 && j < 9){
					m.mapa[i][j] = "-";				
				}
				if (i == 9 && j <= 3){
					m.mapa[i][j] = "-";				
				}
			}			
		}
	}

	
	private void valida() {		
		contUnidades = 0; 
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j <  MapaModel.getColuna(); j++) {				
				if (MapaModel.getMapa()[i][j] != null){
					contUnidades++;				
				}			
			}			
		}
	}
	
	
	public void processaNinvel() {
		try {
			//m.criaMapa();
			valida();
			if(MapaModel.getColuna()*MapaModel.getLinha() == contUnidades){
				posiscionaNavio();
				mv.imprime(false, "");
			}else{
				p.msgb("Mapa inesistente!");
				m.criaMapa();
				processaNinvel();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
