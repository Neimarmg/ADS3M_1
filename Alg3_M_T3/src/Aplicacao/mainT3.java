package Aplicacao;

import View.Utilitarios.*;

public class mainT3 {

	Interface in = new Interface();	
	Dia d = new Dia();

	
	private void escreveCabecalho() {
		Prints.msg("Exercic�o de matrizes T3\n");
	    Prints.msgb("		JOGO BATALHA NAVAL \n\n		     BEM VINDO");
	}
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		Prints.menuMain();
		in.inicia();
	}
	

	public static void main(String[] args)throws Exception {
		new mainT3().run();    
	}
}