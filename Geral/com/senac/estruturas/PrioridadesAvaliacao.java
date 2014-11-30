package com.senac.estruturas;
import com.senac.algoritmos.InvalidOperator;

public class PrioridadesAvaliacao{
	private String cararter;	

	public PrioridadesAvaliacao(String carater)	{
        this.cararter = carater.toUpperCase(); 
	}
	
	public void setExpressao(String cararter)throws Exception	{
		this.cararter = cararter;
	}	
	public String getCararter() {
		return cararter;
	}	
}
