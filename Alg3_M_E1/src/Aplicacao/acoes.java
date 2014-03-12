package Aplicacao;
import java.util.Scanner;
import Estruturas.ListaOrdenada;

public class acoes {
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	ListaOrdenada r = new ListaOrdenada<>();
	
	
	private void InsereDado() {
		r.insereRegistro(var.next());
	}
	
	
	private void cadastra() {
		i.msg("Nome Contato: ");
		InsereDado();
		i.msg("Telefone: ");
		InsereDado();
		i.msg("celeular: ");
		InsereDado();
	}	
	
	/**
	 * Metodo de seleção de comandos do programa.	
	 * @param comando
	 */
	private void SelecionaComandos(String comando) {
		String c = comando.toLowerCase();
	
		switch (c) {
		
		case "consultar":
			
			break;
			
		case "cadastrar":
			cadastra();
			break;
			
		case "imprimir":
			
			break;
		default: 
			i.msg("Comando inválido \nTente novamente?:");
			ExecutaComandos();
			break;
		}
	}
	
		
	/**--------------------------------------------------------- 
	 * Metodo inicia a execução de todos os comandos da aplicação	
	*/
	public void ExecutaMenu() {
		i.msgb("Ola!!! \n\nO que voce deseja fazer?:\n\n"
		+"=> Cadastrar\n"
		+"=> Consultar\n"
		+"=> Imprimir");
	}
	
	
	public void ExecutaComandos() {		
		i.msg("\nComando: ");
		SelecionaComandos(var.next());
	}
}
