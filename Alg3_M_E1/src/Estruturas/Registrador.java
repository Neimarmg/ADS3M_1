package Estruturas;

import java.util.Scanner;

import Arquivos.Ficheiro;
import Utilitarios.Formatos;
import Utilitarios.Include;

public class Registrador {
	Scanner var = new Scanner(System.in);
	String desc, fone , nome;
	Formatos f = new Formatos();
	Ficheiro a =  new Ficheiro();
	Include i = new Include();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	
	public void executaComando() throws Exception{
		f.menuInserirNovo();
		f.msgDigitaComando();
		desc = var.next().toLowerCase();	
	}
	
	
	public void insereDados() throws Exception{
		f.msg("\nNome Contato: ");
		nome =  var.next().toUpperCase();
		f.msg("Telefone: ");
		fone = var.next().toUpperCase();
		desc = nome +" " + fone;
	}
	
	
	public  void insereLista() throws Exception{
		executaComando();
		
		switch (desc) {
		case "novo":
			insereDados();
			lista.insert(new Nodo<String>(nome));
			lista.insert(new Nodo<String>(fone), lista.getHead());
			insereLista();
			break;
		
		case "imprimir":
			lista.print();
			insereLista();
			break;
		
		case "sair":
			f.msgSair();
			break;
		
		default:
			f.msgOpcaoInvalida();
			insereLista();
			break;
		}	
	}
	
	
	public  void insereArquivo(String arquivo) throws Exception{
		executaComando();
		
		switch (desc) {
		case "novo":
			insereDados();
			i.novoRegistro(arquivo,desc);
			insereArquivo(arquivo);
			break;
			
		case "imprimir":
			f.msgl();
			f.msg("Dados em aquivo: \n");
			a.imprimeArquivo(arquivo);
			insereArquivo(arquivo);
			break;
			
		case "excluir":
			f.msg("\nNome Contato a excluir: ");
			desc =  var.next().toUpperCase();
			i.removeRegistro(arquivo, desc);
		case "sair":
			f.msgSair();
			break;
		
		default:
			f.msgOpcaoInvalida();
			insereArquivo(arquivo);
			break;
		}
	}
	
	
	public  void insereAmbas(String arquivo) throws Exception{
		executaComando();
		
		switch (desc) {
		case "novo":
			insereDados();
			lista.insert(new Nodo<String>(nome));
			lista.insert(new Nodo<String>(fone), lista.getHead());
			i.novoRegistro(arquivo,desc);
			insereAmbas(arquivo);
			break;
		
		case "imprimir":
			f.msgl();
			f.msg("Dados em lista: ");
			lista.print();
			f.msgl();
			f.msg("Dados em aquivo: ");
			a.imprimeArquivo(arquivo);
			insereAmbas(arquivo);
			break;
			
		case "sair":
			f.msgSair();
			break;
		
		default:
			f.msgOpcaoInvalida();
			insereAmbas(arquivo);
			break;
		}
	}
}