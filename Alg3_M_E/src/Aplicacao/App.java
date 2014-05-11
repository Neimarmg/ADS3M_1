package Aplicacao;

import model.Ordenadores;
import Controller.interacao;
import Controller.Navegacao.Consultas;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Dia;

/**
 * Classe principal de execução do programa
 * @author Neimar, Aurélio
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
	
		try {		
			Menus.menuSelecinaAtividade();	
			switch (Auxiliar.digita("Atividade")) {
			
			case "t1":	
				Auxiliar.setOpcao("LISTA");
				Menus.mostarMenuApp();				
				interacao.iniciaTarefas();	
				break;
				
			case "t2":			
				Prints.msgc("	CONSULTA BINÁRIA\n");
				consulta.carregaBuscaBinaria(Auxiliar.digita("Nome do arquivo"), Auxiliar.digitaNumero("Nome a ser localizado"));
				break;
				
			case "t4":	
				ordenador.selecionaOrdenador();			
				break;
				
			case "t5":
				Auxiliar.setOpcao("ARVORE");
				Menus.mostarMenuApp();
				interacao.iniciaTarefas();
				//Registrador.executaComando("l.txt");
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
			
		} catch (ClassNotFoundException e) {
			Prints.msge("Comando não suportada em JavaSE igual ou inferior 6.1 ");
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