package Model;

/**
 * Calsse definido de dados pessois do soldado
 * @author Neimar
 *
 */
public class SoldadoMod {
	private static int pontuacaoInicial =15;
	private static String nomeSoldado = "Jose calos";
	
	
	public static void setPontuacaoInicial(int pontuacaoInicial) {
		SoldadoMod.pontuacaoInicial = pontuacaoInicial;
	}
	
	
	public static int getPontuacaoInicial() {
		return pontuacaoInicial;
	}
	
	
	public static void setNomeSoldado(String nomeSoldado) {
		SoldadoMod.nomeSoldado = nomeSoldado;
	}
	
	
	public static String getNomeSoldado() {
		return nomeSoldado;
	}	
}
