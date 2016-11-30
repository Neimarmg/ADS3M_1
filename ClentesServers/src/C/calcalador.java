package C;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import com.calculos.ServicoCalculo;
import com.calculos.ServicoCalculoServiceLocator;

import M.Resultado;
import V.View;

public class calcalador {	
	private static ServicoCalculo sc;
	
	public static void criaOperacao() throws ServiceException, RemoteException {
		sc = new ServicoCalculoServiceLocator().getservicoCalculo();
		Resultado.setResuldo(sc.getResultado(
				V.View.digitaString("Operação"),
				V.View.digitaFloat("Numerador"),
				V.View.digitaFloat("Denominador")));
		
		
	}
	
	public static void print() {
		View.msgc("Resuldado:"+Resultado.getResuldo());
		
	}
}
