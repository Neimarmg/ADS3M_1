package com.senac;

import java.util.Scanner;
import com.*;
import com.senac.algoritmos.*;
import com.senac.estruturas.*;
import static java.lang.System.*;
public class Planilha {	

	public static void main(String[] args) throws Exception {
		String valorExpr = "";	
		
		Scanner var = new Scanner(System.in);		
					
		TerminaExpressão fimEpressao = new TerminaExpressão("Inicio"); 
		PilhaOperadores operadores = new PilhaOperadores(10);
		PilhaOperandos operandos = new PilhaOperandos(10);
		PrioridadesAvaliacao prioridades = new PrioridadesAvaliacao("Inicio");
		
		out.println("Expressão: 20 * ( 5 + 4 ) fim ");					
		while(fimEpressao.getFimExpressao())
		{			
			valorExpr = var.next();
			fimEpressao.setConv(valorExpr);
			
			if (fimEpressao.getFimExpressao()) {				
				
				if ((valorExpr.equals("+")) || (valorExpr.equals("-")) ||(valorExpr.equals("*")) || (valorExpr.equals("/")) || (valorExpr.equals("(")) || (valorExpr.equals(")"))){					
					operadores.push(valorExpr);						
				
				}else{					
					double b = (double) Integer.parseInt(valorExpr);
					operandos.push(b);
				}
			}		
		}	
		fimEpressao.printFimExpressao();
		out.println("=================================");
		
		String s1, s2, expr;
		double nro1, nro2,nro3;	
		
		nro1 = operandos.pop();
		int n1 = (int)nro1; 
		nro2 = operandos.pop();
		int n2 = (int)nro2; 
		operadores.pop();
		s1 = operadores.pop();
		nro3 = operandos.pop();
		int n3 = (int)nro3; 
		operadores.pop();
		s2 = operadores.pop();
		
		expr = n1 +" " +n2 +" " +s1 +" " +n3 +" " +s2 +" "; 

		out.println("Expressão. NPR: " +expr);
		out.println("=================================");
		out.println(AvaliadorRPN.avalia(expr) );	
		out.println("=================================");
	}
}