package Aplicacao;

import View.Utilitarios.*;

public class mainT3 {

	Interface Interface = new Interface();	
	Dia dia = new Dia();

	
	private void escreveCabecalho() {
		Prints.msg("Exercício de matrizes T3\n");
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
		new mainT3().run();    
	}
	
}