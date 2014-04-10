package View;

import Model.MapaMod;
import View.Utilitarios.Prints;

/**
 * Classe de impressão dos dados do mapaMod.
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
}