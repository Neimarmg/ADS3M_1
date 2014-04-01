package Controller.Utilitarios;

import java.util.Scanner;


public class Prints {	
	Scanner var = new Scanner(System.in);
	
	public void msg(Object desc) {   
		System .out.print(desc);
	}
	
	
	/**
	 * @param desc
	 */
	public void msgb(Object desc) {
		System .out.print(
			"\n====================================================\n"
			+desc
			+"\n====================================================\n");
	}
	
	
	public void msgc(Object desc) {
		System .out.print(
			"\n====================================================\n"
			+desc);
	}


	public void msgr(Object desc) {
		System .out.print(
			desc
			+"\n====================================================\n");
	}	
	

	public void msgl() {
		System .out.print(
			"\n====================================================\n");
	}
	
	
	public void espacoInsuficiente() {
		System .err.print("\nEspa�o insuficiente em disco para inserir dados.\n");
	}
	
	
	public void opcaoInvalida() {
		System .err.println("\nOp��o de comando inv�lido. Tente novamente.");
	}
	
	
	public void objetoNaoImplementado() {
		System .err.print("\nN�o implementado.\n");
	}
	

	/**
	 * M�todo de label dos comandos do sistema
	 * @param label
	 */
	public void paleta(String label) {
		System .out.println();
		if (label.equals("")){
			System .out.print("COMANDO: ");
		}else{
			System .out.print(label +": ");
		}
	}
	
	/**
	 * Valores boleanos
	 * @param label
	 * @return
	 */
	public int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();
	}
	
	/**
	 * M�todo de retorno que recebe a label com par�mento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public String comando(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	public void sair(){
		System.err.print("\nVoc� optou por sair do jogo. Obrigado.");
	}
	
	
	public void mostarMenuMaim() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+"=> JOGAR\n"
		+"=> DEFINIR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}

	public void menuJogar() {		
		msgb("	O QUE VOC� DESEJA FAZER?\n\n"
		+"=> JOGAR\n"
		+"=> DEFINIR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}


}