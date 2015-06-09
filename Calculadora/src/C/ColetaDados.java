package C;
import java.util.Scanner;

import M.Dados;
import M.Operadores;

public class ColetaDados {
	static Scanner var = new Scanner(System.in);
	
	private static void print(String texto){
		System.out.print(texto +" : ");	
	}
	
	public static void operacao(){
		print("\nOparação");
		Operadores.setOperacao(var.next());
	}
	
	
	public static void digita(){
		if (Operadores.getOperacao().equals(".")) {
			print("\nNumerador");
			Dados.setNumerador(var.nextFloat());
			operacao();
		}	
		print("\nDenominador");
		Dados.setDenominador(var.nextFloat());
	}
	
	
	public static void carregaDados(){
		if (!Operadores.getOperacao().equals("=")){
			digita();
			Calculos.imprimeCalculo();
			operacao();
			Calculos.limparValores();
			carregaDados();
		}
		
		
	}
	
	
	public static void executaCalculadora(){
		Operadores.setOperacao(".");
		carregaDados();
		Calculos.imprimeCalculo();
	}
}
