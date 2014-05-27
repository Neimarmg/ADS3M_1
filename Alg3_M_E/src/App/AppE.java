package App;

import java.util.InputMismatchException;

import C.interacao;
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
		View.msgb("\n" +"	EXERC�CIO DE ESTRUTURAS JAVA\n");
	}
	
	
	/**
	 * Carrega op��es de intera��o com o programa
	 * @throws Exception
	 */
	private void iniciaInteracao() throws Exception {
		Menus.mostarMenuApp();				
		interacao.iniciaTarefas();
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
				iniciaInteracao();
				break;
				
			case "t2":				
				Auxiliar.setOpcao("BINARIA");
				iniciaInteracao();
				break;
				
			case "t4":	
				Auxiliar.setOpcao("ORDENADORES");
				iniciaInteracao();	
				break;
				
			case "t5":
				Auxiliar.setOpcao("ARVORE"); // Arvore deve ficar sem acentua��o pois, se trata de atribu��o
				iniciaInteracao();				
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
			View.msge("Comando n�o suportado em JavaSE igual ou inferior 6.1 ");
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