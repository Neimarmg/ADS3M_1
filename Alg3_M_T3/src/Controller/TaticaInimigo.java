package Controller;

import Model.MapaModel;
import View.MapaView;
/**
 * Classe resposavel pelas distribuição das embarcaçãoe no mapa
 * @author moises
 */
public class TaticaInimigo {
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	private void selecionaNavios() {
		
	}

	private void serteiaLinha() {
		
	}

	
	private void verficaUnidades() {
		
	}


	private void posiciona() {
		
	}

	
	public void processaNinvel() {
		try {
			m.criaMapa();
			mv.imprime(true, "Matriz processeda");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
