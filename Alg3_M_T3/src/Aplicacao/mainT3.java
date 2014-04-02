package Aplicacao;

import Controller.mapaController;
import Controller.Utilitarios.*;
import Model.MapaModel;

public class mainT3 {
	Prints p = new Prints();
	Interface in = new Interface();	
	Dia d = new Dia();
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();

	
	private void escreveCabecalho() {
		p.msg("Exercicío de matrizes T3\n");
	    p.msgb("		JOGO BATALHA NAVAL \n\n		     BEM VINDO");
	}
	
	/**
	 * Imprime mapa inicial do jogo!
	 * @throws Exception
	 */
	public void mapa() throws Exception {
		m.criaMapa();
		mc.imprimeView(true,"\n"+"TABULEIRO DO JOGO! ");	
	}
	
	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		d.defineSaudacao();
		p.mostarMenuMaim();
		mapa();
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainT3().run();    
	}
}