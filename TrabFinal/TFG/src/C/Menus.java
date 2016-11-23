package C;

import V.View;
/**
 * Classe de implementação de menus de todo o sistema
 * @author Neimar
 */
public class Menus extends View {
	private static String menu = "";	
	private static String filtro;
	

	/**
	 * Método de criação configuração de cabeçalhos do menus
	 * @param cabeçalho
	 * @param padrao
	 * @return
	 */
	public static String getCabeçalho(String cabeçalho, boolean padrao) {
		if (padrao == true ){
			return "|O QUE VC DESEJA FAZER\n";
		}else{
			return "|" +cabeçalho +"\n";
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
		setMenu("|=> INICIAR        |Iniciar a execução do programa\n" +
				"|=> INFO           |Formece informaçãoes sobre o projeto\n" + 
				"|=> T              |Comando de testes em objetos durante a implementação\n"
		);
		
		imprimeMemu(getCabeçalho("INICIALIZAR ATIVIDADES", false), getMenu());
		setMenu("");  // Limpa variável para exibição do próximo menu
	}


	/**
	 * Memu geral de interação do program e usuário
	 */
	public static void menuInteracao() {	
		setMenu("|=> DADOS          |Edita e imprime novas rotas em arquivo txt \n" +
				"|=> ROTAS          |Formece informaçãoes sobre o projeto \n" +
				"|=> MAPA           |imprime mapa \n"
		);
		
		imprimeMemu(getCabeçalho(null, true),getMenu());
		setMenu("");  // Limpa variável para exibição do próximo menu
	} 

	
	/**
	 * Método responsável pele exibição dos menus de "include"
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
		
		imprimeMemu(getCabeçalho("OPÇÕES DE INCLUDE", false), getMenu());
		setMenu("");  // Limpa variável para exibição do próximo menu
	}

	
	/**
	 * Menu para consultas a dados de projeto
	 */
	public static void menuInfo() {	
		setMenu("|=> G              |Exibe glossários do projeto\n" +
				"|=> P              |Exibe informações do projeto\n"
		);
		
		imprimeMemu(getCabeçalho(null, true), getMenu());
		setMenu("");  // Limpa variável para exibição do próximo menu
	}
}