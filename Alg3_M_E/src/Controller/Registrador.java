package Controller;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Arquivos.Ficheiro;
import Controller.Navegacao.Consultas;
import model.Lista.ListaOrdenada;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Include;

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
	public void leTeclado() throws Exception {
		nome =  Auxiliar.digita("Contato");
		fone = 	Auxiliar.digita("Telefone");
	}
	
	
	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public  void executaComando(String nomeArquivo) throws Exception {
		Menus.menuEditarArquivo();
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
			leTeclado();
			Include.setAppend(true);
			Include.addNovo(nomeArquivo, nome +"," +fone +"\n"); //Insere na �ltima linha do arquivo
			lista.leArquivo(nomeArquivo); //L� arquivo ap�s a insers�o e padroniza a edi��o
			executaComando(nomeArquivo); //loop para novas a��es do menu		
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			executaComando(nomeArquivo);//loop para novas a��es do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita append para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComando(nomeArquivo);//loop para novas a��es do menu
			break;
		}	
	}
}