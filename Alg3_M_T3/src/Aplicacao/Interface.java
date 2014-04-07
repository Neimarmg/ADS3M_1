package Aplicacao;

import Controller.Batalha;
import Controller.Inimigo;
import Controller.InterfaceCont;
import Controller.Estrategia;
import Controller.Utilitarios.*;
import Model.MapaMod;
import View.MapaView;

public class Interface extends Prints {
	
	//String comando;
	InterfaceCont ic =  new InterfaceCont();
	Estrategia ti = new Estrategia();
	Batalha j = new Batalha();
	MapaMod mapa = new MapaMod();
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
			j.executaMapaInicial();
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
			impressao();
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
			if (Inimigo.getChances()>0) {	
				batalha();
			}
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
			ti.tatica();
			batalha();
			break;
		
		case "definir":	
			objetoNaoImplementado();
			iniciaJogo();
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
			j.executaMapaInicial();
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