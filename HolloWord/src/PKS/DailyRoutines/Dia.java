package PKS.DailyRoutines;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import PKS.Mensagem;
import PKS.Pressagios;

public class Dia {
	Pressagios s = new Pressagios(); 	
	Mensagem m = new Mensagem(); 
	Calendar dh = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	public void ImprimeHora() {		
		dh.set(Calendar.DST_OFFSET,0);		
		m.msg("São:" +sdf.format(dh.getTime()) +"hs");
	}
	
	
	public void execuataCabecalho(Object hora){		
		m.msg("\nEi !!!" +
				"\n\nSão: " +hora +"\n");
	}
	
	
	public void horario(){
		dh.set(Calendar.DST_OFFSET,0);
		
		int hora =  dh.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora <= 12)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da manhã!" +"\n");
			s.bomDia();
		}		

		if (hora >= 12  && hora <= 18)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da tarde!" +"\n");
			s.boaTarde();
		}	
		
		if (hora > 18  && hora <= 24)  {
			execuataCabecalho(sdf.format(dh.getTime()) +"hs" +" da noite!" +"\n");
			s.boaNoite();
		}	
	}
}
