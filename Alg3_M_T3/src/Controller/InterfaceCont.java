package Controller;

import Model.MapaMod;
import View.MapaView;
import View.NaviosView;
import View.NiveisView;
import View.SoldadosView;
import View.Utilitarios.Prints;

public class InterfaceCont {
	
	MapaMod m = new MapaMod();
	MapaView mv = new MapaView();
	MapaCont mc = new MapaCont();
	NiveisView niveis  = new NiveisView();
	NaviosView navios = new NaviosView();
	SoldadosView soldado = new SoldadosView();
	Batalha b = new Batalha();

	
	
	/**
	 * Método que lista todas as consultas do jogo
	 * @throws Exception
	 */
	public void listaConsultas() throws Exception {
		b.iniciaMapa();
		Prints.msgl();
		navios.imprime(false,true);
		Prints.msgl();
		niveis.imprime(false ,true);
		Prints.msgl();
		soldado.imprime();
	}
	
	/**
	 * Metodo de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		navios.imprime(filtrar,mostraCabecalho);
		Prints.msgl();
	}
	
	
	/**
	 * Método de consulta aos nuveis de jogo
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		Prints.msgl();
		niveis.imprime(filtrar,true);
	}
	
	/**
	 * Método de consulta a dodos do soldado
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		Prints.msgl();
		soldado.imprime();
	}
}
