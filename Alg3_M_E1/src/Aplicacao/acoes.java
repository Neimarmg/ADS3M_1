package Aplicacao;

import java.util.Scanner;

import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Estruturas.ListaEncadeada;
import Estruturas.ListaOrdenada;
import Estruturas.Registrador;

public class acoes<T> {
	String comando;
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	Ficheiro f = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	Registrador registra = new Registrador();
	
	
	/**
	 * Metodo global de capatação de comandos do programa
	 * @throws Exception 
	 */
	public void executaComandos() throws Exception{
		i.msgDigitaComando();
		comando = var.next().toLowerCase();
	}
	
	/** 
	 * @throws Exception
	 */
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

	/**	 * 
	 * @throws Exception
	 */
	public void salvaDado() throws Exception{	
		i.menuInsert();		
		executaComandos();
		
		switch (comando) {			
		case "arquivo":	
			i.msg("Nome arquivo: ");
			comando = var.next();
			registra.insereArquivo(comando);
			break;
			
		case "lista":		
			registra.insereLista();
			break;

		case "ambas":		
			i.msg("Nome arquivo: ");
			comando = var.next();
			registra.insereAmbas(comando);			
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
	

	/** 
	 * @throws Exception
	 */
	public void imprime() throws Exception {	
		i.menuImprimir();
		executaComandos();
		
		switch (comando) {		
		
		case "arquivo":
			i.nomeArquivo();
			executaComandos();
			f.imprimeArquivo(comando);
			imprime();
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
	
	/** 
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * @throws Exception
	 */
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
