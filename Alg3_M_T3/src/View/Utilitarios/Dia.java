package View.Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe controladora de sauda��oes
 * @author Neimar, arelio
 */
public class Dia {
	Pressagios s = new Pressagios(); 	
	
	Calendar dh = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	

	public void ImprimeHora() {		
		dh.set(Calendar.DST_OFFSET,0);		
		Prints.msg("S�o " +sdf.format(dh.getTime()) +"hs");
	}
	
	/**
	 * M�todo de impressao de cabe�alho da sauda��o
	 * @param hora
	 */
	public void defineCabecalho(Object hora) {		
		Prints.msg("\nOl�!" +
			  "\n" +defineNomenclatura() +hora +"\n");
	}
	
	/**
	 *  M�todo De definidos de nomenclatura plural e singular
	 * @return
	 */
	public String defineNomenclatura() {
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora == 1) {
			return "� ";
		} return "S�o ";
		
	
	}
		
	/**
	 *  M�todo definidor de sauda��o
	 */
	public void defineSaudacao() {
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora <= 12) {
			defineCabecalho(sdf.format(dh.getTime()) +" da manh�." +"");
			s.desejaBomDia();
		}

		if (hora >= 12  && hora <= 18) {
			defineCabecalho(sdf.format(dh.getTime()) +" da tarde." +"");
			s.desejaBoaTarde();
		}	
		
		if (hora > 18  && hora <= 24) {
			defineCabecalho(sdf.format(dh.getTime()) +" da noite." +"");
			s.desejaBoaNoite();
		}	
	}
}