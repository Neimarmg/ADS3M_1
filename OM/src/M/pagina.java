package M;
import V.View;
public class pagina {
		
	private static int i = 0 ,j = 0;
	public static String [][] folha;

	
	public pagina(int linha , int coluna) {
		pagina.i = linha;
		pagina.j = coluna;
		folha = new String[linha][coluna];		
	}
	
	
	private static void imprime(boolean imprimir){
		if(imprimir == true){
			View.msg(" "+folha[i][j]);
		}
	}
	
	
	private static void gerenciaExecucao(boolean gerar,boolean imprimir){
		if(gerar == true){
			folha[i][j]= ".";
			imprime(imprimir);
		}else{
			imprime(imprimir);
		}
	}
	
	
	public static void executaFolha(boolean gerar, boolean imprimir) throws Exception {
		try {
			for (i = 0; i < folha.length; i++) {
				for (j = 0; j < folha.length; j++) {
					gerenciaExecucao(gerar, imprimir);
				}
				if(imprimir == true){
					View.msg("\n");
				}
			}
						
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msgb("Não foi possível criar o folha!");
		}
	}
}