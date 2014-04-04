
package Controller;

import java.util.InputMismatchException;
import Controller.Utilitarios.Prints;
import Model.NiveisModel;


public class Batalha {
	Controlador c = new Controlador();	
	
	
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.ValidaAlvo(
				Prints.digitaNumero("Nro linha"),
				Prints.digitaNumero("Nro coluna" ),"O");
			
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um dígito como cordenáda!");
		}	
	
	}
	
	
	/**
	 * Define Passagem de nivel no jogo
	 * @param nivel
	 */
	public static void addNivel(int nivel){
		
		if (nivel == NiveisModel.getMapanivel1()){

		}
		
		if (nivel == NiveisModel.getMapanivel2()){
			
		}
		
		if (nivel == NiveisModel.getMapanivel3()){
			
		}
		
		if (nivel == NiveisModel.getMapanivel4()){
			
		}
		
		if (nivel == NiveisModel.getMapanivel5()){
			
		}		
	}	
}
