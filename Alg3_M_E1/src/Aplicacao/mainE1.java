package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();
	acoes f = new acoes();
	Dia d = new Dia();
	
	private void escreveCabecalho() {
	    i.msgb("	EXERCÍCIO DE ESTRUTURAS LINEARES E1!!! ");
	}
	
	
	public void saudaUsuario() {
		d.horario();
	}
	

	public void mostarMenu() {		
		i.msgb("	OQUE VOCÊ DESEJA FAZER?:\n\n"
		+"=> INSERIR\n"
		+"=> CONSULTAR\n"
		+"=> IMPRIMIR\n"
		+"=> ARQUIVO\n"
		+"=> SAIR\n");
	}
	
	
	private void run() throws Exception {
		escreveCabecalho();
		saudaUsuario();
		mostarMenu();
		f.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();    
	}
}
