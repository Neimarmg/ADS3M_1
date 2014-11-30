package ProgsAlgo2.OperacoesBancarias;

import java.util.Set;

public class contaBancaria {
	private int nroConta;
	private int nroVerificao;
	protected float saldoConta;
	
	public void setNroConta(int nroConta) {
		this.nroConta = nroConta;
	}
	
	public void SetDepositar(Float valorDeposito){
		this.saldoConta += valorDeposito;		
	}	
	
	public void setSacar(float valorSaque){			
			this.saldoConta -= valorSaque;
	}
	
	public float getSaldo(){			
		return this.saldoConta;
	}
		
	public void imprimeSaldo(){		
		System.out.println("Nro da conta: " +nroConta +"\nSaldo da conta: "+getSaldo());
	}
}
