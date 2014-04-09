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
	 * M�todo que lista todas as consultas do jogo
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
	 * M�todo de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		naviosView.imprime(filtrar,mostraCabecalho);
		Prints.msgl();
	}
	
	
	/**
	 * M�todo de consulta aos n�veis do jogo
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		Prints.msgl();
		niveis.imprime(filtrar,true);
	}
	
	/**
	 * M�todo de consulta a dados do soldado
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		Prints.msgl();
		soldadoView.imprime();
	}
}