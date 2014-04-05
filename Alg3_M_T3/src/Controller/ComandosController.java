package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import View.MapaView;
import View.NaviosView;
import View.NiveisView;

public class ComandosController {
	
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	MapaController mc = new MapaController();
	NiveisView niveis  = new NiveisView();
	NaviosView navios = new NaviosView();
	
	
	/**
	 * Imprime mapa inicial do jogo!
	 * @throws Exception
	 */
	public void executaMapaInicial() throws Exception {
		m.criaMapa();
		niveis.executa(true, 1);
		mc.imprimeView(true,"\n"+"MAPA DO JOGO! ");
		
	}
	
	public void imprimirInfocoes() throws Exception {
		m.criaMapa();
		mv.imprime(true,"Mapa do jogo");
		Prints.msgl();
		navios.imprime(false);
		Prints.msgl();
		niveis.imprime(false ,true);
	}
}
