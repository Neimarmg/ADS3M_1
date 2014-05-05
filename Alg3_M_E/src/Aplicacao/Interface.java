package Aplicacao;

import Navegacao.Consultas;
import Utilitarios.Prints;
import Arquivos.Ficheiro;
import Arquivos.Memoria;
import Estruturas.ListaEncadeada;
import Estruturas.Registrador;

public class Interface<T> extends Prints {
	
	static Ficheiro ficheiro = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	static Registrador registra = new Registrador();
	static Consultas consultas = new Consultas();
	static Memoria memoria =  new Memoria();

	/** 
	 * @throws Exception
	 */
	public static void consulta() throws Exception {	
		Menus.menuConsultas();
		
			switch (digita("")) {
			
			case "lista":
				objetoNaoImplementado();
				consulta();
				break;
				
			case "arquivo":
				consultas.selecionaComando();
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
	public static void salva() throws Exception {	
		Menus.menuInsert();		
					
		switch (digita("")) {			
			
		case "arquivo":		
			registra.executaComando(digita("Nome do arquivo"));			
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
	public static void imprime() throws Exception {	
		Menus.menuImprimir();
		
		switch (digita("")) {		
		
		case "arquivo":
			ficheiro.abre(digita("Nome do arquivo"));
			imprime();
			break;

		case "sair":
			sair();
			break;
			
		default:
			Prints.opcaoInvalida();
			imprime();
			break;
		}		
	}
	
	/** 
	 * @throws Exception
	 */
	public static void manipulaAquivo() throws Exception {	
		Menus.menuArquivo();
		
		switch (digita("")) {
			
		case "buscar":
			ficheiro.buscaArquivo(digita("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "novo":
			ficheiro.criaNovo(digita("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "remover":
			ficheiro.remove(digita("Nome do arquivo"));
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
	 * M�todo de verifica��o de mem�ria para inser��o de novos dados
	 * @throws Exception
	 */
	public static void verificaInserir() throws Exception {
		msg("\nVerificando disco...\n");
		if (memoria.calcula() < 6000){ // Verifica mem�ria ao inserir dados
			msg("\nVerifica��o conclu�da, h� mem�ria dispon�vel!\n");
			salva();
		} else {
			espacoInsuficiente();
			imprime();
		}
	}
	
	
	/**
	 *	M�todo com defini��o das atividades
	 * @throws Exception
	 */
	public static void iniciaTarefas() throws Exception {
		
		switch (digita("")) {
		
		case "consultar":	
			consulta();				
			break;
			
		case "executar":
			verificaInserir();
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