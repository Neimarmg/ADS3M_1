package com.senac.estruturas;

public class TerminaExpressão{
	private String conv;	
	int cont = 0;
	public TerminaExpressão(String carater){
        this.conv = carater; 
	}
	
	public void setConv(String conv) {
		this.conv = conv.toUpperCase();
		cont++;
	}
	
	public int getCont() {
		return cont;
	}
	
	public boolean getFimExpressao(){
		if (conv.equals("FIM")){
			return false;		
		}return true;		
	}
	
	public void printFimExpressao(){
		if (!getFimExpressao()){
			System.out.println("Fim da Expressão");
		}		
	}
}
