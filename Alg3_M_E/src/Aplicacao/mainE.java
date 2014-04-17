package Aplicacao;

import Navegacao.Consultas;
import Utilitarios.Dia;
import Utilitarios.Prints;

public class mainE{
	Interface<Object> in = new Interface<Object>();
	Consultas consulta = new Consultas();
	Dia d = new Dia();

	/**
	 * Descri��o do cabe�alho principal do programa
	 */
	private void escreveCabecalho() {
		Prints.msgb("\n" +"	EXERC�CIO DE ESTRUTURAS JAVA\n");
	}
	
	/**
	 *	M�todo de inicial do programa com defini��o das atividades solicitadas
	 * @throws Exception
	 */
	private void selecionaAtividade() throws Exception {
		Prints.menuSelecinaAtividade();	
		switch (Prints.digita("Atividade")) {
		
		case "t1":	
			Prints.mostarMenuT1();
			in.iniciaTarefas();	
			break;
			
		case "t2":			
			Prints.msgc("	CONSULTA BIN�RIA\n\n");
			consulta.buscaBinaria(
				Prints.digita("Nome do arquivo"), 
				Prints.digita("Par�metro "));
			break;
			
		case "t4":

			break;
			
		case "arquivo":
			
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