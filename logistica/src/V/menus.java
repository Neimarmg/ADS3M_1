package V;

public class menus {
	private static String estruturaMenu = "";
	
	public static void cabecalhoMenu(String cabecalho, Boolean inicializarMenu) {
		if(inicializarMenu == true){
			estruturaMenu = "";
		}
		menus.estruturaMenu = "|" +cabecalho +"\n"
				  + "|----------------------------------------------------------------------\n"
				  + "|Comando      |Descrição\n"
				  + "|-------------|--------------------------------------------------------\n";
	}

	public static void menuInicial(){
		cabecalhoMenu("COMANDOS DE EXECUÇÃO", true);
		estruturaMenu += "|=> CADASTRAR |Cadastra dodos\n"
			  + "|=> CALCULAR  |Executa calculos\n"
			  + "|=> IMPRIMIR  |Imprime cadastro\n"
			  + "|=> sair";
		View.msgb(estruturaMenu);
	}

	
	public static void ImprimeDados(){
		cabecalhoMenu("IMPRESSÃO DE DADOS", true);
		estruturaMenu += "|=> VEICULO |DADOS CADASTRO DE VEÍCULO\n"
				  + "|=> ROTA  |Imprime rotas\n"
				  + "|=> TUDO  |Imprime veículo e rotas\n"
				  + "|=> sair";
			View.msgb(estruturaMenu);
		
	}	
}
