package model.Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Wiew.Prints;

public class Dia {
	static Pressagios pressagios = new Pressagios();
	
	static Calendar diaHora = Calendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	public static void ImprimeHora() {		
		diaHora.set(Calendar.DST_OFFSET,0);		
		Prints.msg("S�o " +sdf.format(diaHora.getTime()) +"hs");
	}
	
	/**
	 * 
	 * @param hora
	 */
	public static void defineCabecalho(Object hora) {		
		Prints.msg("\nOl�!" +
			  "\n" +defineNomenclatura() +hora +"\n");
	}
	
	public static String defineNomenclatura() {
		diaHora.set(Calendar.DST_OFFSET,0);
		
		int hora =  diaHora.get(Calendar.HOUR_OF_DAY);
		
		if (hora == 0) {
			return "� ";
		} return "S�o ";
	}
		
	public static void defineSaudacao() {
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