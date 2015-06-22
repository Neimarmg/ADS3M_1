package app;

import C.Escreve;
import M.pagina;
import M.tamanho;

public class start {
	public static void main(String[] args)throws Exception {
		new pagina(25, 25);
		tamanho.setAlturaLagura(5, 3);
		pagina.executaFolha(true, false); 		
		Escreve.marcaPontos(true, true);
	}
}