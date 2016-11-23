package GitHub.lab2_5m.OperacoesBancarias;
import java.util.Scanner;

public class bancoInterface {
	public static void main(String[] args) {
		String opc, conv;
		/* Conta inserir 
		 * Consulta saldo 
		 * Consulta saque 
		 * conta Deposisto
		 * Conta limite
		 * 
		 */
		Scanner var = new Scanner(System.in);
		System.out.print("Oque fazer:");
		opc = var.next();
		conv = opc.toUpperCase();
		
		cliente dados = new cliente();		
		contaBancaria conta = new contaBancaria();
		contaEspecial contaEsp = new contaEspecial();
		
		do {	
			System.out.print("===========================\n");
			
			if (conv.equals("INSERIR")){
				System.out.print("\nNome do Cliente: ");
				dados.setNomeCliente(var.next());
				
				System.out.print("Nro conta: ");
				conta.setNroConta(var.nextInt());
				
				System.out.print("Saldo inicial: ");
				conta.SetDepositar(var.nextFloat());
				
				System.out.print("Limite da conta: ");
				contaEsp.setLimiteConta(var.nextFloat());
			
			}
			//System.out.print("\n===========================\n");
			
			if (conv.equals("SALDO")){
				dados.imprCliente();
				conta.imprimeSaldo();
			}
			
			if (conv.equals("SAQUE")){
				System.out.print("\nValor do saque: ");
				conta.setSacar(var.nextFloat());
			}
			
			if (conv.equals("DEPOSITO")){
				System.out.print("\nValor deposito: ");
				conta.SetDepositar(var.nextFloat());
			}
			
			if (conv.equals("LIMITE")){
				System.out.print("\nValor deposito: ");
				conta.SetDepositar(var.nextFloat());
			}	
			
			
			System.out.print("\n===========================\n");
			System.out.print("Sair ou Continuar:");
			opc = var.next();
			conv = opc.toUpperCase();
			
		}while(!conv.equals("SAIR"));
		System.out.print("===========================\n"+"\nVocê saiu da conta:");
	}
}
