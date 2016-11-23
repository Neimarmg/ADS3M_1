package com.senac.planilha;

import java.beans.Expression;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Scanner;
import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidOperator;
import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidToken;
import com.senac.estruturas.Nodes;
import com.senac.estruturas.ListaDE;
import com.senac.estruturas.Nodes;

public class Planilha {
	
	String formula, calcFormula, valCelula;	
	
	Scanner sc = new Scanner(System.in);
	
	ListaDE lista = new ListaDE();

	public void inicio(String v) throws Exception
	{		
		lista.addInicio(new Nodes(v, null, null));
	}

	public void cauda(String v) throws Exception
	{
		lista.addFim(new Nodes(v, null, null));
	}
	
	public void remove(String r) throws Exception
	{
		lista.Remover(new Nodes(r, null, null));
	}
	
	public void imprime() throws Exception
	{
		System.out.println("Impressão da lista \n"  +lista.toString());
	}
	
	public String celula() throws Exception
	{		
		return calcFormula = lista.bucaInfo();		
	}
	
	public void busca() throws Exception
	{		
		System.out.println(getFormula());
	}
	
	public void setFormula(String formula) 
	{
		this.formula = formula;
	}
	
	public String getFormula() 
	{
		return this.formula;
	}
	
	public void setValCelula(String valCelula) 
	{
		this.valCelula = valCelula;
	}
	
	public String getValCelula() 
	{
		return valCelula;
	}
	
	public void comando(String comando) throws Exception
	{		
		String com = comando.toLowerCase();
		switch (com) {
		
		case "inicio" : 
			System.out.print("Digita formula: ");
			setFormula(sc.next());
			inicio(getFormula());
			break;
			
		case "cauda" : 
			System.out.print("Digita formula: ");
			setFormula(sc.next());
			cauda(getFormula());			
			break;
			
		case "remove" : 
			System.out.print("Digita a formula a ser removida: ");
			setFormula(sc.next());
			remove(getFormula());			
			break;
			
		case "imprime" : imprime();			
			break;
			
		case "busca" : 
			if (!getValCelula().equals(" ")) {
				busca();
			}			
			break;
			
		case "celula" : 			
			System.out.print("Valor para consulta: ");
			setValCelula(sc.next());						
			break;
			
		case "resultado" : resultado();			
		break;
			
		case "fim" : break;
			
		default: 
			throw new Exception("\nComando invalido.");
		}
	}	
	
	public void resultado() throws Exception 
	{
		String postfix = AvaliadorExpressao.convertInfixToPostfix(getFormula());			
		double result = AvaliadorExpressao.evaluateRPN( postfix );				
		
		String acum = "";  
		acum = acum +formula;
		System.out.println("Exp: " +acum);
		System.out.println("Resultado: " + result);	
	}
	
	public void criaExpressao() throws Exception 
	{
		try {			
			System.out.print("Comando para iniciar: ");
			while (sc.hasNext()){							
				comando(sc.next());
				
				System.out.print(
				"================================"
				+"\nNovo comando: ");				
				}			
		} 
		catch (NullPointerException e) {
			System.err.println("\nO Fim da execução do programa!");
		}
		catch (Exception e) {
			System.err.println("\nO Valor inválido!");
		} 
	}
	
	public void printComandos()
	{
		System.out.println("COMANDOS DE EXECUÇÃO:"
		+"\n================================"
		+"\n=> INICIO = Iserir na lista"
		+"\n=> CAUDA = Iserir no fim da lista"
		+"\n=> REMOVE = Remover elemento da lista"
		+"\n=> IMPRIME = Imprime lista"
		+"\n=> CALCULA = calcula expressão"
		+"\n=> CELULA = Celula a ser pesquisada"
		+"\n  => BUSCA = Imprime celula pesquisada"
		+"\n=> FIM = Termina programa"
		+"\n================================");		
	}
	
	public static void main(String[] args) throws Exception 
	{
		(new Planilha()).run();			
	}
	
	private void run() throws Exception 
	{
		printComandos();
		criaExpressao();
	}

}
