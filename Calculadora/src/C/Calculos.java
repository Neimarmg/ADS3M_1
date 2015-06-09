package C;
import M.Dados;
import M.Operadores;

public class Calculos {
	
	public static void limparValores(){
		Dados.setNumerador(0);
		Dados.setDenominador(0);	
	}
	
	
	public static void soma(){
		if (Dados.getNumerador() > 0) {
			if (Dados.getNumerador() < 0 && Dados.getDenominador()< 0){
				Dados.setValorCalculado(Dados.getNumerador() - Dados.getDenominador());
			}else{
				Dados.setValorCalculado(Dados.getNumerador() + Dados.getDenominador());
			}
		}else{
			Dados.setValorCalculado(Dados.getValorCalculado()+ Dados.getDenominador());
		}
	}
	
	
	public static void subtrai(){
		if (Dados.getNumerador() > 0 || Dados.getNumerador() < 0 ) {
			if (Dados.getNumerador() < 0 && Dados.getDenominador()< 0){
				Dados.setValorCalculado(Dados.getNumerador() + Dados.getDenominador());
				System.out.print("dddd");
			}else{
				Dados.setValorCalculado(Dados.getNumerador() + Dados.getDenominador());
			}
		}else{
			Dados.setValorCalculado(Dados.getValorCalculado()- Dados.getDenominador());
		}
	}
	
	
	public static void divide(){		
		if (Dados.getNumerador() > 0) {
			Dados.setValorCalculado(Dados.getNumerador() / Dados.getDenominador());
		}else{
			Dados.setValorCalculado(Dados.getDenominador());
		}
	}

	
	public static void multiplica(){
		if (Dados.getNumerador() > 0) {
			Dados.setValorCalculado(Dados.getNumerador() * Dados.getDenominador());
		}else{
			Dados.setValorCalculado(Dados.getValorCalculado() * Dados.getDenominador());
		}
		
	}
		
		
	public static void calcula (){
		switch (Operadores.getOperacao()) {
		
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
		default:
			break;
		}
		limparValores();
	}
	
	
	public static void imprimeCalculo(){
		calcula();
		System.out.print("\n=========================="
				+ "\nValor Total: " +Dados.getValorCalculado()
				+"\n==========================");
	}


}