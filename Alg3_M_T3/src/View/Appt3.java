package View;

import Model.Utilitarios.*;

public class Appt3 {

	Interface Interface = new Interface();	
	Dia dia = new Dia();

	
	private void escreveCabecalho() {
	    Prints.msgb("		JOGO BATALHA NAVAL \n\n		     BEM-VINDO");
	}
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		dia.defineSaudacao();
		Menus.menuMain();
		Interface.inicia();
	}
	

	public static void main(String[] args)throws Exception {
		new Appt3().run();    
	}
	
}