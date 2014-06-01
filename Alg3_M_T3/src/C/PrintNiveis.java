package C;

import M.NiveisMod;
import V.View;

/**
 * Classe de impress�o de n�veis de jogo
 * @author Neimar, Aur�lio
 */
public class PrintNiveis {
	String acum =" ";
	
	/**
	 * M�todo que encontra um n�vel espec�fico ou lista todos, 
	 * dependendo do par�metro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void pesquisa(boolean filtrar, int parametro) {
			
		if (parametro == NiveisMod.getNivel1()  && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel1()
				 +  " MAPA DE " + NiveisMod.getMapanivel1() + "x" + NiveisMod.getMapanivel1() + "\n";
		} 
			
		if (parametro == NiveisMod.getNivel2() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel2()
				 +  " MAPA DE " + NiveisMod.getMapanivel2() + "x" +NiveisMod.getMapanivel2() +"\n";
		}
			
		if (parametro == NiveisMod.getNivel3() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel3()
				 +  " MAPA DE " + NiveisMod.getMapanivel3() + "x" + NiveisMod.getMapanivel3() + "\n";
		}
				
		if (parametro == NiveisMod.getNivel4() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel4()
				 +  " MAPA DE " + NiveisMod.getMapanivel4() + "x" + NiveisMod.getMapanivel4() + "\n";
		} 
		
		if (parametro == NiveisMod.getNivel5() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel5()
				 +  " MAPA DE " + NiveisMod.getMapanivel5() + "x" + NiveisMod.getMapanivel5() + "\n";
		}		
	}
	
	/**
	 * M�todo de valida��o de busca
	 * @param filtrar
	 * @param parametro
	 */
	public void executa(boolean filtrar, int parametro) {
		pesquisa(filtrar, parametro);
		View.msg(acum);
		
		if (filtrar == true && acum.equals(" ")) {
			View.msgb("Nivel inesistente!");
		} else {
			pesquisa(filtrar, parametro);			
		}
		acum =""; // Limpa vari�vel de impress�o 
	}
	
	/**
	 * Habilita exibi��o do cabe�alho
	 * @param filtrar
	 * @param mostraCabecalho
	 */
	private void abilitaCabecalho(boolean filtrar,Boolean mostraCabecalho) {
		if (mostraCabecalho == true) {
			if (filtrar == true) {
				View.msgc("	CONSULTA DE N�VEL\n");
			} else {
				View.msgc("	LISTA DE N�VEIS DO JOGO\n");
			}
		}
	}
		
	/**
	 * M�todo de impress�o de navios inimigos
	 * @param filtrar
	 */
	public void imprime(boolean filtrar, Boolean mostraCabecalho) {
		abilitaCabecalho(filtrar, mostraCabecalho);
		if (filtrar == true) {
			executa(filtrar, View.digitaNumero("Nro do nivel "));
		} else {
			executa(filtrar, 0);
		}
	}
}