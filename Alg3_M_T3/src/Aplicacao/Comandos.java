package Aplicacao;

import Controller.Batalha;
import Controller.Controlador;
import Controller.ComandosController;
import Controller.TaticaInimiga;
import Controller.Utilitarios.*;
import Model.MapaModel;
import View.MapaView;

public class Comandos extends Prints {
	
	//String comando;
	ComandosController ic =  new ComandosController();
	TaticaInimiga ti = new TaticaInimiga();
	Batalha j = new Batalha();
	MapaModel mapa = new MapaModel();
	MapaView mv = new MapaView();
	
	/**
	 * Método de filtragem de dados
	 * @throws Exception
	 */
	public void filtra() throws Exception {
		menuFiltrar();;
		
		switch (comando("")) {
		
		case "navios":
			ic.consultaNavios(true,false);
			filtra();
			break;
		
		case "niveis":
			ic.consultaNiveis(true);
			filtra();
			break;
		
		case "retornar":
			impressao();
			break;
		case "sair":
			
			sair();
			break;
			
		default: 
			opcaoInvalida();
			filtra();			
			break;
		}
	}
	
	/**
	 * Método de geral de impressão
	 * @throws Exception
	 */
	public void impressao() throws Exception {
		Prints.menuImprimir();
		
		switch (comando("")) {
		
		case "mapa":
			mapa.criaMapa();
			mv.imprime(true, "\nMAPA DO JOGO ");
			impressao();
			break;

		case "navios":
			ic.consultaNavios(false,true);
			impressao();
			break;
			
		case "niveis":
			ic.consultaNiveis(false);
			impressao();
			break;
			
		case "soldado":
			ic.consultaSoldado();
			filtra();
			break;		
			
		case "filtrar":
			filtra();
			break;
			
		case "todos":
			ic.abreInfocoes();
			impressao();
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
	
	/**
	 * Método de batalha 
	 * @throws Exception
	 */
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
	 * Método de inicia e executa jogo
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