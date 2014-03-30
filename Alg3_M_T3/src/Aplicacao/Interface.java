package Aplicacao;

import Controller.Utilitarios.*;


public class Interface extends Prints {
	
	String comando;


	/**
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception {

		switch (comando("")) {
		
		case "consultar":	
			
			break;
			
		case "inserir":

			break;
			
		case "imprimir":

			break;
			
		case "arquivo":

			break;
		
		case "sair":
			sair();
			break;
			
		default: 
			iniciaTarefas();
			break;
		}
	}
}