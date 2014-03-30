package View;

import Controller.Utilitarios.prints;
import Model.mapa;

public class mapaView {
	
	mapa m = new mapa();
	prints p = new prints();
	
	
	private void imprimeCampo(){
		for (int i = 0; i <  mapa.getLinha(); i++) {
			for (int j = 0; j <  mapa.getColuna(); j++) {
				if (j == 9 ){
					p.msg(" " + m.getCampo()[i][j]+"\n");
				}else{
					p.msg(" " + m.getCampo()[i][j]);
				}				
				
			}						
		}
	}

	
	public void Campo(){
		m.criaCampo();
		imprimeCampo();
	}
}
