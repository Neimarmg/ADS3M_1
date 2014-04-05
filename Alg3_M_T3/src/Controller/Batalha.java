
package Controller;
import java.util.InputMismatchException;

import Controller.Utilitarios.Prints;
import Model.MapaModel;
import Model.NiveisModel;

public class Batalha {
	private static int add = 0;
	Controlador c = new Controlador();	
	
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.ValidaAlvo(Prints.digitaNumero("Nro linha"),
						 Prints.digitaNumero("Nro coluna" ),"O");
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um dígito como cordenáda!");
		}	
	}
	
	
	/**
	 * Define Passagem de nivel no jogo
	 * @param add
	 */
	public static void addNivel(){
		add++;
		if (add == NiveisModel.getMapanivel1()){
			TaticaInimiga.setNivel(NiveisModel.getNivel1());
			MapaModel.setColuna(NiveisModel.getMapanivel1());
			MapaModel.setColuna(NiveisModel.getMapanivel1());
		}
		
		if (add == NiveisModel.getMapanivel2()){
			TaticaInimiga.setNivel(NiveisModel.getNivel2());
			MapaModel.setColuna(NiveisModel.getMapanivel2());
			MapaModel.setColuna(NiveisModel.getMapanivel2());
		}
		
		if (add == NiveisModel.getMapanivel3()){
			TaticaInimiga.setNivel(NiveisModel.getNivel3());
			MapaModel.setColuna(NiveisModel.getMapanivel3());
			MapaModel.setColuna(NiveisModel.getMapanivel3());
		}
		
		if (add == NiveisModel.getMapanivel4()){
			TaticaInimiga.setNivel(NiveisModel.getNivel3());
			MapaModel.setColuna(NiveisModel.getMapanivel4());
			MapaModel.setColuna(NiveisModel.getMapanivel4());
		}
		
		if (add == NiveisModel.getMapanivel5()){
			TaticaInimiga.setNivel(NiveisModel.getNivel5());
			MapaModel.setColuna(NiveisModel.getMapanivel5());
			MapaModel.setColuna(NiveisModel.getMapanivel5());
		}		
	}	
}
