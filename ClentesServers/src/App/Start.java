package App;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import C.calcalador;
import V.View;

public class Start {
	public static void main(String args[]){
		try {
			View.msgl();
			calcalador.criaOperacao();
			calcalador.print();
		} catch (RemoteException | ServiceException e) {
			e.printStackTrace();
		}
	}
}
