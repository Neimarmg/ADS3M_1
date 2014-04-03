package Aplicacao;

import Controller.Utilitarios.*;

public class mainT3 {

	Comandos in = new Comandos();	
	Dia d = new Dia();

	
	private void escreveCabecalho() {
		Prints.msg("Exercicío de matrizes T3\n");
	    Prints.msgb("		JOGO BATALHA NAVAL \n\n		     BEM VINDO");
	}
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		Prints.menuMain();
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainT3().run();    
	}
}