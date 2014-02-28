import java.util.Scanner;

public class ExecutaSaudacao extends DefineSaudacao {

	public static void main(String[] args) {
		
		ImprimeMensage m = new ImprimeMensage(); 
		DefineSaudacao s= new DefineSaudacao();
			
		Scanner var =new Scanner(System.in);
		
		m.msg("Que horas são: ");
		s.setHora(var.nextInt());
		s.horario();
		m.msg("?: ");
		var.next();


		}		


	
}

