package Controller;

import Model.MapaMod;
import View.Prints;

public class Consultas {
	
	MapaMod mapaMod = new MapaMod();
	PrintMapa printMapa = new PrintMapa();
	MapaCont mapaCont = new MapaCont();
	PrintNiveis PrintNiveis  = new PrintNiveis();
	PrintNavios printNavios = new PrintNavios();
	PrintSoldados printSoldado = new PrintSoldados();
	Batalha batalha = new Batalha();

	/**
	 * M�todo que lista todas as consultas do jogo
	 * @throws Exception
	 */
	public void listaConsultas() throws Exception {
		batalha.iniciaMapa();
		Prints.msgl();
		printNavios.imprime(false,true);
		Prints.msgl();
		PrintNiveis.imprime(false ,true);
		Prints.msgl();
		printSoldado.imprime();
	}
	
	/**
	 * M�todo de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		printNavios.imprime(filtrar,mostraCabecalho);
		Prints.msgl();
	}
	
	
	/**
	 * M�todo de consulta aos n�veis do jogo
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		Prints.msgl();
		PrintNiveis.imprime(filtrar,true);
	}
	
	/**
	 * M�todo de consulta a dados do soldado
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		Prints.msgl();
		printSoldado.imprime();
	}
}