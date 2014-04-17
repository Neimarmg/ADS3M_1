package Estruturas;

import Arquivos.Ficheiro;
import Utilitarios.Prints;
import Utilitarios.crud;

public class Registrador {

	String desc, fone , nome;
	Ficheiro ficheiro =  new Ficheiro();
	crud crud = new crud();
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
			//lista.insert(new Nodo<String>();
			lista.insert(new Nodo<String>(nome +"/Fone:" +fone), lista.getHead());
			insereLista(nomeArquivo);
			break;
		
		case "imprimir":
			lista.print();
			insereLista(nomeArquivo);
			break;
		case  "remover" :
			desc = Prints.digita("\nNome parágrafo excluir");
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