package Controles;

import Aplicacao.Menus;
import Controles.Arquivos.Ficheiro;
import Controles.Navegacao.Consultas;
import Estruturas.ListaOrdenada;
import Utilitarios.Prints;
import Utilitarios.Include;

/**
 * Classe responsável pela manipulação de dados em arquivo edição, exclusão e inserção
 * @author Neimar, Aurélio
 */
public class Registrador {

	String fone , nome;
	Ficheiro ficheiro =  new Ficheiro();
	Consultas consulta = new Consultas();
	ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	/**
	 * Método de inserção de dados no arquivo
	 * @throws Exception
	 */
	public void leTeclado() throws Exception {
		nome =  Prints.digita("Contato");
		fone = 	Prints.digita("Telefone");
	}
	
	
	/**
	 * Método de manipulação de dados de arquivos
	 * @throws Exception
	 */
	public  void executaComando(String nomeArquivo) throws Exception {
		Menus.menuEditarArquivo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			leTeclado();
			Include.setAppend(true);
			Include.addNovo(nomeArquivo, nome +"," +fone +"\n"); //Insere na última linha do arquivo
			lista.leArquivo(nomeArquivo); //Lê arquivo após a insersão e padroniza a edição
			executaComando(nomeArquivo); //loop para novas ações do menu		
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			executaComando(nomeArquivo);//loop para novas ações do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita append para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Prints.digita("\nOque deseja excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComando(nomeArquivo);//loop para novas ações do menu
			break;
		}	
	}
}