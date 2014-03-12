package Aplicacao;

public class mainE1 {
	Impressao i = new Impressao();
	Recursos f = new Recursos();
	
	
	private void Cabecalho() {
		i.printMsg("====================================================\n"
		+"       EXERCÍCIO DE ESTRUTURAS LINEARES E1!!! "
		+"\n====================================================\n\n\n");
	}
	
	
	private void run() {
		Cabecalho();
		f.ExecutaComandos();
	}
	
	
	public static void main(String[] args) {
		new mainE1().run();
	}
}
