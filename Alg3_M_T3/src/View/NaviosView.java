package View;
import Controller.Utilitarios.Prints;
import Model.NaviosModel;

public class NaviosView {
	Prints p = new Prints();
	
	public void imprimeNavios(boolean filtrar, String parametro){
		
		if (parametro.equals("portaAvioes") && filtrar == true || filtrar == false) {
			p.msg("\nPortaAvioes tamanho " +NaviosModel.getPortaavioes() +"m\n");
		}
			
		if (parametro.equals("destroyers")&& filtrar == true || filtrar == false) {
			p.msg("\nDestroyers tamanho " +NaviosModel.getDestroyers() +"m\n");
		}
			
		if (parametro.equals("fragatas")&& filtrar == true || filtrar == false) {
			p.msg("\nFragatas tamanho " +NaviosModel.getFragatas() +"m\n");
		}
				
		if (parametro.equals("torpedeiros")&& filtrar == true || filtrar == false) {
			p.msg("\nTorpedeiros Tamanho " +NaviosModel.getTorpedeiros() +"m\n");
		}
		
		if (parametro.equals("submarinos")&& filtrar == true || filtrar == false) {
			p.msg("\nSubmarinos tamanho " +NaviosModel.getSubmarinos() +"m\n");
		}
	}
}