package Controller.Utilitarios;

import Model.MapaModel;

public class Crude extends Prints {

	public void adiciona(int linha, int coluna, int casa) {
		
		for (int i = 0; i <  linha; i++) {
			for (int j = 0; j <  coluna; j++) {				
				if (j <= casa){
					MapaModel.mapa[i][j] = "-";	
				}
			}
		}
	}


	public void remove(int linha, int coluna, int casa) {
		
	}
}
