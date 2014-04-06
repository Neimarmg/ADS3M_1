package View;

import Controller.Utilitarios.Prints;
import Model.SoldadoMod;

public class SoldadosView extends SoldadoMod {
	
	
	/**
	 * Método de avalição de nome 
	 */
	public void avaliaNome(){
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			Prints.msg("\nO soldado ainda não possiu nome!\n");
		}else{
			Prints.msg("\nNome do jogador: " 
				+SoldadoMod.getNomeSoldado() +"\n");
		}
	}
	
	/**
	 * Método de avalição da pontuação do soldado 
	 */
	public void avaliaPontos(){
		if (SoldadoMod.getPontuacaoInicial() > 0 ) {
			Prints.msg("Pontuação inicial: " 
				+SoldadoMod.getPontuacaoInicial() +"\n");
		}else{
			Prints.msgr("O soldado " +SoldadoMod.getNomeSoldado()
				+" não possui pontos para inicar o jogo!\n");
		}
	}
	
	
	public void imprime(){
		avaliaNome();
		avaliaPontos();
	}
}
