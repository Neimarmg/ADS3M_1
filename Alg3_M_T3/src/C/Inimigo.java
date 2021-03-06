package C;

import M.MapaMod;
import M.SoldadoMod;
import V.View;

/**
 * Classe validadora de comandos
 * @author Neimar, Aur�lio
 */
public class Inimigo {
	
	private static int chances = 0;
	private static int acertos = 0;
	PrintMapa mapaView = new PrintMapa();
	
	/**
	 * @param acertos
	 */
	public static void setAcertos(int acertos) {
		Inimigo.acertos = acertos;
	}
	
	/**
	 * @param chances
	 */
	public static void setChances(int chances) {
		Inimigo.chances = chances;
	}
	
	/**
	 * @return
	 */
	public static int getAcertos() {		
		return acertos;
	}
	
	/**
	 * @return
	 */
	public static int getChances() {
		return chances + SoldadoMod.getPontuacaoInicial();
	}
	
	/**
	 * M�todo de processamento da jogada
	 * @param linha
	 * @param coluna
	 * @param dado
	 */
	private void encontraAlvo(int linha, int coluna,String dado) {
		for (int i = 0; i <  MapaMod.getLinha(); i++) {
			for (int j = 0; j < MapaMod.getLinha(); j++) {				
				
				if (i == linha && j == coluna && MapaMod.mapa[i][j].equals("-")) {
					acertos += 3;
				}	
				
				if (i == linha && j == coluna ) {
					MapaMod.mapa[i][j] = dado;
					View.msgl();					
				}				
			}
		}
	}

	
	/**
	 * M�todo de valida��o dados
	 * @param linha
	 * @param coluna
	 * @param dado
	 * @throws Exception
	 */
	public void ValidaAlvo(int linha, int coluna,String dado) throws Exception {
		
		if ((linha >= MapaMod.getLinha() || coluna >= MapaMod.getColuna()) &&
			(linha < MapaMod.getLinha() || coluna < MapaMod.getColuna())) {
				View.msgb("As coordenadas n�o sao v�lidas!");
		} else {
			chances--;	
			encontraAlvo(linha, coluna, dado);	
			// printMapa.setLetra('A'); // Imprime colunas refer�ncia do mapa
			// printMapa.imprime(false," "); // Imprime mapa para confer�ncia de posicionamento
		}	
	}
	
}