package Model.Utilitarios;

/**
 * Classe de umpressao de pressagios 
 * @author Neimar, Aurélio
 *
 */
public class Pressagios {
	String sauda;	
	
	public void desejaBomDia() {
		Prints.msg("Bom Dia.\n");
	}
	
	public void desejaBoaTarde() {
		Prints.msg("Boa tarde.\n");
	}
	
	public void desejaBoaNoite() {
		Prints.msg("Boa noite.\n");	
	}
}