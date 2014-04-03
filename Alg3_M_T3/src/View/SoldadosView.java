package View;

import Controller.Utilitarios.Prints;
import Model.SoldadoModel;

public class SoldadosView extends SoldadoModel {
	
	
	/**
	 * Método de avalição de nome 
	 */
	public void avaliaNome(){
		if (SoldadoModel.getNomeSoldado().equals(" ")) {
			Prints.msgc("O soldado ainda não possiu nome!\n");
		}else{
			Prints.msgc("Nome do jogador " 
				+SoldadoModel.getNomeSoldado() +"\n");
		}
	}
	
	/**
	 * Método de avalição da pontuação do soldado 
	 */
	public void avaliaPontos(){
		if (SoldadoModel.getPontuacaoInicial() > 0 ) {
			Prints.msgr("Pontuação inicial " 
				+SoldadoModel.getPontuacaoInicial() );
		}else{
			Prints.msgr("O soldado " +SoldadoModel.getNomeSoldado()
				+" não possui pontos para inicar o jogo!\n");
		}
	}
	
	
	public void imprime(){
		avaliaNome();
		avaliaPontos();
	}
}
