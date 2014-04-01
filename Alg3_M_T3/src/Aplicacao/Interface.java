package Aplicacao;

import Controller.mapaController;
import Controller.Utilitarios.*;
import Model.MapaModel;
import Model.NaviosModel;
import View.MapaView;
import View.NaviosView;


public class Interface extends Prints {
	
	String comando;
	Prints p =  new Prints();		
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();
	MapaView mv = new MapaView();
	NaviosView n = new NaviosView();

	/**
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception {
		n.imprimeNavios(true,p.comando("Nome do navio "));
		//mc.iniciaTabuleiro(false);
		//mc.imprimeView(true,"\n"+"TABULEIRO DO JOGO!"+"\n\n");
		//p.msgb("Cmi " +" " +m.getColuna() +" Lm " +m.getLinha());
		
		
		
		/*
		switch (comando("")) {
		
		case "?":	
			
			break;
				
		case "sair":
			sair();
			break;
			
		default: 
			iniciaTarefas();
			break;
		}*/
	}
}