package Aplicacao;

import Estruturas.Ordenadores;
import Navegacao.Consultas;
import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE{
	Interface<Object> in = new Interface<Object>();
	Consultas consulta = new Consultas();
	Ordenadores ordenador = new Ordenadores();
	Dia d = new Dia();

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
		Prints.menuSelecinaAtividade();	
		switch (Prints.digita("Atividade")) {
		
		case "t1":	
			Prints.mostarMenuT1();
			in.iniciaTarefas();	
			selecionaAtividade();
			break;
			
		case "t2":			
			Prints.msgc("	CONSULTA BINÁRIA\n\n");
			consulta.buscaBinaria(
				Prints.digita("Nome do arquivo"), 
				Prints.digita("Parâmetro "));
			selecionaAtividade();
			break;
			
		case "t4":	
			ordenador.selecionaOrdenador();
			//selecionaAtividade();
			break;
			
		case "t5":
			Prints.msge("Aguarda atividade do professor!");
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
		d.defineSaudacao();		
		selecionaAtividade();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE().run();  	
	}
}