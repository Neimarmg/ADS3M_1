package Aplicacao;

import java.util.Scanner;

import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Estruturas.ListaOrdenada;

public class acoes {
	String comando;
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	ListaOrdenada r = new ListaOrdenada<>();
	Ficheiro f = new Ficheiro();
	
	
	public void executaComandos(){	
		i.msgDigitaComando();
		comando = var.next().toLowerCase();
	}
	
	
	public void consulta() throws Exception{	
		i.menuConsultas();
		executaComandos();
		
		switch (comando) {
		
		case "lista":
			i.msgNaoImplementado();
			break;
			
		case "arquivo":
			i.msgNaoImplementado();
			break;
			
		case "sair":
			i.msgSair();
			break;
			
		default:
			i.msgOpcaoInvalida();
			consulta();
			break;
		}
		
	}

	
	public void salvaDado() throws Exception{	
		i.menuInsert();		
		executaComandos();
		
		switch (comando) {
			
		case "arquivo":		
			String nomeAquivo = "lt.txt"; 
			r.insereRegistro(nomeAquivo);
			break;
			
		case "lista":		
			i.msgNaoImplementado();
			break;

		case "ambos":		
			i.msgNaoImplementado();
			break;
			
		case "sair":
			i.msgSair();
			break;
			
		default:
			i.msgOpcaoInvalida();
			salvaDado();
			break;
		}
			
	}	

	
	public void imprime() throws Exception {	
		i.menuImprimir();
		executaComandos();
		
		switch (comando) {		
		
		case "arquivo":
			i.nomeArquivo();
			executaComandos();
			f.imprimeArquivo(comando);
			break;
		
		case "":
			
			break;

		case "sair":
			i.msgSair();
			break;
			
		default:
			i.msgOpcaoInvalida();
			imprime();
			break;
		}		
	}
	
	
	public void ExecutaAquivo() throws Exception {	
		i.menuArquivo();
		executaComandos();
		
		switch (comando) {
			
		case "buscar":
			i.nomeArquivo();			
			executaComandos();
			f.buscaArquivoExistente(comando);
			break;
		
		case "novo":
			i.nomeArquivo();
			executaComandos();
			f.criaNovoArquivo(comando);
			break;
		
		case "remover":
			i.nomeArquivo();
			executaComandos();
			f.removeArquivo(comando);
			break;
		
		case "sair":
			i.msgSair();
			break;
			
		default:
			i.msgOpcaoInvalida();
			ExecutaAquivo();
			break;
		}		
	}
	
	
	public void menuPricipal() throws Exception{
		executaComandos();
			
		switch (comando) {
		
		case "consultar":
			i.msgNaoImplementado();
			break;
			
		case "inserir":
			salvaDado();
			break;
			
		case "imprimir":
			imprime();
			break;
			
		case "arquivo":
			ExecutaAquivo();
			break;
		
		case "sair":
			i.msgSair();
			break;
			
		default: 
			i.msgOpcaoInvalida();
			menuPricipal();
			break;
		}
	}
}
