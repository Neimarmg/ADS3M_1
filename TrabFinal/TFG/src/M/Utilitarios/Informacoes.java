package M.Utilitarios;

import C.Menus;
import V.View;

/**
 * Classe impressão de informação do projeto
 * @author Neimar, Aurelio
 */
public class Informacoes {

	public static void atividades(){
		String grupo =" Aurério, Mario, Fabrizio, Neimar";
		View.msgb(
			    "|ATIVIDADE EM GRUPO\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|\n|Membros do grupo: " +grupo +"\n|\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|Descrição      |Nome            |Status\n"
			  + "|---------------|----------------|-------------------------------------\n"
			  + "|Plenejamento   |Grupo           |" + Auxiliar.statusAcao(-2, 0, 85, true) + "\n"
			  + "|Desenvolvimento|Mario, Neimar   |" + Auxiliar.statusAcao(-2, 0, 65, true) + "\n"
		      + "|Teste          |Fabrizio,Aurélio|" + Auxiliar.statusAcao(-2, 0, 35, true) + "\n"
			  + "|Documentação   |Aurélio         |" + Auxiliar.statusAcao(-2, 0, 90, true) + "\n"
			);
	
	}
	
	
	/**
	 * Glossário do projeto
	 */
	private static void imprimeGlossario(){
		View.msgb(
			    "|GLOSSÁRIO DO PROGRAMA:\n"
			  + "|----------------------------------------------------------------------\n"
			  + "|Vocábulo  |Significádo\n"
			  + "|----------|-----------------------------------------------------------\n"
			  + "|C         |Controller\n"
			  + "|M         |Model\n"
		      + "|V         |View\n"
			  + "|App       |Aplicação\n"
			  + "|T         |Comando de execução de testes em um bloco específico\n"
			);
	}
		
	
	/**
	 * Imprime informações
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