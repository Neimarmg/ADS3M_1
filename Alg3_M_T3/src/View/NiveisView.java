package View;

import Controller.Utilitarios.Prints;
import Model.NiveisMod;

public class NiveisView {
	String nome =" ";
	
	/**
	 * Método que encontra um nivel espeífico ou lista todos 
	 * dependendo do parêmetro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void pesquisa(boolean filtrar, int parametro){
			
		if (parametro == NiveisMod.getNivel1()  && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisMod.getNivel1()
				+" MAPA DE " +NiveisMod.getMapanivel1() +"x"+NiveisMod.getMapanivel1() +"\n";
		} 
			
		if (parametro == NiveisMod.getNivel2() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisMod.getNivel2()
				+" MAPA DE " +NiveisMod.getMapanivel2() +"x"+NiveisMod.getMapanivel2() +"\n";
		}
			
		if (parametro == NiveisMod.getNivel3() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisMod.getNivel3()
				+" MAPA DE " +NiveisMod.getMapanivel3() +"x"+NiveisMod.getMapanivel3() +"\n";
		}
				
		if (parametro == NiveisMod.getNivel4() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisMod.getNivel4()
				+" MAPA DE " +NiveisMod.getMapanivel4() +"x"+NiveisMod.getMapanivel4() +"\n";
		} 
		
		if (parametro == NiveisMod.getNivel5() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisMod.getNivel5()
				+" MAPA DE " +NiveisMod.getMapanivel5() +"x"+NiveisMod.getMapanivel5() +"\n";
		}		
	}
	
	public void executa(boolean filtrar, int parametro){
		pesquisa(filtrar, parametro);
		Prints.msg(nome);
		
		if (filtrar == true && nome.equals(" ")) {
			Prints.msgb("Nivel inesistente!");
		}else{
			pesquisa(filtrar, parametro);			
		}
	}
	
	/**
	 * Abilita exibição do cabeçalho
	 * @param filtrar
	 * @param mostraCabecalho
	 */
	private void abilitaCabecalho(boolean filtrar,Boolean mostraCabecalho){
		if (mostraCabecalho == true) {
			if (filtrar == true) {
				Prints.msgc("	CONSULTA DE NIVEL\n");
			}else{
				Prints.msgc("	LISTA DE NIVEIS DO JOGO\n");
			}
		}
	}
		
	/**
	 * Método de impressão de navios inimigo
	 * @param filtrar
	 */
	public void imprime(boolean filtrar,Boolean mostraCabecalho){
		abilitaCabecalho(filtrar, mostraCabecalho);
		if (filtrar == true) {
			executa(filtrar,Prints.digitaNumero("Nro do nivel "));
		}else{
			executa(filtrar,0);
		}
	}
}
