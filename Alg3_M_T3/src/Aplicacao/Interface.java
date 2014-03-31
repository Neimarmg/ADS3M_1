package Aplicacao;

import Controller.mapaController;
import Controller.Utilitarios.*;
import Model.MapaModel;
import View.MapaView;


public class Interface extends Prints {
	
	String comando;
	Prints p =  new Prints();		
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();
	MapaView mv = new MapaView();


	/**
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception {
		
		mc.iniciaTabuleiro(false);
		mc.imprimeView(true,"\n"+"TABULEIRO DO JOGO!"+"\n\n");
	
		
		
		
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