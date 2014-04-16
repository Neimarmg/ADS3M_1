package Aplicacao;

import javax.jws.Oneway;

import Estruturas.Ordenadores;
import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE {
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	/**
	 * Descri��o do cabe�alho principal do programa
	 */
	private void escreveCabecalho() {
		Prints.msgb("	EXERC�CIO DE ESTRUTURAS LINEARES\n\n"
			+"Listas encadeadas T1\n"
			+"Pesquisa bin�ria T2\n"
			+"Algoritmos de ordena��o T4");		
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
		//new mainE1().run();   
		
		Ordenadores o = new Ordenadores();
		o.bubleSort();
		o.pritBubleSort();
	}
}