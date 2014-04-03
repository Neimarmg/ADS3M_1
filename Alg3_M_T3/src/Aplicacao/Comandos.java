package Aplicacao;

import Controller.Batalha;
import Controller.Controlador;
import Controller.SoldadoController;
import Controller.ComandosController;
import Controller.TaticaInimiga;
import Controller.MapaController;
import Controller.Utilitarios.*;

public class Comandos extends Prints {
	
	//String comando;
	ComandosController ic =  new ComandosController();
	SoldadoController sc =  new SoldadoController();
	MapaController m = new MapaController();
	TaticaInimiga ti = new TaticaInimiga();
	Batalha j = new Batalha();
	
	
	
	public void batalha() throws Exception {
		menuBatalha();
		
		switch (comando("")) {
		
		case "atirar":
			j.atira();
			Prints.msg("Chances: " +Controlador.getChances() 
				+"\n Pontuação: " +Controlador.getAcertos());
			batalha();			
			break;
						
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			batalha();			
			break;
		}
	}
	
	
	/**
	 * @throws Exception
	 */
	public void iniciaJogo() throws Exception {
		menuJogar();
		
		switch (comando("")) {
		
		case "jogar":	
			ti.executaTatica();
			batalha();
			break;
		
		case "definir":	
			objetoNaoImplementado();
			break;
				
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			iniciaJogo();			
			break;
		}
	}
		
	/**
	 * 
	 * @throws Exception
	 */
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