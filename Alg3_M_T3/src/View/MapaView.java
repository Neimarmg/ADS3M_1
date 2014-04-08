package View;

import Model.MapaMod;
import View.Utilitarios.Prints;

/**
 * Classe de impressao dados do mapa.
 * @author Naimar, Aur�lio
 */
public class MapaView {
	int j,i;
	char letra = 'A';
	MapaMod m = new MapaMod();
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	/**
	 * M�todo definidor do cabe�alho das colunas
	 */
	private void nomeiaConluna(){
		Prints.msg("+ ");
		for (j = 0; j <  MapaMod.getColuna(); j++) {
			Prints.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabelho quando necess�rio 
	 * @param mostraMsgCabecalho
	 */
	private void abilitaMsg(boolean mostraMsgCabecalho,Object texto){
		if (mostraMsgCabecalho == true){
			//p.msgl();
			Prints.msg(texto +"\n");		
		}
	}
	
	
	/**
	 * M�tode que desenha mapa de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabecalho,Object texto)throws Exception{
		try {
			abilitaMsg(mostraMsgCabecalho,texto);
			nomeiaConluna();
			for (i = 0; i <  MapaMod.getLinha(); i++) {
				Prints.msg("\n" +i +" ");
				for (j = 0; j <  MapaMod.getColuna(); j++) {				
					Prints.msg(" " + MapaMod.getMapa()[i][j]);				
				}			
			}
			Prints.msg("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msgb("N�o foi poss�vel imprimir o mapa!");
			Prints.msg("" +MapaMod.getLinha()+"x" +MapaMod.getColuna() +"\n\n");
		}
	}
	
	
	
}
