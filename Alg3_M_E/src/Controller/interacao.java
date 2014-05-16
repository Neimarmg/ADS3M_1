package Controller;

import model.Lista.ListaEncadeada;
import model.Utilitarios.Auxiliar;
import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Arquivos.Ficheiro;
import Controller.Arquivos.Memoria;
import Controller.Navegacao.Consultas;

/**
 * Classe responsável pela interação do sistema com usuário
 * @author 181100053
 *
 * @param <T>
 */
public class interacao<T> {
	
	static Ficheiro ficheiro = new Ficheiro();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	static Consultas consultas = new Consultas();
	static Memoria memoria =  new Memoria();


	/** 
	 * @throws Exception
	 */
	public static void manipulaAquivo() throws Exception {	
		Menus.menuArquivo();
		
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
	 * Método de verificação de memória para inserção de novos dados
	 * @throws Exception
	 */
	public static void verificaInserir() throws Exception {
		Prints.msg("\nVerificando disco...\n");
		if (memoria.calcula() > 6000){ // Verifica memória ao inserir dados
			Prints.msgr("\nVerificação concluída, há memória disponível!\n");
			Registrador.executaComando(Auxiliar.digita("Nome do arquivo"));	
			
		} else {
			Prints.espacoInsuficiente();			
		}
	}
	
	
	/**
	 *	Método com definição das atividades
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