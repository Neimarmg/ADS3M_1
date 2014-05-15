package View;

import Model.MapaMod;
import Model.Utilitarios.Prints;

/**
 * Classe de impress�o dos dados do mapaMod.
 * @author Naimar, Aur�lio
 */
public class MapaView {
	int j,i;
	char letra = 'A';
	MapaMod mapaMod = new MapaMod();
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	/**
	 * M�todo definidor do cabe�alho das colunas
	 */
	private void nomeiaConluna() {
		Prints.msg("+ ");
		for (j = 0; j <  MapaMod.getColuna(); j++) {
			Prints.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabe�alho quando necess�rio 
	 * @param mostraMsgCabecalho
	 */
	private void abilitaMsg(boolean mostraMsgCabecalho,Object texto) {
		if (mostraMsgCabecalho == true) {
			// p.msgl();
			Prints.msg(texto + "\n");		
		}
	}
	
	
	/**
	 * M�todo que desenha mapaMod de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabecalho,Object texto)throws Exception {
		try {
			abilitaMsg(mostraMsgCabecalho,texto);
			nomeiaConluna();
			for (i = 0; i <  MapaMod.getLinha(); i++) {
				Prints.msg("\n" + i + " ");
				for (j = 0; j <  MapaMod.getColuna(); j++) {				
					Prints.msg(" " + MapaMod.getMapa()[i][j]);				
				}			
			}
			Prints.msg("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msgb("N�o foi poss�vel imprimir o mapaMod!");
			Prints.msg("" +MapaMod.getLinha() + "x" + MapaMod.getColuna() + "\n\n");
		}
	}
	
	/**
	 * Imprime regras do jogo
	 */
	public void imprimeRegras() {
		Prints.msgb("	REGRAS DO JOGO:\n\n"
				+ "=> Digitar o comando 'iniciar' onde ser� impresso o\n"
				+ "   mapa inicial do jogo.\n\n"		
				+ "=> Digitar o comando 'jogar' para confirmar que o \n"
				+ "   jogador vai iniciar o jogo.\n\n"
				+ "=> Digitar o comando 'atirar' para informar as \n"
				+ "   coordenadas de tiro.\n\n"   
				+ "=> O jogador inicia o jogo com 15 chances.\n\n"
				+ "=> Com 0 ponto o jogador inicia o n�vel 1.\n\n"
				+ "=> Com 6 pontos o jogador passa para o n�vel 2.\n\n"
				+ "=> Com 12 pontos o jogador passa para o n�vel 3.\n\n"
				+ "=> Com 21 pontos o jogador passa para o n�vel 4.\n\n"
				+ "=> Com 30 pontos o jogador passa para o n�vel 5,\n"
				+ "   n�vel m�ximo.\n\n"
				+ "=> Para atingir a pontua��o m�xima de 42 pontos,\n"
				+ "   o jogador n�o poder� errar nenhum tiro\n\n"
				+ "=> O jogador ainda pode jogar em um n�vel personalizado\n"
				+ "   com defini��es pr�prias de mapa e n�mero de chances.\n");

	}
}