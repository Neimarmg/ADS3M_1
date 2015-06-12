package app;

import M.Campo;
import M.Desenha;

public class start {
	public static void main(String[] args)throws Exception {
		new Campo(20, 20);
		Campo.executaMapa(true, false); 
		
		Desenha.marcaPontos(true, true);
	}
}
