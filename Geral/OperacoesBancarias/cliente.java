package ProgsAlgo2.OperacoesBancarias;

public class cliente {
	private String nomeCliente;
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void imprCliente(){
		System.out.println("Nome do cliente: " +this.nomeCliente );
	}
}
