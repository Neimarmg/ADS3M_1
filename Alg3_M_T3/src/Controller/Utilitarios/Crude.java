package Controller.Utilitarios;

import Model.MapaModel;
import View.MapaView;

public class Crude {
	MapaView mv = new MapaView();
		
	public void executaJogada(int linha, int coluna,String dado) {
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j < MapaModel.getLinha(); j++) {				
				if (i == linha && j == coluna ){
					MapaModel.mapa[i][j] = dado;
					Prints.msgl();
					
				}
			}
		}
	}

	public void validaParemetros(int linha, int coluna,String dado) throws Exception {
		
		if ((linha >= MapaModel.getLinha() || coluna >= MapaModel.getColuna())){
			Prints.msgb("As cordenadas não sao válidas!");
		}else{
			executaJogada(linha, coluna, dado);	
			mv.imprime(false," ");
		}	
	}

	
	
	
	

	public void remove(int linha, int coluna, int casa) {
		
	}
}
