package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Formatos {
	
	public void msg(Object desc){
		// imprime na tale memória dispPlanejamento inicial    
		System .out.print(desc);
	}
	
	
	public void msgb(Object desc){
		System .out.print("====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public void msgl(){
		System .out.print("\n====================================================\n");
	}
	
	public void msgOpcaoInvalida(){
		System .out.print("\nOpção de comando inválido. Tente novamente!\n");
	}
}