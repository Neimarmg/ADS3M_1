package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import Model.SoldadoModel;
import View.MapaView;

public class Controlador {
	
	private static int chances = 0;
	private static int acertos = 0;
	MapaView mv = new MapaView();
	
	/**
	 * Método de processamento da jogada
	 * @param linha
	 * @param coluna
	 * @param dado
	 */
	private void encontraAlvo(int linha, int coluna,String dado) {
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j < MapaModel.getLinha(); j++) {				
				
				if (i == linha && j == coluna && MapaModel.mapa[i][j].equals("-") ){
					acertos += 3;
				}	
				
				if (i == linha && j == coluna ){
					MapaModel.mapa[i][j] = dado;
					Prints.msgl();					
				}				
			}
		}
	}

	
	public void ValidaAlvo(int linha, int coluna,String dado) throws Exception {
		
		if ((linha >= MapaModel.getLinha() || coluna >= MapaModel.getColuna()) &&
			(linha < MapaModel.getLinha() || coluna < MapaModel.getColuna())){
				Prints.msgb("As cordenadas não sao válidas!");
		}else{
			chances--;	
			encontraAlvo(linha, coluna, dado);	
			//mv.imprime(false," ");
		}	
	}
	
	
	public static int getAcertos() {		
		return acertos;
	}
	
	
	public static int getChances() {
		return chances + SoldadoModel.getPontuacaoInicial();
	}
}
