package C;
import M.Dados;
import M.Operador;
import W.View;

public class Controlador {
	
	public static void carregaOperacao(){
		Operador.setOperacao(View.digitaString("Operação: "));
	}
	
	
	public static void carregaValores(){
		if (Operador.getOperacao().equals(".")) {
			Dados.setNumerador(View.digitaFloat("Numerador: "));
			carregaOperacao();
		}	
		Dados.setDenominador(View.digitaFloat("Denominador: "));
	}
	
	
	public static void carregaDados(){
		if (!Operador.getOperacao().equals("=")){
			carregaValores();
			Calculador.imprimeCalculo();
			carregaOperacao();
			Calculador.limparValores();
			carregaDados();
		}
	}
	
	
	public static void executaCalculadora(){
		Operador.setOperacao(".");
		carregaDados();
		Calculador.imprimeCalculo();
	}
}
