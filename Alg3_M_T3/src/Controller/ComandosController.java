package Controller;

import Model.MapaModel;

public class ComandosController {
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();
	
	/**
	 * Imprime mapa inicial do jogo!
	 * @throws Exception
	 */
	public void executaMapaInicial() throws Exception {
		m.criaMapa();
		mc.imprimeView(true,"\n"+"TABULEIRO DO JOGO! ");	
	}
}
