package App;

import java.util.InputMismatchException;

import C.Interacao;
import M.Ordenadores;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Dia;

/**
 * Classe principal de execu��o do programa
 * @author Neimar, Aur�lio
 */
public class AppE {
	Ordenadores ordenador = new Ordenadores();


	/**
	 * Descri��o do cabe�alho principal
	 */
	private void escreveCabecalho() {
		View.msgb("\n" + "		     EXERC�CIO DE ESTRUTURAS JAVA\n");
	}


	/**
	 * Carrega op��es de intera��o com o programa
	 * @throws Exception
	 */
	private void iniciaInteracao() throws Exception {
		Menus.mostarMenuApp();				
		Interacao.iniciaTarefas();
	}


	/**
	 *	M�todo com defini��o das atividades solicitadas
	 * @throws Exception
	 */
	private void selecionaAtividade() throws Exception {

		try {		
			Menus.menuSelecinaAtividade();	
			switch (Auxiliar.digita("Atividade")) {

			case "t1":
				Auxiliar.setOpcao("LISTA");
				Menus.setOpcMenu(Auxiliar.getOpcao());
				iniciaInteracao();
				break;

			case "t2":				
				Auxiliar.setOpcao("BINARIA");
				Menus.setOpcMenu(Auxiliar.getOpcao());
				Auxiliar.setAbilita(true); //Desbilita edi��o manual de mennus
				Menus.setFiltro("todos"); //Paramento de filtro pr�-definido
				iniciaInteracao();
				break;

			case "t4":
				Auxiliar.setOpcao("ORDENADORES");
				Menus.setOpcMenu(Auxiliar.getOpcao());
				iniciaInteracao();	
				break;

			case "t5":
				Auxiliar.setOpcao("ARVORE"); // �rvore deve ficar sem acentua��o, pois se trata de atribui��o
				Menus.setOpcMenu(Auxiliar.getOpcao());
				Auxiliar.setDetalhes("ab");
				iniciaInteracao();				
				break;

			case "t6":
				Auxiliar.setOpcao("ARVORE"); // �rvore deve ficar sem acentua��o, pois se trata de atribui��o			
				Menus.setOpcMenu(Auxiliar.getOpcao());
				Menus.menuArvores(true, false, true);
				iniciaInteracao();				
				break;

			case "g":
				Menus.glossario();				
				break;

			case "sair":
				View.sair();
				break;

			default: 
				View.opcaoInvalida();
				selecionaAtividade();
				break;
			}

		} catch (ClassNotFoundException e) {
			View.msge("Comando n�o suportado em JavaSE igual ou inferior a 6.1 ");
		} catch (InputMismatchException e) {
			View.msge("\nValor(es) digitado(s) inv�lido(s)!");
		}
	}


	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		Dia.defineSaudacao();		
		selecionaAtividade();		
	}


	public static void main(String[] args)throws Exception {
		new AppE().run();
	}
}