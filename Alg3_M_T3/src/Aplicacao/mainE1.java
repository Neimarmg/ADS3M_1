package Aplicacao;

import Controller.Utilitarios.Dia;
import Controller.Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();

	Dia d = new Dia();
	
	private void escreveCabecalho() {
		i.msg("Exercicío de matrizes T3\n");
	    i.msgb("		JOGO BATALHA NAVAL \n\n		     BEM VINDO");
	}
	
	
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		i.mostarMenuMaim();
		//in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();    
	}
}