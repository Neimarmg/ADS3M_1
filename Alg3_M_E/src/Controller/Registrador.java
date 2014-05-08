package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Arquivos.Ficheiro;
import Controller.Navegacao.Consultas;
import model.Contatos;
import model.Arvore.ArvoreBinaria;
import model.Lista.ListaOrdenada;
import model.Lista.Nodo;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Include;

/**
 * Classe respons�vel pela manipula��o de dados em arquivo edi��o, exclus�o e inser��o
 * @author Neimar, Aur�lio
 */
public class Registrador {

	ArvoreBinaria arvore =  new ArvoreBinaria(); 
	Ficheiro ficheiro =  new Ficheiro();
	Consultas consulta = new Consultas();
	ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
		
	/**
	 * M�todo respons�vel pela leitura dos dados em arquivo e finaliza��o das altera��es
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void leArquivo(String nomeArquivo) throws IOException {		
		try{
			FileReader file = new FileReader(nomeArquivo);
			BufferedReader buff = new BufferedReader(file);
			String linha = buff.readLine();
			
			while(linha != null ){
				linha = buff.readLine();
				
				lista.insert(new Nodo<String>(linha), lista.getHead());
				
			}			
			buff.close();
			
		} catch (NullPointerException e) {
			Prints.msgb("Arquivo embranco.");;
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
		
		lista.imprime(false);	
	}
	
	
	
	/**
	 * M�todo de inser��o de dados no arquivo
	 * @throws Exception
	 */
	public void leTeclado() throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
	}
	
	
	/**
	 * M�todo respons�vel pela insers�o de novos registros 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereNovoRegistro(String nomeArquivo) throws Exception {
		leTeclado();
		Include.setAppend(true);
		
		if(Auxiliar.getOpcao().equals("LISTA")){ //Defini��o de atividade
			Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere na �ltima linha do arquivo
			leArquivo(nomeArquivo); //L� arquivo ap�s a insers�o e padroniza a edi��o
			lista.editaArquivo(nomeArquivo);	
			
		}else if(Auxiliar.getOpcao().equals("ARVORE")){//Defini��o de atividade
			
			
		}
	}
	
	
	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public void executaComando(String nomeArquivo) throws Exception {
		Menus.menuEditarArquivo();
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
<<<<<<< HEAD
			leTeclado();
			Include.setAppend(true);
			
			if (Auxiliar.getOpcao().equals("LISTA")) { // Defini��o de atividade
				Include.addNovo(nomeArquivo, nome + "," + fone + "\n"); // Insere na �ltima linha do arquivo
				lista.leArquivo(nomeArquivo); // L� arquivo ap�s a insers�o e padroniza a edi��o
			}
			
			if (Auxiliar.getOpcao().equals("ARVORE")) { //Defini��o de atividade
				
			}				
			
			executaComando(nomeArquivo); // Loop para novas a��es do menu		
=======
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); //loop para novas a��es do menu
>>>>>>> 2d8799445860b9aaf9e07a1b235bba70da5f229f
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.abreArquivo(nomeArquivo, "", false);
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		}	
	}
}