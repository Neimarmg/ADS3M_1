package Aplicacao;

public class mainE1 {
	Formatos i = new Formatos();
	acoes f = new acoes();
	
	
	private void Cabecalho() {
		i.msg("====================================================\n"
		+"       EXERC�CIO DE ESTRUTURAS LINEARES E1!!! "
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
