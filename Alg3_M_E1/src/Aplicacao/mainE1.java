package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	private void escreveCabecalho() {
	    i.msgb("	EXERC�CIO DE ESTRUTURAS LINEARES E1");
	}
	
	
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		i.mostarMenuMaim();
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();    
	}
}