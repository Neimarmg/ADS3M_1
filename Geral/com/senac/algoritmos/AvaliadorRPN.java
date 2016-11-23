package com.senac.algoritmos;
import static java.lang.System.out;

import java.util.Scanner;
import com.senac.estruturas.PilhaCheia;
import com.senac.estruturas.PilhaOperandos;
import com.senac.estruturas.PilhaOperadores;
import com.senac.estruturas.PilhaVazia;
  
public class AvaliadorRPN {
      
    public static double avalia (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
    {   
        PilhaOperandos pilha = new PilhaOperandos(10);
          
        Scanner sc = new Scanner(expressao);
        out.print("Passo a passo!\n\n");  
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                pilha.push(sc.nextInt());
            } else {
                String op = sc.next();
                double rhs = pilha.pop();
                double lhs = pilha.pop();
                  
                double temp = executaOperador(op.charAt(0), lhs, rhs);                  
                  
                System.out.println(rhs + " " + op + " " + lhs + " = " + temp);
                
                pilha.push(temp);
            }
        }
        out.print("---------------------------------\n"+
        "Resultado : ");
        return pilha.pop();
    }
  
    private static double executaOperador(char op, double lhs, double rhs) throws InvalidOperator
    
    {
        switch (op) {
            case '+': return lhs + rhs;
            case '-': return lhs - rhs;
            case '*': return lhs * rhs; 
            case '/': return lhs / rhs;
            default: throw new InvalidOperator(op);
        }
    } 
} 