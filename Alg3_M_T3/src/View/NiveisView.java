package View;

import Controller.Utilitarios.Prints;
import Model.NiveisModel;

public class NiveisView {
	String nome =" ";
	
	/**
	 * Método que encontra um nivel espeífico ou lista todos 
	 * dependendo do parêmetro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void pesquisa(boolean filtrar, int parametro){
			
		if (parametro == NiveisModel.getNivel1()  && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisModel.getNivel1()
				+" MAPA DE " +NiveisModel.getMapanivel1() +"x"+NiveisModel.getMapanivel1() +"\n";
		} 
			
		if (parametro == NiveisModel.getNivel2() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisModel.getNivel2()
				+" MAPA DE " +NiveisModel.getMapanivel2() +"x"+NiveisModel.getMapanivel2() +"\n";
		}
			
		if (parametro == NiveisModel.getNivel3() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisModel.getNivel3()
				+" MAPA DE " +NiveisModel.getMapanivel3() +"x"+NiveisModel.getMapanivel3() +"\n";
		}
				
		if (parametro == NiveisModel.getNivel4() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisModel.getNivel4()
				+" MAPA DE " +NiveisModel.getMapanivel4() +"x"+NiveisModel.getMapanivel4() +"\n";
		} 
		
		if (parametro == NiveisModel.getNivel5() && filtrar == true || filtrar == false) {
			nome += "\nNIVEL " 
				+NiveisModel.getNivel5()
				+" MAPA DE " +NiveisModel.getMapanivel5() +"x"+NiveisModel.getMapanivel5() +"\n";
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
