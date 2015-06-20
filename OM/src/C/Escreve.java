package C;

import M.pagina;
import M.lc;

public class Escreve {
	

	
	
	
	public static void marcaPontos(boolean executar, boolean imprimir) throws Exception{
		for (int i = 0; i < pagina.folha.length; i++) {
			for (int j = 0; j < pagina.folha.length; j++) {				
				lc.setLinhaColuna(i,j);
				carater.criaLetraA();		
				}
		}
		pagina.executaFolha(false, imprimir);
	}
}
