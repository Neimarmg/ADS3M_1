
package Controller;

import java.util.InputMismatchException;
import Controller.Utilitarios.Prints;
import Model.SoldadoModel;


public class Batalha extends SoldadoModel {
	Controlador c = new Controlador();	
	
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.validaParemetros(
				Prints.digitaNumero("Nro linha"),
				Prints.digitaNumero("Nro coluna" ),"O");
			
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um d�gito como corden�da!");
		}	
	}
	
}
