package com.calculadora.aplicacao.App;

import java.rmi.RemoteException;
import javax.security.sasl.SaslException;
import javax.xml.rpc.ServiceException;

import com.calculadora.aplicacao.C.parametrizador;
import com.calculadora.aplicacao.V.View;

public class Start {
	
	public static void main(String args[]) throws SaslException, RemoteException, ServiceException {
		View.msgl();
		parametrizador.criaOperacao();
		parametrizador.print();
		
	}
}
