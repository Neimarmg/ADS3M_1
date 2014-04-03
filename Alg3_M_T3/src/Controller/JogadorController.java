
package Controller;

import java.util.InputMismatchException;
import Controller.Utilitarios.Crude;
import Controller.Utilitarios.Prints;
import Model.SoldadoModel;


public class JogadorController extends SoldadoModel {
	Crude c = new Crude();	
	
	public void atira() throws Exception{
		try {
			Prints.msgl();
			c.validaParemetros(
				Prints.digitaNumero("Nro linha"),
				Prints.digitaNumero("Nro coluna" ),"O");
			
		} catch (InputMismatchException e) {
			Prints.msgb("Era esperado um dígito como cordenáda!");
		}	
	}
	
}
