package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE1 {
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	private void escreveCabecalho() {
	    Prints.msgb("	EXERCÍCIO DE ESTRUTURAS LINEARES E1");
	}
	
	
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		Prints.mostarMenuMaim();
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();   
	}
}