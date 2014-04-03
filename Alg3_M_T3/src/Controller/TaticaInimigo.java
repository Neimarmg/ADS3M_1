package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import Model.NaviosModel;
import View.MapaView;
/**
 * Classe resposavel pelas distribuição das embarcaçãoe no mapa
 * @author moises
 */
public class TaticaInimigo {
	
	Prints p = new Prints();
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	
	private int contNivel =3;
	private int contUnidades;
		
		
	private void mudaNivel() {
		
		
	}
	
	private void posiscionaNavio() {
		
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j <  MapaModel.getColuna(); j++) {				
				if (i == 0 && j >= contNivel && j < (NaviosModel.getUnidPortaAvioes()+contNivel)){
					MapaModel.mapa[i][j] = "-";					
				}
					
				if (i == 5 && j >= contNivel-1 && j < (NaviosModel.getUnidDestroyers()+contNivel -1)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 2 && j >= contNivel && j < (NaviosModel.getUnidDestroyers()+contNivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 3 && j >= (contNivel+2) && j < (NaviosModel.getUnidFragatas()+contNivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 4 && j >= (contNivel+1) && j < (NaviosModel.getUnidFragatas()+contNivel+1)){
					MapaModel.mapa[i][j] = "-";					
				}
		
				
				if (i == 1 && j >= contNivel && j < (NaviosModel.getUnidTorpedeiros()+contNivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 6 && j >= (contNivel+2) && j < (NaviosModel.getUnidTorpedeiros()+contNivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 7 && j >= (contNivel+1) && j < (NaviosModel.getUnidTorpedeiros()+contNivel+1)){
					MapaModel.mapa[i][j] = "-";					
				}
		
				
				if (i == 8 && j >= contNivel && j > (NaviosModel.getUnidTorpedeiros()+contNivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 8 && j >= ((contNivel-6)*-1) && j < ((NaviosModel.getUnidTorpedeiros()+contNivel-6)*-1)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (contNivel+3) && j < (NaviosModel.getUnidTorpedeiros()+contNivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (contNivel+2) && j < (NaviosModel.getUnidTorpedeiros()+contNivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (contNivel+1) && j < (NaviosModel.getUnidTorpedeiros()+contNivel+1)){
					MapaModel.mapa[i][j] = "-";					
				}				
			}			
		}
	}

	/**
	 * Método de validação ma matris
	 * @throws Exception
	 */
	private void valida()throws Exception{		
		contUnidades = 0; 
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j <  MapaModel.getColuna(); j++) {				
				if (MapaModel.getMapa()[i][j] != null){
					contUnidades++;				
				}			
			}			
		}
	}
	
	/**
	 * Método de carregamento de dados
	 * @throws Exception
	 */
	private void carrega() throws Exception {
		
		if(MapaModel.getColuna()*MapaModel.getLinha() == contUnidades){
			posiscionaNavio();
			mv.imprime(false,null);
		}else{
			p.msgb("Mapa inesistente!");
			executaTatica();
		}
	}
	
	
	/** 
	 * Executa tática do inimigo ante de iniciar o o jogo
	 * @throws Exception
	 */
	public void executaTatica()throws Exception {
		try {
			valida();
			carrega();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
