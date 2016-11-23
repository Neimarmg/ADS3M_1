package Tabuada;

public class Tabuada {
	static int numerador = 0, denominador = 0;	
	static String valorResultado = "";
	
	
	public static void setResult(String result, boolean limparResult) {
		if (limparResult == false){
			valorResultado += result;
		}else{
			valorResultado = "";
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
		default:
				setResult("Operação inválida!",false);	
		}		
	}
		
	
	public static void executaCalculo(String operador){
		denominador++;
		efetuaCalculos(operador);
	}

	
	public static void imprimeResultados(String Operacao){
		if (denominador < 10) {	
			setResult(denominador +" " +Operacao +" " +numerador +" = ", false);	
			executaCalculo(Operacao);
			View.msg("\n"+valorResultado);
			setResult("", true);
			imprimeResultados(Operacao);
		}else{
			numerador++;
			denominador = 0;
		}			
	}
	
	
	public static void carregaParametros(int calcularTabudaAte, String operador){
		if (numerador <= calcularTabudaAte) {
			View.msgcr("\nTabuada do: "+numerador); 
			imprimeResultados(operador);
			carregaParametros(calcularTabudaAte, operador);
		}		
	}
	
	
	public static void main(String[] args) {
		View.msgcr("\nT a b ú a d a\n");
		Tabuada.carregaParametros(
				View.digitaNumero("\nCalcular tabuada até")
				,View.digitaString("\nOperação"));
	}
}