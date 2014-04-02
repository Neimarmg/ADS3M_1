package Aplicacao;

import Controller.SoldadoController;
import Controller.ComandosController;
import Controller.TaticaInimigo;
import Controller.mapaController;
import Controller.Utilitarios.*;

public class Comandos extends Prints {
	
	//String comando;
	ComandosController ic =  new ComandosController();
	SoldadoController sc =  new SoldadoController();
	mapaController m = new mapaController();
	TaticaInimigo ti = new TaticaInimigo();
	
	/**
	 * @throws Exception
	 */
	public void iniciaJogo() throws Exception {
		menuJogar();
		switch (comando("")) {
		
		case "jogar":	
			ti.processaInvel();
			break;
			
		case "definir":	
			objetoNaoImplementado();
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
		
	public void iniciaTarefas() throws Exception {
		switch (comando("")) {
		
		case "iniciar":	
			ic.executaMapaInicial();
			iniciaJogo();
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