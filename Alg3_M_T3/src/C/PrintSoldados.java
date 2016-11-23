package C;

import M.SoldadoMod;
import V.View;

/**
 * Classe de impress�o de dados do soldado
 * @author Neimar, Aur�lio
 */
public class PrintSoldados extends SoldadoMod {
	
	/**
	 * M�todo de avalia��o de nome 
	 */
	public void avaliaNome() {
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			View.msg("\nO soldado ainda n�o possui nome!\n");
		} else {
			View.msg("\nNome do jogador: " 
			+ SoldadoMod.getNomeSoldado() + "\n");
		}
	}
	
	/**
	 * M�todo de avalia��o da pontua��o do soldado 
	 */
	public void avaliaPontos() {
		if (SoldadoMod.getPontuacaoInicial() > 0) {
			View.msg("Pontua��o inicial: " 
			+ Inimigo.getChances() + "\n"); // Imprime chances em tempo real do jogo
		} else {
			View.msgr("O soldado " + SoldadoMod.getNomeSoldado()
				+ " n�o possui pontos para iniciar o jogo!\n");
		}
	}
	
	/**
	 * M�todo que imprime dados do soldado
	 */
	public void imprime() {
		avaliaNome();
		avaliaPontos();
	}
}