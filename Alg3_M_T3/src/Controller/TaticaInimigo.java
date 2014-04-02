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

	
	private void consultaLinha() {
		
	}


	private void posiciona() {
		
	}

	
	public void processaInvel() {
		try {
			m.criaMapa();
			mv.imprime(true, "Matriz processeda");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
