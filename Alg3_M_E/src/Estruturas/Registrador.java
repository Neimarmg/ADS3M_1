package Estruturas;

import Arquivos.Ficheiro;
import Navegacao.Consultas;
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
	public void insereDados() throws Exception {
		nome =  Prints.digita("Contato");
		fone = 	Prints.digita("Telefone");
	}
	
	
	/**
	 * Método de manipulação de dados de arquivos
	 * @throws Exception
	 */
	public  void executaComandos(String nomeArquivo) throws Exception {
		Prints.menuEditarArquivo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			insereDados();
			Include.setAppend(true);
			Include.addNovo(nomeArquivo, nome +"," +fone +"\n"); //Insere na última linha do arquivo
			lista.leArquivo(nomeArquivo); //Lê arquivo após a insersão e padroniza a edição
			executaComandos(nomeArquivo); //loop para novas ações do menu		
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComandos(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			executaComandos(nomeArquivo);//loop para novas ações do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita append para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Prints.digita("\nOque deseja excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComandos(nomeArquivo);//loop para novas ações do menu
			break;
		}	
	}
}