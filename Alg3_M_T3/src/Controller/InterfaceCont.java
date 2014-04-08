package Controller;

import Model.MapaMod;
import View.MapaView;
import View.NaviosView;
import View.NiveisView;
import View.SoldadosView;
import View.Utilitarios.Prints;

public class InterfaceCont {
	
	MapaMod mapaMod = new MapaMod();
	MapaView mapaView = new MapaView();
	MapaCont mapaCont = new MapaCont();
	NiveisView niveis  = new NiveisView();
	NaviosView naviosView = new NaviosView();
	SoldadosView soldadoView = new SoldadosView();
	Batalha batalha = new Batalha();

	
	
	/**
	 * Método que lista todas as consultas do jogo
	 * @throws Exception
	 */
	public void listaConsultas() throws Exception {
		batalha.iniciaMapa();
		Prints.msgl();
		naviosView.imprime(false,true);
		Prints.msgl();
		niveis.imprime(false ,true);
		Prints.msgl();
		soldadoView.imprime();
	}
	
	/**
	 * Metodo de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		naviosView.imprime(filtrar,mostraCabecalho);
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
		soldadoView.imprime();
	}
}
