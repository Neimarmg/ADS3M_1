package Aplicacao;

import Controller.Utilitarios.Dia;
import Controller.Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	private void escreveCabecalho() {
	    i.msgb("	EXERCÍCIO DE ESTRUTURAS LINEARES T3");
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