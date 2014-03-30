package Controller.Utilitarios;

public class Pressagios {
	String sauda;	
	
	Prints m = new Prints(); 
	
	public void desejaBomDia() {
		m.msg("Bom Dia.\n");
	}
	
	public void desejaBoaTarde() {
		m.msg("Boa tarde.\n");
	}
	
	public void desejaBoaNoite() {
		m.msg("Boa noite.\n");	
	}
}