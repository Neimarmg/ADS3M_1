package V;


public class Menus extends View {
	public static void menuJogar() {		
		msgb("	COMANDOS DE JOGO:\n\n"
		+ "=> JOGAR        'Abilita o jogador � jogar'\n"
		+ "=> PERSONALIZAR 'Personaliza nivel inicial de jogo'\n"
		+ "=> SAIR         'Sai do programa'\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+ "=> INICIAR  'Iniciar mapa de jogo'            " + View.statusAcao(7,7) + "\n"
		+ "=> IMPRIMIR 'Imprimi op��es de jogo'          " + View.statusAcao(7,7) + "\n"
		+ "=> REGRAS   'Imprimi todas as regras do jogo' " + View.statusAcao(7,7) + "\n"
		+ "=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO:\n\n"
		+ "=> ATIRAR   'Abilita o jogador � inserir coordenadas'\n"
		+ "=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESS�O:\n\n"
		+ "=> MAPA    'Imprime mapa atual'\n"
		+ "=> NAVIOS  'Imprime navios existentes'\n"		
		+ "=> NIVEIS  'Imprime n�veis de jogo'\n"
		+ "=> SOLDADO 'Imprime dados do jogador'\n"
		+ "=> FILTRAR 'Filtra dados'\n"
		+ "=> TODOS   'Imprime todos os dados do jogo'\n"
		+ "=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESS�O:\n\n"
		+ "=> NAVIOS   'Op�ao de filtro'\n"		
		+ "=> NIVEIS   'Op�ao de filtro'\n"
		+ "=> RETORNAR 'Retorna ao menu imprimir'\n"
		+ "=> SAIR\n");
	}
}