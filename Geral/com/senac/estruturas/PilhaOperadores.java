package com.senac.estruturas;

public class PilhaOperadores {

	private String [] dados;
	private int   topo;
	
	public PilhaOperadores (int tam)
	{
		dados = new String[tam];
		topo = 0;
	}

	public String peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public void push (String valor) throws PilhaCheia //Empilha
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = valor;
		topo++;
	}
	
	public String pop () throws PilhaVazia //desempilha
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		topo--;
		return dados[topo];
	}
	
	private boolean isFull() {
		return topo == dados.length;
	}

	private boolean isEmpty() {
		return topo == 0;
	}
	
	public String top(){
		if(this.isEmpty()){			
			return null;
		}
		topo--;
		return this.dados[this.topo];
				
	}
	
	public void printOperadores(){
        for (int i = 0 ; i < dados.length; i++) 
        {
        	if(dados.length != 0){
        		System.out.println("p" +i +" :Operadores " +dados[i]);        
        	}
        }
	}
}

