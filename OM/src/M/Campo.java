package M;
import V.View;
public class Campo {
	
	private static int i = 0 ,j = 0;
	public static String [][]mapa;
	
	

	public Campo(int linha,int coluna) {
		mapa = new String[linha][coluna];
	}
		
	private static void imprime(boolean imprimir){
		if(imprimir == true){
			View.msg(" "+mapa[i][j]);
		}
	}
	
	private static void gerenciaExecucao(boolean gerar,boolean imprimir){
		if(gerar == true){
			mapa[i][j]= ".";
			imprime(imprimir);
		}else{
			imprime(imprimir);
		}
	}
	
	public static void executaMapa(boolean gerar, boolean imprimir) throws Exception {
		try {
			for (i = 0; i < mapa.length; i++) {
				for (j = 0; j < mapa.length; j++) {
					gerenciaExecucao(gerar, imprimir);
				}
				if(imprimir == true){
					View.msg("\n");
				}
			}
						
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msgb("Não foi possível criar o mapa!");
		}
	}
}
