package Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Navegacao.Consultas;
import model.Contatos;
import model.Arvore.ArvoreBinaria;
import model.Lista.ListaOrdenada;
import model.Lista.Nodo;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Include;

/**
 * Classe respons�vel pela manipula��o de dados em arquivo: edi��o, exclus�o e inser��o
 * @author Neimar, Aur�lio
 */
public class Registrador {
	
	public static String acum =""; //Acumulador de dados para edi��o de arquivo 
	static Consultas consulta = new Consultas();
	static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();
	
	
	public static void setAcum(String acum) {
		Registrador.acum = acum;
	}
		
	public static String getAcum() {
		return acum;
	}
	
	
	/**
	 * M�todo respons�vel pela leitura dos dados em arquivo e finaliza��o das altera��es
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public static void leArquivo(String nomeArquivo) throws IOException{		
		
		try {
			FileReader file = new FileReader(nomeArquivo);
			BufferedReader buff = new BufferedReader(file);
			String linha = buff.readLine();			
			while(linha != null ){
				linha = buff.readLine();				
				
				switch (Auxiliar.getOpcao()) {
				
				case "LISTA":
					lista.insert(new Nodo<String>(linha), lista.getHead());
					break;
				
				case "ARVORE":
					arvoreBinaria.insere(new model.Arvore.Nodo<String>(linha));
					break;
					
				default:
					Prints.opcaoInvalida();
					break;
				}
			}			
			buff.close();
			
		} catch (NullPointerException e) {
			Prints.msgb("Arquivo em branco.");
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}			
	}
	
	
	/**
	 * M�todo que le dados do teclado
	 * @throws Exception
	 */
	public static void leTeclado() throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
	}
	
	
	/**
	 * M�todo respons�vel por salvar altera��es 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public static void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, Registrador.getAcum());
		setAcum(""); // Par�metro de limpeza de "cache do acumulador" 
	}
	
	
	/**
	 * M�todo respons�vel pela insers�o de novos registros 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public static void insereNovoRegistro(String nomeArquivo) throws Exception {
		leTeclado();
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere na �ltima linha do arquivo
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			leArquivo(nomeArquivo); // L� arquivo ap�s a insers�o e padroniza a edi��o
			lista.imprime(true);
			editaArquivo(nomeArquivo);	
			break;

		case "ARVORE":
			leArquivo(nomeArquivo);
			arvoreBinaria.imprime(true);
			editaArquivo(nomeArquivo);			
			break;
			
		default:
			Prints.opcaoInvalida();
			break;
		}
	}


	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public static void executaComando(String nomeArquivo) throws Exception {
		Menus.menuEditarArquivo();
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.consultaArquivo(nomeArquivo, "", false);
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