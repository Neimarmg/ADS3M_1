package Aplicacao;

import Navegacao.Consultas;
import Utilitarios.Formatos;
import Arquivos.Ficheiro;
import Arquivos.Memoria;
import Estruturas.ListaEncadeada;
import Estruturas.Registrador;

public class Interface<T> extends Formatos {
	
	String comando;
	Formatos i = new Formatos();
	Ficheiro f = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	Registrador registra = new Registrador();
	Consultas c = new Consultas();
	Memoria m =  new Memoria();

	/** 
	 * @throws Exception
	 */
	public void consulta() throws Exception {	
		menuConsultas();
		
			switch (comando("")) {
			
			case "lista":
				objetoNaoImplementado();
				consulta();
				break;
				
			case "arquivo":
				c.carrega();
				break;
				
			case "sair":
				sair();
				break;
				
			default:
				opcaoInvalida();
				consulta();
				break;
			}
		
	}

	/**
	 * @throws Exception
	 */
	public void salva() throws Exception {	
		menuInsert();		
		
			
			switch (comando("")) {			
			case "arquivo":	
				registra.insereArquivo(comando("Nome do arquivo"));
				break;
				
			case "lista":		
				registra.insereLista();
				break;
	
			case "ambos":		
				registra.insereAmbas(comando("Nome do arquivo"));			
				break;
				
			case "sair":
				sair();
				break;
				
			default:
				opcaoInvalida();
				salva();
				break;
			}		
	
	}	
	

	/** 
	 * @throws Exception
	 */
	public void imprime() throws Exception {	
		menuImprimir();
		
		switch (comando("")) {		
		
		case "arquivo":
			f.imprime(comando("Nome do arquivo"));
			imprime();
			break;

		case "sair":
			sair();
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
		menuArquivo();
		
		switch (comando("")) {
			
		case "buscar":
			f.buscaExistente(comando("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "novo":
			f.criaNovo(comando("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "remover":
			f.remove(comando("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "sair":
			sair();
			break;
			
		default:
			opcaoInvalida();
			manipulaAquivo();
			break;
		}		
	}
	
	/**
	 * @throws Exception
	 */
	public void iniciaTarefas() throws Exception {
			
		switch (comando("")) {
		
		case "consultar":	
			consulta();				
			break;
			
		case "inserir":
			msg("\nVerificando disco...\n");
			if (m.calculaDisponivel() > 60000){ // Verifica memória ao inserir dados.
			salva();
			}else{
				espacoInsuficiente();
				m.imprime();
			}
			break;
			
		case "imprimir":
			imprime();
			break;
			
		case "arquivo":
			manipulaAquivo();
			break;
		
		case "sair":
			sair();
			break;
			
		default: 
			opcaoInvalida();
			iniciaTarefas();
			break;
		}
	}
}