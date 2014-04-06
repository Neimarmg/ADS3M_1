package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaMod;
import View.MapaView;
import View.NaviosView;
import View.NiveisView;
import View.SoldadosView;

public class InterfaceCont {
	
	MapaMod m = new MapaMod();
	MapaView mv = new MapaView();
	MapaCont mc = new MapaCont();
	NiveisView niveis  = new NiveisView();
	NaviosView navios = new NaviosView();
	SoldadosView soldado = new SoldadosView();

	
	
	/**
	 * Método de imprissao de todos os dados do jogo
	 * @throws Exception
	 */
	public void abreInfocoes() throws Exception {
		m.criaMapa();
		mv.imprime(true,"Mapa do jogo");
		Prints.msgl();
		navios.imprime(false,true);
		Prints.msgl();
		niveis.imprime(false ,true);
		Prints.msgl();
		soldado.imprime();
	}
	
	/**
	 * 
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		navios.imprime(filtrar,mostraCabecalho);
		Prints.msgl();
	}
	
	
	/**
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		Prints.msgl();
		niveis.imprime(filtrar,true);
	}
	
	/**
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		Prints.msgl();
		soldado.imprime();
	}
}
