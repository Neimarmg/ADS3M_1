package Aplicacao;

import java.util.InputMismatchException;
import model.Ordenadores;
import Controller.interacao;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Dia;

/**
 * Classe principal de execu��o do programa
 * @author Neimar, Aur�lio
 */
public class App {
	Ordenadores ordenador = new Ordenadores();
	
	
	/**
	 * Descri��o do cabe�alho principal
	 */
	private void escreveCabecalho() {
		Prints.msgb("\n" +"	EXERC�CIO DE ESTRUTURAS JAVA\n");
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
				Prints.sair();
				break;
				
			default: 
				Prints.opcaoInvalida();
				selecionaAtividade();
				break;
			}
			
		} catch (ClassNotFoundException e) {
			Prints.msge("Comando n�o suportado em JavaSE igual ou inferior 6.1 ");
		} catch (InputMismatchException e) {
			Prints.msge("\nValor(es) digitado(s) inv�lido(s)!");
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
		new App().run(); 
	}
}