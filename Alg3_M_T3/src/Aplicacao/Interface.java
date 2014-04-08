package Aplicacao;

import Controller.Batalha;
import Controller.Inimigo;
import Controller.InterfaceCont;
import Controller.Estrategia;
import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.*;

/**
 * Classe de execução do progra com interação com o usuário
 * @author Neimar
 */
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
		menuFiltrar();
		
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
			imprime();
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
	public void imprime() throws Exception {
		Prints.menuImprimir();
		
		switch (comando("")) {
		
		case "mapa":
			j.iniciaMapa();
			imprime();
			break;

		case "navios":
			ic.consultaNavios(false,true);
			imprime();
			break;
			
		case "niveis":
			ic.consultaNiveis(false);
			imprime();
			break;
			
		case "soldado":
			ic.consultaSoldado();
			imprime();
			break;		
			
		case "filtrar":
			filtra();
			break;
			
		case "todos":
			ic.listaConsultas();
			imprime();
			break;
			
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			imprime();			
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
	public void Joga() throws Exception {
		menuJogar();
		
		switch (comando("")) {
		
		case "jogar":	
			ti.tatica();
			batalha();
			break;
		
		case "definir":	
			objetoNaoImplementado();
			Joga();
			break;
				
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			Joga();			
			break;
		}
	}
		
	/**
	 * Método de incialização da execução do programa
	 * @throws Exception
	 */
	public void inicia() throws Exception {
		
		switch (comando("")) {
		
		case "iniciar":	
			j.iniciaMapa();
			Joga();
			break;
		
		case "imprimir":
			imprime();
			break;
			
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			inicia();			
			break;
		}
	}
}