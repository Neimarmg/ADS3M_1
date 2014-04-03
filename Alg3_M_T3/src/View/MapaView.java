package View;

import Controller.Utilitarios.Prints;
import Model.MapaModel;

public class MapaView {
	int j,i;
	char letra = 'A';
	MapaModel m = new MapaModel();
	Prints p =  new Prints();
	
	
	/**
	 * Mètodo definidor do cabeçalho das colunas
	 */
	public void nomeiaConluna(){
		p.msg("+ ");
		for (j = 0; j <  MapaModel.getColuna(); j++) {
			p.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabelho quando necessário 
	 * @param mostraMsgCabelho
	 */
	public void abilitaMensagem(boolean mostraMsgCabelho,Object texto){
		if (mostraMsgCabelho == true){
			//p.msgl();
			p.msg(texto +" " 
				+MapaModel.getLinha()+"x" +MapaModel.getColuna() +"\n\n");		
		}
	}
	
	
	/**
	 * Métode que desenha mapa de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabelho,Object texto)throws Exception{
		try {
			abilitaMensagem(mostraMsgCabelho,texto);
			nomeiaConluna();
			for (i = 0; i <  MapaModel.getLinha(); i++) {
				p.msg("\n" +i +" ");
				for (j = 0; j <  MapaModel.getColuna(); j++) {				
					p.msg(" " + MapaModel.getMapa()[i][j]);				
				}			
			}
			p.msgr("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			p.msgb("Não foi possível imprimir o mapa!");
			p.msg("" +MapaModel.getExtancaoY());
		}
	}
	
	
	
}
