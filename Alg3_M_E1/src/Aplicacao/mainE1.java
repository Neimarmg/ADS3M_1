package Aplicacao;

public class mainE1 {
	Formatos i = new Formatos();
	acoes f = new acoes();
	
	
	private void Cabecalho() {
		i.msg("====================================================\n"
		+"       EXERCÍCIO DE ESTRUTURAS LINEARES E1!!! "
		+"\n====================================================\n\n\n");
	}
	
	
	private void run() {
		Cabecalho();
		f.ExecutaMenu();
		f.ExecutaComandos();
	}
	
	
	public static void main(String[] args) {
		new mainE1().run();
	}
}
