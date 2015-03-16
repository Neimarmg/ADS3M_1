package APP;

import V.View;
import V.menus;
import C.scaner;
import C.processos;

public class start {
	public static void cabecalho(){
		View.msg("\n=======================================================================\n\n"
				+ "CALCULADOR DE GOSTO DE COMBUSTIVEL"
				+"\n\n=======================================================================\n");
	}
		
	public static void main(String[] args) {
		cabecalho();
		menus.menuInicial();
		processos.executaPrograma(scaner.digita(""));
	}

}
