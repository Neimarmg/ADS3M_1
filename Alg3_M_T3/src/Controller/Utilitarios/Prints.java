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
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}
	
	
	public void opcaoInvalida() {
		System .err.println("\nOpção de comando inválido. Tente novamente.");
	}
	
	
	public void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}
	

	/**
	 * Método de label dos comandos do sistema
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
	 * Método de retorno que recebe a label com parâmento e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public String comando(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	public void sair(){
		System.err.print("\nVocê optou por sair do jogo. Obrigado.");
	}
	
	
	public void mostarMenuMaim() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+"=> JOGAR\n"
		+"=> DEFINIR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}

	public void menuJogar() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+"=> JOGAR\n"
		+"=> DEFINIR\n"
		+"=> IMPRIMIR\n"
		+"=> SAIR\n");
	}


}