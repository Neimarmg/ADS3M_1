package com.senac.jogos.labirinto;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class interfacePrincipal {
	 private static final Scanner sc = new Scanner(System.in);
     
	 public static final int labirinto = 0;
	 public static final int jogar = 1;
	 public static final int fim = 2;
	  
	 Labirinto lab = new Labirinto();
	 String  teclado;       
	 int valCase;
	    
	public void imprimeCabecalhoDoJogo()
	{
		System.out.println(
			"\n<<< JOGO LABIRINTO STILO ADVENTURE >>>\n"
	        +"\n===================================="
	        +"\n=> LABIRINTO = 'Imprime o labirinto na tela'"
	        +"\n=> JOGAR = 'Inicia o jogo'"
	        +"\n------------------------------------");
	}
    
   
	private void run() 
	{
		try {	
			imprimeCabecalhoDoJogo();
			do{			
				System.out.print("COMANDO:");
				teclado = sc.next();
				chamaComando(converteComando(teclado));
			
			}while(converteComando(teclado) != -1);
			System.err.print("Vecê digitou um comando invalido que encerrou o jogo!");
			
		} catch (NoSuchElementException e) {
			System.out.print("Comando invalido fim de jogo!:");
		}	
	}     
	
	
	public int converteComando(String c)
	{      
		try {          
			String executa = c.toLowerCase();
	        if (executa.equals("labirinto")){
	        	return 0;
	        }
	        if(executa.equals("jogar")){
	        	return 1;
	        }     
	        if (executa.equals("fim")){
	            return 2;                  
	        }
	        
	   } catch (NullPointerException e) {
	            System.err.print("Comando invalido!");
	   }
	   return -1;
	}  
	
	
	public void chamaComando( int c)
	{
		valCase = c;
	    switch (valCase) {
	    case 0 :
	     	lab.inicializaLabirinto();
	        lab.imprimeLabirinto();
	        break;         
	             
	    case 1 :
	    	System.err.print("Jogo inciado!");
	      	lab.iniciaJogo();	        
	        break;         
	         
	    case 2 :
	      	System.err.println("Você sai do jogo! ");
	      	//teclado = "0";  
	    }
	}
	
	
	public static void main(String[] args) 
	{
		(new interfacePrincipal()).run();
	}
}
