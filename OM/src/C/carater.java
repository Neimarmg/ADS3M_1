package C;
import M.pagina;
import M.lc;
import M.tamanho;

public class carater {

	public static void p1() {
		if (lc.getLinha() < tamanho.getAltura()) {
			pagina.folha[lc.getLinha()][lc.getColuna()] = "0";
		}	
	}
	
	public static void z1() {
		if (lc.getColuna() < tamanho.getLagura()) {
			pagina.folha[lc.getLinha()][lc.getColuna()] = "z";
		}	
	}
	
	public static void criaLetraA() {
		if (lc.getColuna()== tamanho.getAltura()) {
			p1();			
		}
			
		if (lc.getLinha() == tamanho.getLagura()) {
			z1();
		}	
	}

	
}
