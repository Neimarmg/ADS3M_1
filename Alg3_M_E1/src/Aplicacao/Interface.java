package Aplicacao;

import java.util.Scanner;
import Navegacao.Consultas;
import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Estruturas.ListaEncadeada;
import Estruturas.Registrador;

public class Interface<T> {
	String comando;
	Scanner var = new Scanner(System.in);
	Formatos i = new Formatos();
	Ficheiro f = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	Registrador registra = new Registrador();
	Consultas c = new Consultas();
	

	/** 
	 * @throws Exception
	 */
	public void consulta() throws Exception{	
		i.menuConsultas();
		
		switch (i.comando("")) {
		
		case "lista":
			i.naoImplementado();
			consulta();
			break;
			
		case "arquivo":
			c.carrega();
			break;
			
		case "sair":
			i.sair();
			break;
			
		default:
			i.opcaoInvalida();
			consulta();
			break;
		}
		
	}

	/**	 * 
	 * @throws Exception
	 */
	public void salva() throws Exception{	
		i.menuInsert();		
		
		switch (i.comando("")) {			
		case "arquivo":	
			registra.insereArquivo(i.comando("Nome arquivo"));
			break;
			
		case "lista":		
			registra.insereLista();
			break;

		case "ambas":		
			registra.insereAmbas(i.comando("Nome arquivo"));			
			break;
			
		case "sair":
			i.sair();
			break;
			
		default:
			i.opcaoInvalida();
			salva();
			break;
		}			
	}	
	

	/** 
	 * @throws Exception
	 */
	public void imprime() throws Exception {	
		i.menuImprimir();
		
		switch (i.comando("")) {		
		
		case "arquivo":
			f.imprime(i.comando("Nome arquivo"));
			imprime();
			break;

		case "sair":
			i.sair();
			break;
			
		default:
			i.opcaoInvalida();
			imprime();
			break;
		}		
	}
	
	/** 
	 * @throws Exception
	 */
	public void manipulaAquivo() throws Exception {	
		i.menuArquivo();
		
		switch (i.comando("")) {
			
		case "buscar":
			f.buscaExistente(i.comando("Nome arquivo"));
			manipulaAquivo();
			break;
		
		case "novo":
			f.criaNovo(i.comando("Nome arquivo"));
			manipulaAquivo();
			break;
		
		case "remover":
			f.remove(i.comando("Nome arquivo"));
			manipulaAquivo();
			break;
		
		case "sair":
			i.sair();
			break;
			
		default:
			i.opcaoInvalida();
			manipulaAquivo();
			break;
		}		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception{
			
		switch (i.comando("")) {
		
		case "consultar":
			consulta();
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
			i.sair();
			break;
			
		default: 
			i.opcaoInvalida();
			iniciaTarefas();
			break;
		}
	}
}
