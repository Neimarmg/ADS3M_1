package M;

public class Operadores {
	static String Operacao;
 	static int acum = 0;

	public static String getOperacao() {
		return Operacao;
	}

	public static void setOperacao(String operacao) {
		Operacao = operacao;
	}
	
	public static int getAcum(boolean contar) {
		if (contar == true) {
			acum++;
		}else{
			acum = 0;
		} 	
		return acum ;
	}
}
