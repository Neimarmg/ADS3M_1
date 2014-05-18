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
 * Classe responsável pela manipulação de dados em arquivo: edição, exclusão e inserção
 * @author Neimar, Aurélio
 * @param <T>
 */
public class Registrador {
	
	public static String acum =""; //Acumulador de dados para edição de arquivo 
	Consultas consulta = new Consultas();
	static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();

	
	public static void setAcum(String acum) {
		Registrador.acum = acum;
	}
		
	public static String getAcum() {
		return acum;
	}
	
	
	/**
	 * Método responsável pela leitura dos dados em arquivo e finalização das alterações
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void leArquivo(String nomeArquivo) throws IOException{		
		
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
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}			
	}
	
	
	/**
	 * Método que le dados do teclado
	 * @throws Exception
	 */
	public void leTeclado() throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
	}
	
	
	/**
	 * Método responsável por salvar alterações 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, getAcum());
		setAcum(""); // Parâmetro de limpeza de "cache do acumulador" 
	}
	
				
	/**
	 * Método responsável pela insersão de novos registrador 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereNovoRegistro(String nomeArquivo) throws Exception {
		leTeclado();
		Include.setAppend(true);
		Include.addNovo(
			nomeArquivo, 
			Contatos.getNome()+"," +
			Contatos.getFone() +"\n"); //Insere dado na última linha do arquivo
	
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			leArquivo(nomeArquivo); // Lê arquivo após a insersão e padroniza a edição
			lista.guardaEdicao();;
			editaArquivo(nomeArquivo);	
			break;

		case "ARVORE":
			leArquivo(nomeArquivo);
			arvoreBinaria.guardaEdicao();
			editaArquivo(nomeArquivo);			
			break;
			
		default:
			Prints.opcaoInvalida();
			break;
		}
	}


	/**
	 * Método de manipulação de dados de arquivos
	 * @throws Exception
	 */
	public void executaComando(String nomeArquivo) throws Exception {
		Menus.menuInclude("DADOS");
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas ações do menu
			break;
		
		case "editar":
			Prints.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "imprimir":
			consulta.consultaArquivo(nomeArquivo, "", false);
			executaComando(nomeArquivo); // Loop para novas ações do menu
			break;
		
		case  "remover" :			
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			Prints.sair();
			break;
		
		default:
			Prints.opcaoInvalida();
			executaComando(nomeArquivo); // Loop para novas ações do menu
			break;
		}	
	}
}