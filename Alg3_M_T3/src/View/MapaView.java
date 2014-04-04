package View;

import Controller.Utilitarios.Prints;
import Model.MapaModel;

public class MapaView {
	int j,i;
	char letra = 'A';
	MapaModel m = new MapaModel();

	
	/**
	 * M�todo definidor do cabe�alho das colunas
	 */
	public void nomeiaConluna(){
		Prints.msg("+ ");
		for (j = 0; j <  MapaModel.getColuna(); j++) {
			Prints.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabelho quando necess�rio 
	 * @param mostraMsgCabecalho
	 */
	public void abilitaMensagem(boolean mostraMsgCabecalho,Object texto){
		if (mostraMsgCabecalho == true){
			//p.msgl();
			Prints.msg(texto +" " 
				+MapaModel.getLinha()+"x" +MapaModel.getColuna() +"\n\n");		
		}
	}
	
	
	/**
	 * M�tode que desenha mapa de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabecalho,Object texto)throws Exception{
		try {
			abilitaMensagem(mostraMsgCabecalho,texto);
			nomeiaConluna();
			for (i = 0; i <  MapaModel.getLinha(); i++) {
				Prints.msg("\n" +i +" ");
				for (j = 0; j <  MapaModel.getColuna(); j++) {				
					Prints.msg(" " + MapaModel.getMapa()[i][j]);				
				}			
			}
			Prints.msgr("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msgb("N�o foi poss�vel imprimir o mapa!");
			Prints.msg("" +MapaModel.getExtancaoY());
		}
	}
	
	
	
}
