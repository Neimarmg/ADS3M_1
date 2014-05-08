package View;

import Controller.Inimigo;
import Model.SoldadoMod;
import Model.Utilitarios.Prints;

/**
 * Classe de impressão de dados do soldado
 * @author Neimar, Aurelio
 */
public class SoldadosView extends SoldadoMod {
	
	/**
	 * Método de avaliação de nome 
	 */
	public void avaliaNome() {
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			Prints.msg("\nO soldado ainda não possiu nome!\n");
		}else{
			Prints.msg("\nNome do jogador: " 
			+ SoldadoMod.getNomeSoldado() + "\n");
		}
	}
	
	/**
	 * Método de avaliação da pontuação do soldado 
	 */
	public void avaliaPontos() {
		if (SoldadoMod.getPontuacaoInicial() > 0 ) {
			Prints.msg("Pontuação inicial: " 
			+Inimigo.getChances() +"\n"); // Imprime chances em tempo real do jogo!
		} else {
			Prints.msgr("O soldado " + SoldadoMod.getNomeSoldado()
				+" não possui pontos para iniciar o jogo!\n");
		}
	}
	
	/**
	 * Método que imprime dados do soldado
	 */
	public void imprime() {
		avaliaNome();
		avaliaPontos();
	}
}