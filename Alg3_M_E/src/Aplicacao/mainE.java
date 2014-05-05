package Aplicacao;

import Estruturas.Ordenadores;
import Navegacao.Consultas;
import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE{
	Consultas consulta = new Consultas();
	Ordenadores ordenador = new Ordenadores();
	Dia d = new Dia();

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
		switch (Prints.digita("Atividade")) {
		
		case "t1":	
			Menus.mostarMenuT1();			
			Interface.iniciaTarefas();	
			break;
			
		case "t2":			
			Prints.msgc("	CONSULTA BIN�RIA\n\n");
			consulta.buscaBinaria(
				Prints.digita("Nome do arquivo"), 
				Prints.digita("Par�metro "));
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
		d.defineSaudacao();		
		selecionaAtividade();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE().run();  	
	}
}