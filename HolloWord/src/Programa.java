import java.util.Scanner;

import javax.lang.model.element.NestingKind;

public class Programa{
	
	Scanner var =new Scanner(System.in);
	
	Mensagem m = new Mensagem(); 
	Dia s = new Dia();
	Complementos c = new Complementos();
	
	private void execuataCabecalho(){
		m.msg("\nEi!!!" +"\n\n" +"São:"  );
		s.ImprimeHora();
		s.horario();
	}
	
	public void executaPrograma(){
		execuataCabecalho();
	}

	
	
	
	
	public static void main(String[] args) {
		Programa p  = new Programa();
		p.executaPrograma();
	}	
}

