package C;

import V.View;
/**
 * Classe de implementa��o de menus de todo o sistema
 * @author Neimar
 */
public class Menus extends View {
	private static String menu = "";	
	private static String filtro;
	

	/**
	 * M�todo de cria��o configura��o de cabe�alhos do menus
	 * @param cabe�alho
	 * @param padrao
	 * @return
	 */
	public static String getCabe�alho(String cabe�alho, boolean padrao) {
		if (padrao == true ){
			return "|O QUE VC DESEJA FAZER\n";
		}else{
			return "|" +cabe�alho +"\n";
		}
	}


	public static void setMenu(String menu) {
		if (menu.equals("")){
			Menus.menu = ""; //limpeza de menu
		}else{
			Menus.menu += menu;
		}			
	}
	
	
	public static String getMenu() {
		return menu;
	}

	 
	public static void setFiltro(String filtro) {
		Menus.filtro = filtro;
	}
	
	
	public static String getFiltro() {
		return filtro;
	}
	
	/**
	 * Menu inicia app
	 */
	public static void menuMaim() {	
		setMenu("|=> INICIAR        |Iniciar a execu��o do programa\n" +
				"|=> INFO           |Formece informa��oes sobre o projeto\n" + 
				"|=> T              |Comando de testes em objetos durante a implementa��o\n"
		);
		
		imprimeMemu(getCabe�alho("INICIALIZAR ATIVIDADES", false), getMenu());
		setMenu("");  // Limpa vari�vel para exibi��o do pr�ximo menu
	}


	/**
	 * Memu geral de intera��o do program e usu�rio
	 */
	public static void menuInteracao() {	
		setMenu("|=> DADOS          |Edita e imprime novas rotas em arquivo txt \n" +
				"|=> ROTAS          |Formece informa��oes sobre o projeto \n" +
				"|=> MAPA           |imprime mapa \n"
		);
		
		imprimeMemu(getCabe�alho(null, true),getMenu());
		setMenu("");  // Limpa vari�vel para exibi��o do pr�ximo menu
	} 

	
	/**
	 * M�todo respons�vel pele exibi��o dos menus de "include"
	 * @throws Exception
	 */
	public static void menuInclude(String include)throws Exception {
		setMenu(
					"|=> NOVO           |Habilita para gravar novo registro\n"+
					"|=> REMOVER        |Remove dado coincidente no arquivo\n");
		
		switch (include) {

		case "ARQUIVO":
			setMenu("|=> BUSCAR         |Busca dados existentes\n" +
					"|=> IMPRIMIR       |Imprime dados\n");
			break;

		case "DADOS":
			setMenu("|=> EDITAR         |Edita dados do arquivo\n");
			break;
		}
		
		imprimeMemu(getCabe�alho("OP��ES DE INCLUDE", false), getMenu());
		setMenu("");  // Limpa vari�vel para exibi��o do pr�ximo menu
	}

	
	/**
	 * Menu para consultas a dados de projeto
	 */
	public static void menuInfo() {	
		setMenu("|=> G              |Exibe gloss�rios do projeto\n" +
				"|=> P              |Exibe informa��es do projeto\n"
		);
		
		imprimeMemu(getCabe�alho(null, true), getMenu());
		setMenu("");  // Limpa vari�vel para exibi��o do pr�ximo menu
	}
}