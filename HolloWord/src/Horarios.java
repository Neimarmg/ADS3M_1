import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date; //– relativa a um ponto específico no tempo.
import java. text.DateFormat; //e java.text.SimpleDateFormat – ambas permitindo converter datas em texto e vice versa.
import java.text.SimpleDateFormat;

public class Horarios {
	String responde, hora;
	
	Saudacao s = new Saudacao(); 	
	Mensagem m = new Mensagem(); 
	
	public void ImprimeHora() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.DST_OFFSET,0);		
		m.msg(sdf.format(cal.getTime())); 		
	}
	
	public void setResponde(String responde) {
		this.responde = responde;
	}
/*
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void horario(){
		
		if (hora >= 1:00 && hora<=11:59)  {
			s.bomDia();
		}		
		
		if (hora >= 12 && hora<=18)  {
			s.boaTarde();
		}	
		
		if (hora >= 18 && hora<=24)  {
			s.boaNoite();
		}	
	}	
*/
}
