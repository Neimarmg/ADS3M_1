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
	public  void insereLista() throws Exception {
		Prints.menuInserirNovo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			insereDados();
			lista.insert(new Nodo<String>(nome));
			lista.insert(new Nodo<String>(fone), lista.getHead());
			insereLista();
			break;
		
		case "imprimir":
			lista.print();
			insereLista();
			break;
		
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			insereLista();
			break;
		}	
	}
	
	
	/**
	 * @param arquivo
	 * @throws Exception
	 */
	public  void insereArquivo(String arquivo) throws Exception {

		Prints.menuInserirNovo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			insereDados();
			crud.addNovo(arquivo,nome);
			crud.addNovo(arquivo,fone);
			insereArquivo(arquivo);
			break;
			
		case "imprimir":
			Prints.msgl();
			Prints.msg("Dados em aquivo: \n");
			ficheiro.imprime(arquivo);
			insereArquivo(arquivo);
			break;
			
		case "remover":
			desc =  Prints.digita("\nNome para excluir");
			crud.remove(arquivo, desc);
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			insereArquivo(arquivo);
			break;
		}
	}
	
	
	/**
	 * Obs. N�o tinha ficado entendido qual era a rela��o da lista 
	 * com o arquivo, at� a a explica��o em aula dia 10/4. Por esse motivo as inser��es 
	 * foram feitas em saparado
	 * @param arquivo
	 * @throws Exception
	 */
	public  void insereAmbas(String arquivo) throws Exception {
		//executaComando();
		Prints.menuInserirNovo();
		
		switch (Prints.digita("")) {
		case "novo":
			insereDados();
			lista.insert(new Nodo<String>(nome));
			lista.insert(new Nodo<String>(fone), lista.getHead());
			crud.addNovo(arquivo,desc);
			insereAmbas(arquivo);
			break;
		
		case "imprimir":
			Prints.msgl();
			Prints.msg("Dados em lista: ");
			lista.print();
			Prints.msgl();
			Prints.msg("Dados em aquivo: ");
			ficheiro.imprime(arquivo);
			insereAmbas(arquivo);
			break;
			
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			insereAmbas(arquivo);
			break;
		}
	}
}