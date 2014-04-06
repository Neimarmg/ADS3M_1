package View;

import Controller.Utilitarios.Prints;
import Model.MapaMod;

public class MapaView {
	int j,i;
	char letra = 'A';
	MapaMod m = new MapaMod();
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	/**
	 * Mètodo definidor do cabeçalho das colunas
	 */
	private void nomeiaConluna(){
		Prints.msg("+ ");
		for (j = 0; j <  MapaMod.getColuna(); j++) {
			Prints.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabelho quando necessário 
	 * @param mostraMsgCabecalho
	 */
	private void abilitaMensagem(boolean mostraMsgCabecalho,Object texto){
		if (mostraMsgCabecalho == true){
			//p.msgl();
			Prints.msg(texto +"\n");		
		}
	}
	
	
	/**
	 * Métode que desenha mapa de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabecalho,Object texto)throws Exception{
		try {
			abilitaMensagem(mostraMsgCabecalho,texto);
			nomeiaConluna();
			for (i = 0; i <  MapaMod.getLinha(); i++) {
				Prints.msg("\n" +i +" ");
				for (j = 0; j <  MapaMod.getColuna(); j++) {				
					Prints.msg(" " + MapaMod.getMapa()[i][j]);				
				}			
			}
			Prints.msg("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msgb("Não foi possível imprimir o mapa!");
			Prints.msg("" +MapaMod.getLinha()+"x" +MapaMod.getColuna() +"\n\n");
		}
	}
	
	
	
}
