package Aplicacao;

import Controller.SoldadoController;
import Controller.mapaController;
import Controller.Utilitarios.*;
import Model.MapaModel;
import View.MapaView;

public class Interface extends Prints {
	
	String comando;
	MapaModel m = new MapaModel();
	mapaController mc = new mapaController();
	MapaView mv = new MapaView();
	SoldadoController sc = new SoldadoController();


	
		
	
	/**
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception {
		
		switch (comando("")) {
		
		case "jogar":	
			sc.dados(false);
			break;
			
		case "dedinir":	
			
			break;
				
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			iniciaTarefas();			
			break;
		}
	}
}