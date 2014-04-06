package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaMod;
import Model.SoldadoMod;
import View.MapaView;

public class Inimigo {
	
	private static int chances = 0;
	private static int acertos = 0;
	MapaView mv = new MapaView();
	
	
	public static void setAcertos(int acertos) {
		Inimigo.acertos = acertos;
	}
	
	
	public static void setChances(int chances) {
		Inimigo.chances = chances;
	}
	
	
	public static int getAcertos() {		
		return acertos;
	}
	
	
	public static int getChances() {
		return chances + SoldadoMod.getPontuacaoInicial();
	}
	
	
	/**
	 * Método de processamento da jogada
	 * @param linha
	 * @param coluna
	 * @param dado
	 */
	private void encontraAlvo(int linha, int coluna,String dado) {
		for (int i = 0; i <  MapaMod.getLinha(); i++) {
			for (int j = 0; j < MapaMod.getLinha(); j++) {				
				
				if (i == linha && j == coluna && MapaMod.mapa[i][j].equals("-") ){
					acertos += 3;
				}	
				
				if (i == linha && j == coluna ){
					MapaMod.mapa[i][j] = dado;
					Prints.msgl();					
				}				
			}
		}
	}

	
	public void ValidaAlvo(int linha, int coluna,String dado) throws Exception {
		
		if ((linha >= MapaMod.getLinha() || coluna >= MapaMod.getColuna()) &&
			(linha < MapaMod.getLinha() || coluna < MapaMod.getColuna())){
				Prints.msgb("As cordenadas não sao válidas!");
		}else{
			chances--;	
			encontraAlvo(linha, coluna, dado);	
			//mv.imprime(false," ");
		}	
	}
	
	

}
