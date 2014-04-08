package View.Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe controladora de saudaçãoes
 * @author Neimar, arelio
 */
public class Dia {
	Pressagios s = new Pressagios(); 	
	
	Calendar dh = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	

	public void ImprimeHora() {		
		dh.set(Calendar.DST_OFFSET,0);		
		Prints.msg("São " +sdf.format(dh.getTime()) +"hs");
	}
	
	/**
	 * Método de impressao de cabeçalho da saudação
	 * @param hora
	 */
	public void defineCabecalho(Object hora) {		
		Prints.msg("\nOlá!" +
			  "\n" +defineNomenclatura() +hora +"\n");
	}
	
	/**
	 *  Método De definidos de nomenclatura plural e singular
	 * @return
	 */
	public String defineNomenclatura() {
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora == 1) {
			return "É ";
		} return "São ";
		
	
	}
		
	/**
	 *  Método definidor de saudação
	 */
	public void defineSaudacao() {
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora <= 12) {
			defineCabecalho(sdf.format(dh.getTime()) +" da manhã." +"");
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