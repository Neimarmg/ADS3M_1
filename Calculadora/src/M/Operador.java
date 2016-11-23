package M;

public class Operador {
	static String Operacao;
 	static int acumulador = 0;

	public static String getOperacao() {
		return Operacao;
	}

	
	public static void setOperacao(String operacao) {
		Operacao = operacao;
	}

	
	public static int getAcumulador(boolean contar) {
		if (contar == true) {
			acumulador++;
		}else{
			acumulador = 0;
		} 	
		return acumulador ;
	}
}
