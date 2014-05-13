package View;

import Model.Utilitarios.Prints;

public class Menus extends Prints{
	public static void menuJogar()  {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+ "=> JOGAR        'Abilita o jogador a jogar'\n"
		+ "=> PERSONALIZAR 'Personaliza nivel inicial de jogo'\n"
		+ "=> SAIR         'Sai o programa'\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+ "=> INICIAR  'Iniciar mapa de jogo'            "+Prints.statusAcao(7,7) +"\n"
		+ "=> IMPRIMIR 'Imprimi opções de jogo'          "+Prints.statusAcao(7,7) +"\n"
		+ "=> REGRAS   'Imprimi todas as regras do jogo' "+Prints.statusAcao(7,7) +"\n"
		+ "=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO?\n\n"
		+ "=> ATIRAR   'Abilita o jogador a inserir cordenadas'\n"
		+ "=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESSÃO?\n\n"
		+ "=> MAPA    'Imprime mapa atual'\n"
		+ "=> NAVIOS  'Imprime navios existentes'\n"		
		+ "=> NIVEIS  'Imprime niveis de jogo'\n"
		+ "=> SOLDADO 'Imprime dodos do jogador'\n"
		+ "=> FILTRAR 'Filtra dados'\n"
		+ "=> TODOS   'Imprime todos os dados de jogo'\n"
		+ "=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESSÃO?\n\n"
		+ "=> NAVIOS   'Opçao de filtro'\n"		
		+ "=> NIVEIS   'Opçao de filtro'\n"
		+ "=> RETORNAR 'Retorna ao menu imprimir'\n"
		+ "=> SAIR\n");
	}
}
