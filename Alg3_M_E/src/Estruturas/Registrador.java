package Estruturas;

import Arquivos.Ficheiro;
import Navegacao.Consultas;
import Utilitarios.Prints;
import Utilitarios.crud;

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
	 * @throws Exception
	 */
	public  void insereLista(String nomeArquivo) throws Exception {
		Prints.menuInserirNovo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			insereDados();
			crud.setAppend(true);
			crud.addNovo(nomeArquivo, nome +"," +fone +"\n");
			lista.leArquivo(nomeArquivo);
			insereLista(nomeArquivo);		
			break;
		
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			insereLista(nomeArquivo);
			break;
			
		case  "remover" :			
			crud.setAppend(false); // Desabilita append para sobscrever dados no arquivo
			crud.remove(nomeArquivo,Prints.digita("\nNome parágrafo excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			insereLista(nomeArquivo);
			break;
		}	
	}
}