package Controller;

import model.Ordenadores;
import model.Lista.ListaEncadeada;
import model.Utilitarios.Auxiliar;
import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Arquivos.Ficheiro;
import Controller.Arquivos.Memoria;
import Controller.Navegacao.Consultas;

/**
 * Classe respons�vel pela intera��o do sistema com usu�rio
 * @author 181100053
 *
 * @param <T>
 * @param <string>
 */
public class interacao<T, string> {
	
	static Ficheiro ficheiro = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	static Consultas consultas = new Consultas();
	static Memoria memoria =  new Memoria();
	static Registrador registrador = new Registrador();
	
	/**
	 * M�todo respons�vel pela sele��o dos comandos para execu�ao dos ordenadores
	 * @throws Exception
	 */
	public static void selecionaOrdenador() throws Exception {			
		
		Menus.menuOrdenadores();
		Ordenadores.setNomeOrdenador(Auxiliar.digita(""));
		switch (Ordenadores.getNomeOrdenador()) {			
			
		case "buble":
			Ordenadores.carregaBubleSort(true);
			selecionaOrdenador();			
			break;
		
		case "quick":		
			Ordenadores.carregaQuickSort(true);			
			selecionaOrdenador();
			break;
	
		case "comparar":
			Ordenadores.comparaOrdenadores();
			selecionaOrdenador();
			break;
			
		case "sair":
			Prints.sair();
			break;
				
		default:
			Prints.opcaoInvalida();
			selecionaOrdenador();
			break;
		}
	}
	

	/** 
	 * @throws Exception
	 */
	public static void manipulaAquivo() throws Exception {	
		Menus.menuInclude("ARQUIVO");
		
		switch (Auxiliar.digita("")) {
			
		case "buscar":
			Ficheiro.validadaArquivo(Auxiliar.digita("Nome do arquivo"));
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
			Prints.sair();
			break;
			
		default:
			Prints.opcaoInvalida();
			manipulaAquivo();
			break;
		}		
	}
	
	
	/**
	 * M�todo de verifica��o de mem�ria para inser��o de novos dados
	 * @throws Exception
	 */
	public static void verificaInserir() throws Exception {
		Prints.msg("\nVerificando disco...\n");
		
		//Obs. deve ser alerado dependendo da configura��o da maquina para < ou > 
		
		if (memoria.calcula() < 6000){ // Verifica mem�ria ao inserir dados
			Prints.msgr("\nVerifica��o conclu�da, h� mem�ria dispon�vel!\n");
			registrador.executaComando("l.txt" /*Auxiliar.digita("Nome do arquivo")*/);	
			
		} else {
			Prints.espacoInsuficiente();			
		}
	}
	
	
	/**
	 *	M�todo com defini��o das atividades 
	 * @throws Exception
	 */
	public static void iniciaTarefas() throws Exception {
		
		switch (Auxiliar.digita("")) {
		
		case "consultar":	
			consultas.selecionaComando();			
			break;
			
		case "executar":
			verificaInserir();
			break;
			
		case "imprimir":
			consultas.consultaArquivo(Auxiliar.digita("Nome do arquivo"),"",false);
			break;
			
		case "arquivo":
			manipulaAquivo();
			break;
			
		case "ordenar":
			selecionaOrdenador();
			break;
			
		case "sair":
			Prints.sair();
			break;
			
		default: 
			Prints.opcaoInvalida();
			iniciaTarefas();
			break;
		}
	}
}