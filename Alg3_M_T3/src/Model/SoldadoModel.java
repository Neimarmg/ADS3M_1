package Model;

public class SoldadoModel {
	private int pontuacaoInicial = 15;
	private String nomeSoldado;
	
	
	public void setPontuacaoInicial(boolean maisPontos, int pontos) {
		if (maisPontos == false && pontos == 0){
			this.pontuacaoInicial = 15;
		}	this.pontuacaoInicial = pontos;
	}
		
	public int getPontuacaoInicial() {
		return pontuacaoInicial;
	}
	
	
	public void setNomeSoldado(String nomeSoldado) {
		this.nomeSoldado = nomeSoldado;
	}
	
	
	public String getNomeSoldado() {
		return nomeSoldado;
	}
	
}
