package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();
	Interface<Object> in = new Interface<Object>();
	Dia d = new Dia();
	
	private void escreveCabecalho() {
	    i.msgb("	EXERC�CIO DE ESTRUTURAS LINEARES E1!!! ");
	}
	
	
	public void saudaUsuario() {
		d.horario();
	}
	

	public void mostarMenu() {		
		i.msgb("	OQUE VOC� DESEJA FAZER?:\n\n"
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
		in.iniciaTarefas();
	}
	

	public static void main(String[] args)throws Exception {
		new mainE1().run();    
	}
}
