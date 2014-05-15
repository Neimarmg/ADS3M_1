package View;

import Controller.Inimigo;
import Model.SoldadoMod;
import Model.Utilitarios.Prints;

/**
 * Classe de impress�o de dados do soldado
 * @author Neimar, Aurelio
 */
public class SoldadosView extends SoldadoMod {
	
	/**
	 * M�todo de avalia��o de nome 
	 */
	public void avaliaNome() {
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			Prints.msg("\nO soldado ainda n�o possiu nome!\n");
		}else{
			Prints.msg("\nNome do jogador: " 
			+ SoldadoMod.getNomeSoldado() + "\n");
		}
	}
	
	/**
	 * M�todo de avalia��o da pontua��o do soldado 
	 */
	public void avaliaPontos() {
		if (SoldadoMod.getPontuacaoInicial() > 0 ) {
			Prints.msg("Pontua��o inicial: " 
			+Inimigo.getChances() +"\n"); // Imprime chances em tempo real do jogo!
		} else {
			Prints.msgr("O soldado " + SoldadoMod.getNomeSoldado()
				+" n�o possui pontos para iniciar o jogo!\n");
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