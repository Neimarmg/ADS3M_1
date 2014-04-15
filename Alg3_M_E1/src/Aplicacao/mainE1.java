package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE1 {
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	/**
	 * Descrição do cabeçalho principal do programa
	 */
	private void escreveCabecalho() {
		Prints.msgb("	EXERCÍCIO DE ESTRUTURAS LINEARES\n\n"
			+"Listas encadeadas T1\n"
			+"Pesquisa binária T2\n"
			+"Algoritmos de ordenação T4");		
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