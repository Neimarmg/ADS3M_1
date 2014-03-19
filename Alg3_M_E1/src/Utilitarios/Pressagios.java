package Utilitarios;


public class Pressagios {
	String sauda;	
	
	Formatos m = new Formatos(); 
	
	public void desejaBomDia() {
		m.msg("Bom dia!\n\n");
	}
	
	public void desejaBoaTarde() {
		m.msg("Boa tarde!\n\n");
	}
	
	public void desejaBoaNoite() {
		m.msg("Boa noite!\n\n");	
	}
}
