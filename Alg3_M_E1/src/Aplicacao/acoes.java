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
	public void leComandos() throws Exception{
		i.msgDigitaComando();
		comando = var.next().toLowerCase();
	}
	
	/** 
	 * @throws Exception
	 */
	public void consulta() throws Exception{	
		i.menuConsultas();
		leComandos();
		
		switch (comando) {
		
		case "lista":
			i.msgNaoImplementado();
			consulta();
			break;
			
		case "arquivo":
			i.msgNaoImplementado();
			consulta();
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
	public void salva() throws Exception{	
		i.menuInsert();		
		leComandos();
		
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
			salva();
			break;
		}			
	}	
	

	/** 
	 * @throws Exception
	 */
	public void imprime() throws Exception {	
		i.menuImprimir();
		leComandos();
		
		switch (comando) {		
		
		case "arquivo":
			i.nomeArquivo();
			leComandos();
			f.imprimeDados(comando);
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
	public void manipulaAquivo() throws Exception {	
		i.menuArquivo();
		leComandos();
		
		switch (comando) {
			
		case "buscar":
			i.nomeArquivo();			
			leComandos();
			f.buscaExistente(comando);
			manipulaAquivo();
			break;
		
		case "novo":
			i.nomeArquivo();
			leComandos();
			f.criaNovo(comando);
			manipulaAquivo();
			break;
		
		case "remover":
			i.nomeArquivo();
			leComandos();
			f.removeArquivo(comando);
			manipulaAquivo();
			break;
		
		case "sair":
			i.msgSair();
			break;
			
		default:
			i.msgOpcaoInvalida();
			manipulaAquivo();
			break;
		}		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception{
		leComandos();
			
		switch (comando) {
		
		case "consultar":
			i.msgNaoImplementado();
			break;
			
		case "inserir":
			salva();
			break;
			
		case "imprimir":
			imprime();
			break;
			
		case "arquivo":
			manipulaAquivo();
			break;
		
		case "sair":
			i.msgSair();
			break;
			
		default: 
			i.msgOpcaoInvalida();
			iniciaTarefas();
			break;
		}
	}
}
