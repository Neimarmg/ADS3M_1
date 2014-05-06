
package Aplicacao;

import model.Ordenadores;
import Controller.interacao;
import Controller.Navegacao.Consultas;
import model.Arvore.ArvoreBinaria;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Dia;

/**
 * Classe principal de execução do programa
 * @author Neimar
 */
public class App{

	Consultas consulta = new Consultas();
	Ordenadores ordenador = new Ordenadores();

	/**
	 * Descrição do cabeçalho principal
	 */
	private void escreveCabecalho() {
		Prints.msgb("\n" +"	EXERCÍCIO DE ESTRUTURAS JAVA\n");
	}
	
	/**
	 *	Método com definição das atividades solicitadas
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
			Prints.msgc("	CONSULTA BINÁRIA\n\n");
			consulta.buscaBinaria(
					Auxiliar.digita("Nome do arquivo"), 
					Auxiliar.digita("Parâmetro "));
			selecionaAtividade();
			break;
			
		case "t4":	
			ordenador.selecionaOrdenador();			
			break;
			
		case "t5":
			Prints.msge("\nAguarda implementação!");
			
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