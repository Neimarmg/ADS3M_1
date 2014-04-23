package Estruturas;

import Arquivos.Ficheiro;
import Navegacao.Consultas;
import Utilitarios.Prints;
import Utilitarios.Include;

/**
 * Classe respons�vel pela manipula��o de dados em arquivo edi��o, exclus�o e inser��o
 * @author Neimar, Aur�lio
 */
public class Registrador {

	String fone , nome;
	Ficheiro ficheiro =  new Ficheiro();
	Consultas consulta = new Consultas();
	ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	/**
	 * M�todo de inser��o de dados no arquivo
	 * @throws Exception
	 */
	public void insereDados() throws Exception {
		nome =  Prints.digita("Contato");
		fone = 	Prints.digita("Telefone");
	}
	
	
	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public  void executaComandos(String nomeArquivo) throws Exception {
		Prints.menuEditarArquivo();
		
		switch (Prints.digita("")) {
		
		case "novo":
			insereDados();
			Include.setAppend(true);
			Include.addNovo(nomeArquivo, nome +"," +fone +"\n"); //Insere na �ltima linha do arquivo
			lista.leArquivo(nomeArquivo); //L� arquivo ap�s a insers�o e padroniza a edi��o
			executaComandos(nomeArquivo); //loop para novas a��es do menu		
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComandos(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			executaComandos(nomeArquivo);//loop para novas a��es do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita append para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Prints.digita("\nOque deseja excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComandos(nomeArquivo);//loop para novas a��es do menu
			break;
		}	
	}
}