package Aplicacao;

import Controller.Batalha;
import Controller.Controlador;
import Controller.SoldadoController;
import Controller.ComandosController;
import Controller.TaticaInimiga;
import Controller.MapaController;
import Controller.Utilitarios.*;
import Model.MapaModel;
import View.MapaView;
import View.NaviosView;
import View.NiveisView;

public class Comandos extends Prints {
	
	//String comando;
	ComandosController ic =  new ComandosController();
	SoldadoController sc =  new SoldadoController();
	MapaController m = new MapaController();
	TaticaInimiga ti = new TaticaInimiga();
	Batalha j = new Batalha();
	MapaModel mapa = new MapaModel();
	MapaView mv = new MapaView();
	
	
	public void impressao() throws Exception {
		Prints.menuImprimir();
		
		switch (comando("")) {
		
		case "mapa":
			mapa.criaMapa();
			mv.imprime(true, "	Mapa do jogo\n");
			impressao();
			break;

		case "navios":
			NaviosView navio = new NaviosView();
			navio.imprime(false);
			impressao();
			break;
			
		case "niveis":
			NiveisView nivel = new NiveisView();
			nivel.imprime(false, true);
			impressao();
			break;
			
		case "filtrar":
			Prints.objetoNaoImplementado();
			break;
			
		case "todos":
			ic.imprimirInfocoes();
			break;
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			impressao();			
			break;
		}
	}
	
	
	public void batalha() throws Exception {
		menuBatalha();
		
		switch (comando("")) {
		
		case "atirar":
			j.atira();
			Prints.msg("Chances: " +Controlador.getChances() 
				+"\nPontuação: " +Controlador.getAcertos());
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
		
		case "imprimir":
			impressao();
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