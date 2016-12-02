package com.calculadora.aplicacao.C;

import java.rmi.RemoteException;
import java.util.InputMismatchException;

import javax.xml.rpc.ServiceException;
import com.calculadora.CalculoWebService;
import com.calculadora.CalculoWebServiceServiceLocator;
import com.calculadora.aplicacao.M.Resultado;
import com.calculadora.aplicacao.V.View;

public class parametrizador {	
	private static CalculoWebService sc;
	
	
	public static void criaOperacao() throws ServiceException, RemoteException {		
		try {
			
			sc = new CalculoWebServiceServiceLocator().getCalculoWebService();
			Resultado.setResuldo(sc.getResultado(
					View.digitaString("Operação"),
					View.digitaFloat("Numerador"),
					View.digitaFloat("Denominador")));
		
		} catch (RemoteException e) {
			e.printStackTrace();
		
		}catch (InputMismatchException e) {
			View.msge("Valor inválido!");
		}	
	}
	
	
	public static void print() {
		View.msgc("Resultado:"+Resultado.getResuldo());
		
	}
}
