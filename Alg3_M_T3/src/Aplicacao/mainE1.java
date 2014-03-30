package Aplicacao;

import Controller.Utilitarios.*;
import Model.MapaModel;
import View.MapaView;

public class mainE1 {
	Prints i = new Prints();
	Interface in = new Interface();
	MapaModel m = new MapaModel();

	Dia d = new Dia();
	MapaView mv = new MapaView();
	
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