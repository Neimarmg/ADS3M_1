package View;

import Model.MapaMod;
import Model.Utilitarios.Prints;

/**
 * Classe de impressão dos dados do mapaMod
 * @author Naimar, Aurélio
 */
public class MapaView {
	int j,i;
	char letra = 'A';
	MapaMod mapaMod = new MapaMod();
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	/**
	 * Método definidor do cabeçalho das colunas
	 */
	private void nomeiaConluna() {
		Prints.msg("+ ");
		for (j = 0; j <  MapaMod.getColuna(); j++) {
			Prints.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabeçalho quando necessário 
	 * @param mostraMsgCabecalho
	 */
	private void abilitaMsg(boolean mostraMsgCabecalho,Object texto) {
		if (mostraMsgCabecalho == true) {
			//p.msgl();
			Prints.msg(texto + "\n");		
		}
	}
	
	
	/**
	 * Método que desenha mapaMod de batalha
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
			Prints.msgb("Não foi possível imprimir o mapaMod!");
			Prints.msg("" +MapaMod.getLinha() + "x" + MapaMod.getColuna() + "\n\n");
		}
	}
	
	/**
	 * Imprime ragras o jogo
	 */
	public void imprimeRegras() {
		Prints.msgb("	REGRAS DO JOGO?\n\n"
				+ "=> Digitar o comando 'iniciar' onde será impresso o\n"
				+ "   mapa inicial do jogo \n\n"		
				+ "=> Digitar o comando 'jogar' para confirmar que o \n"
				+ "   jogador vai iniciar o jogo assim até serem \n\n"
				+ "=> Digitar o comando atirar para poder informar as \n"
				+ "   coordenada e do tiro, seguindo esgotadas as chances \n"
				+ "   ou até que jogador perca ou vença o jogo\n\n"   
				+ "=> O jogado inicia o jogo com 15 chances,\n\n"
				+ "=> Com 0 pontos os jogador inicia o nível 1\n\n"
				+ "=> Com 6 pontos os jogador passa para o nível 2\n\n"
				+ "=> Com 12 pontos os jogador passa para o nível 3\n\n"
				+ "=> Com 21 pontos os jogador passa para o nível 4\n\n"
				+ "=> Com 30 pontos os jogador passa para o nível 5,\n"
				+ "   nível máximo\n\n"
				+ "=> Para atingir a pontuação máxima de 42 pontos o \n"
				+ "   jogador não poderá errar nenhuma tiro\n\n"
				+ "=> O jogador ainda pode jogar em um nível personalizado\n"
				+ "   onde o jogador\n\n"
				+ "=> Com definições prórpias de mapa e numero de chances\n");

	}
}