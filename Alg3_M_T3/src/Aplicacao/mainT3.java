package Aplicacao;

import Controller.Utilitarios.*;

public class mainT3 {
	Prints p = new Prints();
	Comandos in = new Comandos();	
	Dia d = new Dia();

	
	private void escreveCabecalho() {
		p.msg("Exercicío de matrizes T3\n");
	    p.msgb("		JOGO BATALHA NAVAL \n\n		     BEM VINDO");
	}
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		p.menuMain();
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainT3().run();    
	}
}