package View;

import Controller.Utilitarios.Prints;
import Model.MapaModel;

public class MapaView {
	int j,i;
	char letra = 'A';
	MapaModel m = new MapaModel();
	Prints p =  new Prints();
	
	
	/**
	 * M�todo definidor do cabe�alho das colunas
	 */
	public void letraConluna(){
		p.msg("+ ");
		for (j = 0; j <  m.getColuna(); j++) {
			p.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabelho quando necess�rio 
	 * @param mostraMsgCabelho
	 */
	public void exibeMensagem(boolean mostraMsgCabelho,Object texto){
		if (mostraMsgCabelho == true){
			p.msg(texto);
		}
	}
	
	
	/**
	 * M�tode que desenha mapa de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprimeTabuleiro(boolean mostraMsgCabelho,Object texto)throws Exception{
		try {
			exibeMensagem(mostraMsgCabelho,texto);
			letraConluna();
			for (i = 0; i <  m.getLinha(); i++) {
				p.msg("\n" +i +" ");
				for (j = 0; j <  m.getColuna(); j++) {				
					p.msg(" " + m.getMapa()[i][j]);				
				}			
			}		
		} catch (ArrayIndexOutOfBoundsException e) {
			p.msgb("N�o foi poss�vel imprimir o mapa!");
		}
	}
}
