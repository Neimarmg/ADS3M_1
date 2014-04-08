package View.Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe controladora de sauda��oes
 * @author Neimar, arelio
 */
public class Dia {
	Pressagios pressagios = new Pressagios(); 	
	
	Calendar diaHora = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	

	public void ImprimeHora() {		
		diaHora.set(Calendar.DST_OFFSET,0);		
		Prints.msg("S�o " +sdf.format(diaHora.getTime()) +"hs");
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
		diaHora.set(Calendar.DST_OFFSET,0);
		
		int hora =  diaHora.get(Calendar.HOUR_OF_DAY);
		
		if (hora == 1) {
			return "� ";
		} return "S�o ";
		
	
	}
		
	/**
	 *  M�todo definidor de sauda��o
	 */
	public void defineSaudacao() {
		diaHora.set(Calendar.DST_OFFSET,0);
		
		int hora =  diaHora.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora <= 12) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da manh�." +"");
			pressagios.desejaBomDia();
		}

		if (hora >= 12  && hora <= 18) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da tarde." +"");
			pressagios.desejaBoaTarde();
		}	
		
		if (hora > 18  && hora <= 24) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da noite." +"");
			pressagios.desejaBoaNoite();
		}	
	}
}