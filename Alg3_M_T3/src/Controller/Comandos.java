package Controller;

import Model.MapaMod;
import View.Menus;
import View.Prints;

/**
 * Classe de execu��o do programa com intera��o com o usu�rio
 * @author Neimar, Aur�lio
 */
public class Comandos extends Prints {
	
	// String comando;
	Consultas consulta =  new Consultas();
	Estrategia estrategia = new Estrategia();
	Batalha batalha = new Batalha();
	MapaMod mapaMod = new MapaMod();
	PrintMapa printMapa = new PrintMapa();
	SoldadoCont soldado = new SoldadoCont();
	
	/**
	 * M�todo de filtragem de dados
	 * @throws Exception
	 */
	public void filtra() throws Exception {
		Menus.menuFiltrar();
		
		switch (digita("")) {
		
		case "navios":
			consulta.consultaNavios(true,false);
			filtra();
			break;
		
		case "n�veis":
			consulta.consultaNiveis(true);
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
		Menus.menuImprimir();
		
		switch (digita("")) {
		
		case "mapa":
			batalha.iniciaMapa();
			imprime();
			break;

		case "navios":
			consulta.consultaNavios(false,true);
			imprime();
			break;
			
		case "niveis":
			consulta.consultaNiveis(false);
			imprime();
			break;
			
		case "soldado":
			consulta.consultaSoldado();
			imprime();
			break;		
			
		case "filtrar":
			filtra();
			break;
			
		case "todos":
			consulta.listaConsultas();
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
		Menus.menuBatalha();
		
		switch (digita("")) {
		
		case "atirar":
			batalha.atira();		
			if (Inimigo.getChances() > 0) {	
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
		Menus.menuJogar();
		
		switch (digita("")) {
		
		case "jogar":	
			estrategia.tatica();
			batalha();
			break;
		
		case "personalizar":	
			soldado.editaDados();
			MapaCont.iniciaMapa();
			printMapa.imprime(true, "\nMAPA PERSONALIZADO! \n");
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
		
		case "regras":
			printMapa.imprimeRegras();
			Menus.menuMain();
			inicia();
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