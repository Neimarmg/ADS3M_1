package PKS;
import java.util.Scanner;
import PKS.DailyRoutines.Dia;

public class Programa{
	
	Scanner var =new Scanner(System.in);
	
	Mensagem m = new Mensagem(); 
	Dia s = new Dia();
	Complementos c = new Complementos();
	

	
	public void executaPrograma(){
		s.horario();
	}

	
	
	
	
	public static void main(String[] args) {
		Programa p  = new Programa();
		p.executaPrograma();
	}	
}

