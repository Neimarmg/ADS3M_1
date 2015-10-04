
public class Taboada {
	static int numerador = 0, denominador = 0;	
	static String resultado = "";
	
	
	public static void setResult(String result, boolean limparResult) {
		if (limparResult == false){
			resultado += result;
		}else{
			resultado = "";
		}
	}


	public static void efetuaCalculos(String operador){

		switch (operador) {	
		case "*":
			setResult("" +(denominador * numerador), false);
			break;
		
		case "/":
			if (numerador > 0){
				setResult("" +(denominador / numerador), false);
			}else{
				setResult("0", false);
			}
			break;

		case "-":
			setResult("" +(denominador - numerador), false);			
			break;

		case "+":
			setResult("" +(denominador + numerador), false);			
			break;
		}
		
	}
		
	
	public static void executaCalculo(String operador){
		denominador++;
		efetuaCalculos(operador);
	}

	
	public static void imprimeResultados(String operador){
		if (denominador < 10) {	
			setResult(denominador +" " +operador +" " +numerador +" = ", false);	
			executaCalculo(operador);
			System.out.println(resultado);
			setResult("", true);
			imprimeResultados(operador);
		}else{
			numerador++;
			denominador = 0;
		}			
	}
	
	
	public static void carregaParametros(int tabAte, String operador){
		if (numerador < tabAte) {
			System.out.println("\nTaboada do: "+numerador); 
			imprimeResultados(operador);
			carregaParametros(tabAte, operador);
		}		
	}
	
	
	public static void main(String[] args) {
		System.out.println("\nExecução de taboada\n");
		Taboada.carregaParametros(20, "+");
	}
}