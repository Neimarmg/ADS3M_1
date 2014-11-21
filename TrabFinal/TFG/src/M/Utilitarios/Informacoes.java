package M.Utilitarios;

import C.Menus;
import V.View;

/**
 * Classe impress�o de informa��o do projeto
 * @author Neimar, Aurelio
 */
public class Informacoes {

	public static void atividades(){
		String grupo =" Aur�rio, Mario, Fabrizio, Neimar";
		View.msgb(
			    "|ATIVIDADE EM GRUPO\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|\n|Membros do grupo: " +grupo +"\n|\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|Descri��o      |Nome            |Status\n"
			  + "|---------------|----------------|-------------------------------------\n"
			  + "|Plenejamento   |Grupo           |" + Auxiliar.statusAcao(-2, 0, 85, true) + "\n"
			  + "|Desenvolvimento|Mario, Neimar   |" + Auxiliar.statusAcao(-2, 0, 65, true) + "\n"
		      + "|Teste          |Fabrizio,Aur�lio|" + Auxiliar.statusAcao(-2, 0, 35, true) + "\n"
			  + "|Documenta��o   |Aur�lio         |" + Auxiliar.statusAcao(-2, 0, 90, true) + "\n"
			);
	
	}
	
	
	/**
	 * Gloss�rio do projeto
	 */
	private static void imprimeGlossario(){
		View.msgb(
			    "|GLOSS�RIO DO PROGRAMA:\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|Voc�bulo  |Signific�do\n"
			  + "|----------|-----------------------------------------------------------\n"
			  + "|C         |Controller\n"
			  + "|M         |Model\n"
		      + "|V         |View\n"
			  + "|App       |Aplica��o\n"
			  + "|T         |Comando de execu��o de testes em um bloco espec�fico\n"
			);
	}
		
	
	/**
	 * Imprime informa��es
	 */
	public static void selecionaInfo() {
		Menus.menuInfo();
		
		switch (Auxiliar.digita("")) {
		
		case "g":
			imprimeGlossario();
			selecionaInfo();
			break;

		case "p":
			atividades();
			selecionaInfo();
			break;
			
		case "sair":
			View.sair();
			selecionaInfo();
			break;
			
		default:
			View.opcaoInvalida();
			selecionaInfo();
			break;
		}
	}
		
}