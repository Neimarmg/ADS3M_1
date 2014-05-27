package C;

import M.MapaMod;
import V.View;

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
		View.msgl();
		printNavios.imprime(false,true);
		View.msgl();
		PrintNiveis.imprime(false ,true);
		View.msgl();
		printSoldado.imprime();
	}
	
	/**
	 * M�todo de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		printNavios.imprime(filtrar,mostraCabecalho);
		View.msgl();
	}
	
	
	/**
	 * M�todo de consulta aos n�veis do jogo
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		View.msgl();
		PrintNiveis.imprime(filtrar,true);
	}
	
	/**
	 * M�todo de consulta a dados do soldado
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		View.msgl();
		printSoldado.imprime();
	}
}