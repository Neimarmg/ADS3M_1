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
		m.msg("São:" +sdf.format(dh.getTime()) +"hs");
	}
	
	
	public void execuataCabecalho(Object hora){		
		m.msg("OLA!!!" +
				"\nSão: " +hora +"\n");
	}
	
	
	public void horario(){
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora <= 12)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da manhã!" +"");
			s.bomDia();
		}		

		if (hora >= 12  && hora <= 18)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da tarde!" +"");
			s.boaTarde();
		}	
		
		if (hora > 18  && hora <= 24)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da noite!" +"");
			s.boaNoite();
		}	
	}
}
