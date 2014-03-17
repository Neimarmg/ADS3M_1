package Estruturas;

import java.util.Scanner;

import Utilitarios.Formatos;
import Utilitarios.Include;

public class Registrador {
	Scanner var = new Scanner(System.in);
	String desc, fone , nome;
	Formatos f = new Formatos();
	Include i = new Include();
	
	
	
	
	public void digita() throws Exception{
		f.menuInserirNovo();
		f.msgDigitaComando();
		desc = var.next().toLowerCase();
	}
	
	
	public void escreve() throws Exception {
		digita();
		switch (desc) {
		case "novo":
			f.msg("\nNome Contato: ");
			nome =  var.next().toLowerCase();
			f.msg("\nTelefone: ");
			fone = var.next().toLowerCase();
			desc = nome +" " + fone;
			escreve();
			break;
			
		case "sair":
			f.msgSair();
			
		default:
			f.msgOpcaoInvalida();
			digita();
			break;
		}
	}
	
	public  void insereLista() throws Exception{
		escreve();
		ListaOrdenada<String> lista = new ListaOrdenada<String>();		
		lista.insert(new Nodo<String>(desc));
		lista.print();
	}
	
	
	public  void insereArquivo(String arquivo) throws Exception{
		digita();
		i.novoRegistro(arquivo,desc);
	}
	
	
	public  void insereAmbas(String arquivo) throws Exception{
		digita();
		insereLista();
		insereArquivo(arquivo);
	}
}
