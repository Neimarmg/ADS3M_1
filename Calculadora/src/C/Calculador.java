package C;

import M.Dados;
import M.Operador;
import W.View;

public class Calculador {
	
	public static void limparValores(){
		Dados.setNumerador(0);
		Dados.setDenominador(0);	
	}
	
	
	public static void soma(){
		if (Dados.getNumerador() > 0) {
			if (Dados.getNumerador() < 0 && Dados.getDenominador()< 0){
				Dados.setValorResultado(Dados.getNumerador() - Dados.getDenominador());

			}else{
				Dados.setValorResultado(Dados.getNumerador() + Dados.getDenominador());
			}
		
		}else{
			Dados.setValorResultado(Dados.getValorResultado()+ Dados.getDenominador());
		}
	}
	
	
	public static void subtrai(){
		if (Dados.getNumerador() > 0 || Dados.getNumerador() < 0 ) {
			if (Dados.getNumerador() < 0 && Dados.getDenominador()< 0){
				Dados.setValorResultado(Dados.getNumerador() - Dados.getDenominador());

			}else{
				Dados.setValorResultado(Dados.getNumerador() - Dados.getDenominador());
			}
		
		}else{
			Dados.setValorResultado(Dados.getValorResultado()- Dados.getDenominador());
		}
	}
	
	
	public static void divide(){		
		if (Dados.getNumerador() > 0) {
			Dados.setValorResultado(Dados.getNumerador() / Dados.getDenominador());
		
		}else{
			if(Dados.getDenominador() > 0){
				Dados.setValorResultado(Dados.getValorResultado() / Dados.getDenominador());
			
			}else{	
				Dados.setValorResultado(Dados.getDenominador());
			}
		}
	}

	
	public static void multiplica(){
		if (Dados.getNumerador() > 0) {
			Dados.setValorResultado(Dados.getNumerador() * Dados.getDenominador());
		
		}else{
			Dados.setValorResultado(Dados.getValorResultado() * Dados.getDenominador());
		}
		
	}

	
	public static void percentual(){
		multiplica();
		Dados.setValorResultado(((Dados.getValorResultado()) /100));
		
		if (Dados.getNumerador() > 0) {
			
			switch (Operador.getOperacao()) {
				case "%":					
					Dados.getValorResultado();
					break;
				case "%+":			
					Dados.setValorResultado((Dados.getValorResultado()+Dados.getNumerador()));
					break;
					
				case "%-":			
					Dados.setValorResultado((Dados.getValorResultado()-Dados.getNumerador()));
					break;
			}
		}else{
			Dados.setValorResultado(0);
		}
		
	}

	
	public static void calcula (){
		switch (Operador.getOperacao()) {
		
		case "+":
			soma();
			break;
			
		case "-":
			subtrai();
			break;
			
		case "/":
			divide();
			break;
			
		case "*":			
			multiplica();
			break;
			
		case "%":			
			percentual();
			break;
		case "%+":			
			percentual();
			break;
			
		case "%-":			
			percentual();
			break;			
		}
		limparValores();
	}
	
	
	public static void imprimeCalculo(){
		
		if (!Operador.getOperacao().equals("=")){	
			calcula();
			View.msgcr("\nTotal: " +Dados.getValorResultado()+"\n");
		}else{
			View.msgl();
			View.msge("Sub total: " +Dados.getValorResultado());
		}
	}


}