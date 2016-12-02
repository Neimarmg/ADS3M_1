package com.calculadora.aplicacao.App;

import java.net.ConnectException;
import java.rmi.RemoteException;
import javax.security.sasl.SaslException;
import javax.xml.rpc.ServiceException;
import com.calculadora.aplicacao.C.parametrizador;
import com.calculadora.aplicacao.V.View;

public class Start {
	
	public static void main(String args[]) throws SaslException, ConnectException {
		try {
			
			View.msgcr("CALCULADORA FINANCEIRA");
			parametrizador.criaOperacao();
			
			parametrizador.print();
		
		}catch (RemoteException e) {
			View.msg("Serviço remoto não encontrado!");
			View.sair();
		}catch (ServiceException e) {
			View.msg("Serviço não iniciado!");
			View.sair();
		}		
	}
}
