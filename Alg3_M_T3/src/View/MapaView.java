package View;

import Controller.Utilitarios.Prints;
import Model.MapaModel;

public class MapaView {
	int j,i;
	MapaModel m = new MapaModel();
	Prints p = new Prints();
	char letra = 'A';
	
	
	public void letraConluna(){
		p.msg("+ ");
		for (j = 0; j <  MapaModel.getColuna(); j++) {
			p.msg(" " + letra++ );
		}
	}
	
	
	private void imprimeCampo(){
		letraConluna();		
		for (i = 0; i <  MapaModel.getLinha(); i++) {
			p.msg("\n" +i +" ");
			for (j = 0; j <  MapaModel.getColuna(); j++) {				
				p.msg(" " + m.getCampo()[i][j]);				
			}
			
		}
		
	}

	
	public void Campo(){
		m.criaCampo();
		imprimeCampo();
	}
}
