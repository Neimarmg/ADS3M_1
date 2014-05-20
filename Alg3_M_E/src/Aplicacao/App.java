package Aplicacao;

import java.util.InputMismatchException;
import model.Ordenadores;
import Controller.interacao;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Dia;

/**
 * Classe principal de execução do programa
 * @author Neimar, Aurélio
 */
public class App {
	Ordenadores ordenador = new Ordenadores();
	
	
	/**
	 * Descrição do cabeçalho principal
	 */
	private void escreveCabecalho() {
		Prints.msgb("\n" +"	EXERCÍCIO DE ESTRUTURAS JAVA\n");
	}
	
	
	/**
	 * Carrega opções de interação com o programa
	 * @throws Exception
	 */
	private void iniciaInteracao() throws Exception {
		Menus.mostarMenuApp();				
		interacao.iniciaTarefas();
	}
	
	
	/**
	 *	Método com definição das atividades solicitadas
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
				Auxiliar.setOpcao("ARVORE"); // Arvore deve ficar sem acentuação pois, se trata de atribução
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
			Prints.msge("Comando não suportado em JavaSE igual ou inferior 6.1 ");
		} catch (InputMismatchException e) {
			Prints.msge("\nValor(es) digitado(s) inválido(s)!");
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