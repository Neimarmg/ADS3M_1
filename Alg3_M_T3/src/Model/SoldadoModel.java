package Model;

public class SoldadoModel {
	private static int pontuacaoInicial = 15;
	private static String nomeSoldado = "Jose";
	
	
	public static void setPontuacaoInicial(int pontuacaoInicial) {
		SoldadoModel.pontuacaoInicial = pontuacaoInicial;
	}
	
	
	public static int getPontuacaoInicial() {
		return pontuacaoInicial;
	}
	
	
	public static void setNomeSoldado(String nomeSoldado) {
		SoldadoModel.nomeSoldado = nomeSoldado;
	}
	
	
	public static String getNomeSoldado() {
		return nomeSoldado;
	}	
}
