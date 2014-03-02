import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dia {
	Pressagios s = new Pressagios(); 	
	Mensagem m = new Mensagem(); 
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	public void ImprimeHora() {		
		cal.set(Calendar.DST_OFFSET,0);		
		m.msg(sdf.format(cal.getTime()) +"hs");
	}
	
	
	public void horario(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH"+"mm");
		int h = Integer.parseInt(sdf.format(cal.getTime()));
		if (h >= 0000  && h <= 1159)  {
			m.msg(" da manhã!" +"\n");
			s.bomDia();
		}		

		if (h >= 1200  && h <= 1759)  {
			m.msg(" da terde!" +"\n");
			s.boaTarde();
		}	
		
		if (h >= 1800  && h <= 1159)  {
			m.msg(" da noite!" +"\n");
			s.boaNoite();
		}	
	}	

}
