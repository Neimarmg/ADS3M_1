package Aplicacao;

import Navegacao.Consultas;
import Utilitarios.Prints;
import Arquivos.Ficheiro;
import Arquivos.Memoria;
import Estruturas.ListaEncadeada;
import Estruturas.Registrador;

public class Interface<T> extends Prints {
	
	Ficheiro ficheiro = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	Registrador registra = new Registrador();
	Consultas consultas = new Consultas();
	Memoria memoria =  new Memoria();

	/** 
	 * @throws Exception
	 */
	public void consulta() throws Exception {	
		menuConsultas();
		
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
	public void salva() throws Exception {	
		menuInsert();		
					
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
	public void imprime() throws Exception {	
		menuImprimir();
		
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
	public void manipulaAquivo() throws Exception {	
		menuArquivo();
		
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
	public void verificaInserir() throws Exception {
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
	public void iniciaTarefas() throws Exception {
		
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