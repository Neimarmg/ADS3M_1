package M;

public class Dados {
 	static float numerador;
	static float denominador;
	static float valorResultado;
 	
	public Dados(float numerador, float denominador) {
		Dados.numerador = numerador;
		Dados.denominador =denominador;
	}
	
	
	public static float getNumerador() {
		return Dados.numerador;
	}

	
	public static void setNumerador(float numerador) {
		Dados.numerador = numerador;
	}

	
	public static float getDenominador() {
		return denominador;
	}

	
	public static void setDenominador(float denominador) {
		Dados.denominador = denominador;
	}

	
	public static float getValorResultado() {
		return valorResultado;
	}

	
	public static void setValorResultado(float valorDeCalculo) {
		Dados.valorResultado = valorDeCalculo;		
	}


}
