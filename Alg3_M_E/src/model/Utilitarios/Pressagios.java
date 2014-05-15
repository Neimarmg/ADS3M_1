package model.Utilitarios;

import Aplicacao.Prints;

public class Pressagios {
	String sauda;	
	
	public void desejaBomDia() {
		Prints.msg("Bom dia.\n");
	}
	
	public void desejaBoaTarde() {
		Prints.msg("Boa tarde.\n");
	}
	
	public void desejaBoaNoite() {
		Prints.msg("Boa noite.\n");	
	}
}