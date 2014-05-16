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
 */
public class Registrador {
	
	public static String acum =""; //Acumulador de dados para edição de arquivo 
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
	 * Método responsável pela leitura dos dados em arquivo e finalização das alterações
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public static void leArquivo(String nomeArquivo) throws IOException {		
		
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
			Prints.msgb("Arquivo em branco.");;
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}		
		lista.imprime(true);
		arvoreBinaria.imprime(true);	
	}
	
	
	/**
	 * Método que le dados do teclado
	 * @throws Exception
	 */
	public static void leTeclado() throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
	}
	
	
	/**
	 * Método responsável pela insersão de novos registros 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public static void insereNovoRegistro(String nomeArquivo) throws Exception {
		leTeclado();
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere na última linha do arquivo
		
		if (Auxiliar.getOpcao().equals("LISTA")) { // Definição de atividade			
			leArquivo(nomeArquivo); // Lê arquivo após a insersão e padroniza a edição
			lista.editaArquivo(nomeArquivo);	
			
		}
		
		if (Auxiliar.getOpcao().equals("ARVORE")) { // Definição de atividade           
			leArquivo(nomeArquivo);
		}
	}


	/**
	 * Método de manipulação de dados de arquivos
	 * @throws Exception
	 */
	public static void executaComando(String nomeArquivo) throws Exception {
		Menus.menuEditarArquivo();
		
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