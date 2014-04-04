package Controller;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import Model.NaviosModel;
import Model.NiveisModel;
import View.MapaView;
import View.SoldadosView;

/**
 * Classe resposavel pelas distribuição das embarcaçãoe no mapa
 * @author moises
 */
public class TaticaInimiga {
	
	MapaModel m = new MapaModel();
	MapaView mv = new MapaView();
	Controlador c = new Controlador(); 
	SoldadosView sv = new SoldadosView();

	private int nivel = NiveisModel.getMapanivel1();
	private int contUnidades;
	
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	

	private void posiscionaNavio() {
		
		for (int i = 0; i <  MapaModel.getLinha(); i++) {
			for (int j = 0; j <  MapaModel.getColuna(); j++) {				
			
				if (i == 0 && j >= nivel && j < (NaviosModel.getUnidPortaAvioes()+nivel)){
					MapaModel.mapa[i][j] = "-";					
				}
					
				if (i == 5 && j >= nivel-1 && j < (NaviosModel.getUnidDestroyers()+nivel -1)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 2 && j >= nivel && j < (NaviosModel.getUnidDestroyers()+nivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 3 && j >= (nivel+2) && j < (NaviosModel.getUnidFragatas()+nivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 4 && j >= (nivel+1) && j < (NaviosModel.getUnidFragatas()+nivel+1)){
					MapaModel.mapa[i][j] = "-";					
				}
		
				
				if (i == 1 && j >= nivel && j < (NaviosModel.getUnidTorpedeiros()+nivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 6 && j >= (nivel+2) && j < (NaviosModel.getUnidTorpedeiros()+nivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 7 && j >= (nivel+1) && j < (NaviosModel.getUnidTorpedeiros()+nivel+1)){
					MapaModel.mapa[i][j] = "-";					
				}
		
				
				if (i == 8 && j >= nivel && j > (NaviosModel.getUnidTorpedeiros()+nivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				if (i == 8 && j >= ((nivel-6)*-1) && j < ((NaviosModel.getUnidTorpedeiros()+nivel-6)*-1)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (nivel+3) && j < (NaviosModel.getUnidTorpedeiros()+nivel)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (nivel+2) && j < (NaviosModel.getUnidTorpedeiros()+nivel+2)){
					MapaModel.mapa[i][j] = "-";					
				}
				
				
				if (i == 9 && j >= (nivel+1) && j < (NaviosModel.getUnidTorpedeiros()+nivel+1)){
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
			sv.imprime();
		}else{
			Prints.msgb("Mapa inesistente!");
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
