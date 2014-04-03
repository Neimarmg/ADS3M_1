package View;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;

public class SoldadosView extends SoldadoModel {
	
	
	/**
	 * M�todo de avali��o de nome 
	 */
	public void avaliaNome(){
		if (SoldadoModel.getNomeSoldado().equals(" ")) {
			Prints.msg("\nO soldado ainda n�o possiu nome!\n");
		}else{
			Prints.msg("\nNome do jogador: " 
				+SoldadoModel.getNomeSoldado() +"\n");
		}
	}
	
	/**
	 * M�todo de avali��o da pontua��o do soldado 
	 */
	public void avaliaPontos(){
		if (SoldadoModel.getPontuacaoInicial() > 0 ) {
			Prints.msg("Pontua��o inicial: " 
				+SoldadoModel.getPontuacaoInicial() );
		}else{
			Prints.msgr("O soldado " +SoldadoModel.getNomeSoldado()
				+" n�o possui pontos para inicar o jogo!\n");
		}
	}
	
	
	public void imprime(){
		avaliaNome();
		avaliaPontos();
	}
}
