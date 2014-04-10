package Aplicacao;

import Controller.Batalha;
import Controller.Inimigo;
import Controller.InterfaceCont;
import Controller.Estrategia;
import Controller.MapaCont;
import Controller.SoldadoCont;
import Model.MapaMod;
import View.MapaView;
import View.Utilitarios.*;

/**
 * Classe de execu��o do programa com intera��o com o usu�rio
 * @author Neimar, Aur�lio
 */
public class Interface extends Prints {
	
	//String comando;
	InterfaceCont interfaceCont =  new InterfaceCont();
	Estrategia estrategia = new Estrategia();
	Batalha batalha = new Batalha();
	MapaMod mapaMod = new MapaMod();
	MapaView mapaView = new MapaView();
	SoldadoCont soldado = new SoldadoCont();
	
	/**
	 * M�todo de filtragem de dados
	 * @throws Exception
	 */
	public void filtra() throws Exception {
		menuFiltrar();
		
		switch (digita("")) {
		
		case "navios":
			interfaceCont.consultaNavios(true,false);
			filtra();
			break;
		
		case "niveis":
			interfaceCont.consultaNiveis(true);
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
	 * M�todo geral de impress�o
	 * @throws Exception
	 */
	public void imprime() throws Exception {
		Prints.menuImprimir();
		
		switch (digita("")) {
		
		case "mapaMod":
			batalha.iniciaMapa();
			imprime();
			break;

		case "navios":
			interfaceCont.consultaNavios(false,true);
			imprime();
			break;
			
		case "niveis":
			interfaceCont.consultaNiveis(false);
			imprime();
			break;
			
		case "soldado":
			interfaceCont.consultaSoldado();
			imprime();
			break;		
			
		case "filtrar":
			filtra();
			break;
			
		case "todos":
			interfaceCont.listaConsultas();
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
	 * M�todo de batalha 
	 * @throws Exception
	 */
	public void batalha() throws Exception {
		menuBatalha();
		
		switch (digita("")) {
		
		case "atirar":
			batalha.atira();		
			if (Inimigo.getChances() >0) {	
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
	 * M�todo que executa jogo
	 * @throws Exception
	 */
	public void Joga() throws Exception {
		menuJogar();
		
		switch (digita("")) {
		
		case "jogar":	
			estrategia.tatica();
			batalha();
			break;
		
		case "personalizar":	
			soldado.editaDados();
			MapaCont.iniciaMapa();
			mapaView.imprime(true, "\nMAPA PERSONALIZADO! \n");
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
	 * M�todo de incializa��o da execu��o do programa
	 * @throws Exception
	 */
	public void inicia() throws Exception {
		
		switch (digita("")) {
		
		case "iniciar":	
			batalha.iniciaMapa();
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