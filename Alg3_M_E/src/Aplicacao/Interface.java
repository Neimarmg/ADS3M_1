package Aplicacao;

import Controles.Navegacao.Consultas;
import Utilitarios.Auxiliar;
import Utilitarios.Prints;
import Controles.Arquivos.Ficheiro;
import Controles.Arquivos.Memoria;
import Estruturas.ListaEncadeada;
import Controles.Registrador;

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
		
			switch (Auxiliar.digita("")) {
			
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
					
		switch (Auxiliar.digita("")) {			
			
		case "arquivo":		
			registra.executaComando(Auxiliar.digita("Nome do arquivo"));			
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
		
		switch (Auxiliar.digita("")) {		
		
		case "arquivo":
			ficheiro.abre(Auxiliar.digita("Nome do arquivo"));
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
		
		switch (Auxiliar.digita("")) {
			
		case "buscar":
			ficheiro.buscaArquivo(Auxiliar.digita("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "novo":
			ficheiro.criaNovo(Auxiliar.digita("Nome do arquivo"));
			manipulaAquivo();
			break;
		
		case "remover":
			ficheiro.remove(Auxiliar.digita("Nome do arquivo"));
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
	 * Método de verificação de memória para inserção de novos dados
	 * @throws Exception
	 */
	public static void verificaInserir() throws Exception {
		msg("\nVerificando disco...\n");
		if (memoria.calcula() < 6000){ // Verifica memória ao inserir dados
			msg("\nVerificação concluída, há memória disponível!\n");
			salva();
		} else {
			espacoInsuficiente();
			imprime();
		}
	}
	
	
	/**
	 *	Método com definição das atividades
	 * @throws Exception
	 */
	public static void iniciaTarefas() throws Exception {
		
		switch (Auxiliar.digita("")) {
		
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