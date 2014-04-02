package Controller;

import Model.MapaModel;
import View.NiveisView;

public class ComandosController {
	
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();
	NiveisView nv  = new NiveisView();
	
	/**
	 * Imprime mapa inicial do jogo!
	 * @throws Exception
	 */
	public void executaMapaInicial() throws Exception {
		m.criaMapa();
		nv.executa(true, 1);
		mc.imprimeView(true,"\n"+"MAPA DO JOGO! ");
		
	}
}
