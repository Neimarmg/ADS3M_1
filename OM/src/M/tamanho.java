package M;

public class tamanho {
	private static int altura, lagura;

	public static int getAltura() {
		return altura;
	}

	
	public static void setAltura(int altura) {
		tamanho.altura = altura;
	}

	
	public static int getLagura() {
		return lagura;
	}

	
	public static void setLagura(int lagura) {
		tamanho.lagura = lagura;
	}

	
	public static void setAlturaLagura(int altura, int lagura) {
		tamanho.altura = altura;
		tamanho.lagura = lagura;

	}
	
}
