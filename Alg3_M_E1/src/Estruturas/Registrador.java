package Estruturas;

import java.util.Scanner;

import Arquivos.Ficheiro;
import Utilitarios.Formatos;
import Utilitarios.Include;

public class Registrador {

	String desc, fone , nome;
	Formatos f = new Formatos();
	Ficheiro a =  new Ficheiro();
	Include i = new Include();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	public void insereDados() throws Exception {
		nome =  f.comando("Contato");
		fone = 	f.comando("Telefone");
		desc = nome +" " + fone;
	}
	
	
	public  void insereLista() throws Exception {
		f.menuInserirNovo();
		
		switch (f.comando("")) {
		
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
			f.sair();
			break;
		
		default:
			f.opcaoInvalida();
			insereLista();
			break;
		}	
	}
	
	
	public  void insereArquivo(String arquivo) throws Exception {

		f.menuInserirNovo();
		
		switch (f.comando("")) {
		
		case "novo":
			insereDados();
			i.addNovo(arquivo,nome);
			i.addNovo(arquivo,fone);
			insereArquivo(arquivo);
			break;
			
		case "imprimir":
			f.msgl();
			f.msg("Dados em aquivo: \n");
			a.imprime(arquivo);
			insereArquivo(arquivo);
			break;
			
		case "excluir":
			desc =  f.comando("\nNome Contato a excluir");
			i.exclui(arquivo, desc);
		case "sair":
			f.sair();
			break;
		
		default:
			f.opcaoInvalida();
			insereArquivo(arquivo);
			break;
		}
	}
	
	
	public  void insereAmbas(String arquivo) throws Exception {
		//executaComando();
		f.menuInserirNovo();
		
		switch (f.comando("")) {
		case "novo":
			insereDados();
			lista.insert(new Nodo<String>(nome));
			lista.insert(new Nodo<String>(fone), lista.getHead());
			i.addNovo(arquivo,desc);
			insereAmbas(arquivo);
			break;
		
		case "imprimir":
			f.msgl();
			f.msg("Dados em lista: ");
			lista.print();
			f.msgl();
			f.msg("Dados em aquivo: ");
			a.imprime(arquivo);
			insereAmbas(arquivo);
			break;
			
		case "sair":
			f.sair();
			break;
		
		default:
			f.opcaoInvalida();
			insereAmbas(arquivo);
			break;
		}
	}
}