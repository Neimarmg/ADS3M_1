package com.app;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import com.calculos.ServicoCalculo;
import com.calculos.ServicoCalculoServiceLocator;

public class app {
	public static String appcalculos() throws ServiceException, RemoteException{
		ServicoCalculo sc = new ServicoCalculoServiceLocator().getservicoCalculo();
		 
		return sc.getResultado("*", 10, 10);
	}
	
	public static void main(String args[]) {
		try {

			System.out.println("Resultado:"+appcalculos());
		
		} catch (RemoteException | ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
