package Aplicacao;

import Utilitarios.Dia;
import Utilitarios.Formatos;

public class mainE1 {
	Formatos i = new Formatos();
	acoes f = new acoes();
	Dia d = new Dia();
	
	private void Cabecalho() {
		i.msg("====================================================\n"
		+"       EXERCÍCIO DE ESTRUTURAS LINEARES E1!!! "
		+"\n====================================================\n\n\n");
	}
	
	public void sauda() {
		d.horario();
	}
	
	
	/**
	* Metodo inicia a execução de todos os comandos da aplicação	
	*/
	public void ExecutaMenu() {		
		i.msgb("OQUE VOCÊ DESEJA FAZER?:\n\n"
		+"=> CADASTRA\n"
		+"=> CONSULTA\n"
		+"=> IMPRIME\n"
		+"=> SALVA\n"
		+"\t= NOVO\n"
		+"\t= EXISTENTE\n");
	}
	
	private void run() throws Exception {
		Cabecalho();
		sauda();
		ExecutaMenu();
		f.ExecutaComandos();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		new mainE1().run();
	}
}
