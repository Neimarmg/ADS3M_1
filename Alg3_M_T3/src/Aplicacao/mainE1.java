package Aplicacao;

import Controller.Utilitarios.*;
import Model.mapa;
import View.mapaView;

public class mainE1 {
	prints i = new prints();
	Interface in = new Interface();
	mapa m = new mapa();

	dia d = new dia();
	mapaView mv = new mapaView();
	
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
		m.criaCampo();
		mv.Campo();
		
	
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();    
	}
}