package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dia {
	Pressagios s = new Pressagios(); 	
	Formatos m = new Formatos();
	
	Calendar dh = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	public void ImprimeHora() {		
		dh.set(Calendar.DST_OFFSET,0);		
		m.msg("São " +sdf.format(dh.getTime()) +"hs");
	}
	
	/**
	 * 
	 * @param hora
	 */
	public void defineCabecalho(Object hora) {		
		m.msg("\nOlá!" +
			  "\n" +defineNomenclatura() +hora +"\n");
	}
	
	
	public String defineNomenclatura() {
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora <= 0) {
			return "É ";
		} return "São ";
		
	
	}
		
	
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