
package Aplicacao;

import model.Ordenadores;
import Controller.interacao;
import Controller.Navegacao.Consultas;
import model.Arvore.ArvoreBinaria;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Dia;

/**
 * Classe principal de execu��o do programa
 * @author Neimar
 */
public class App{

	Consultas consulta = new Consultas();
	Ordenadores ordenador = new Ordenadores();

	/**
	 * Descri��o do cabe�alho principal
	 */
	private void escreveCabecalho() {
		Prints.msgb("\n" +"	EXERC�CIO DE ESTRUTURAS JAVA\n");
	}
	
	/**
	 *	M�todo com defini��o das atividades solicitadas
	 * @throws Exception
	 */
	private void selecionaAtividade() throws Exception {
		Menus.menuSelecinaAtividade();	
		switch (Auxiliar.digita("Atividade")) {
		
		case "t1":	
			Menus.mostarMenuT1();			
			interacao.iniciaTarefas();	
			break;
			
		case "t2":			
			Prints.msgc("	CONSULTA BIN�RIA\n\n");
			consulta.buscaBinaria(
					Auxiliar.digita("Nome do arquivo"), 
					Auxiliar.digita("Par�metro "));
			selecionaAtividade();
			break;
			
		case "t4":	
			ordenador.selecionaOrdenador();			
			break;
			
		case "t5":
			Prints.msge("\nAguarda implementa��o!");
			
			selecionaAtividade();
			break;
		
		case "sair":
			Prints.sair();
			break;
			
		default: 
			Prints.opcaoInvalida();
			selecionaAtividade();
			break;
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
		ArvoreBinaria.executa();
	}
}