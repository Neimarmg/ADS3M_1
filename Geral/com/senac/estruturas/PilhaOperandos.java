package com.senac.estruturas;

public class PilhaOperandos {

	private double[] dados;
	private int   topo;
	
	public PilhaOperandos (int tam)
	{
		dados = new double[tam];
		topo = 0;
	}

	public double peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public void push (double valor) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = valor;
		topo++;
	}
	
	public double pop () throws PilhaVazia
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
	
	public double top(){
		if(this.isEmpty()){			
			return 0;
		}
		topo--;
		return this.dados[this.topo];
		
	}
		
	public void printOperando(){
        for (int i = 0; i < dados.length; i++) 
        {
        	if(dados.length != 0 ){
        		System.out.println("p" +i +" :Operandos " +dados[i]);        
        	}
        }
	}
}
