package Estruturas;

import Arquivos.Ficheiro;
import Navegacao.Consultas;
import Utilitarios.Prints;
import Utilitarios.crud;

public class Registrador {

	String desc, fone , nome;
	Ficheiro ficheiro =  new Ficheiro();
	Consultas consulta = new Consultas();
	ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	/**
	 * @throws Exception
	 */
	public void insereDados() throws Exception {
		nome =  Prints.digita("Contato");
		fone = 	Prints.digita("Telefone");
		desc = nome +" " + fone;
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
			consulta.especifica(nomeArquivo, "", false);
			insereLista(nomeArquivo);
			break;
			
		case  "remover" :			
			desc = Prints.digita("\nNome parágrafo excluir");
			crud.setAppend(false);
			crud.remove(nomeArquivo,desc);
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