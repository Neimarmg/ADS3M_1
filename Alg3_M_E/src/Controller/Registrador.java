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
import model.Arvore.ArvoreBinariaAVL;
import model.Arvore.ArvoreBinariaAVL.arvore;
import model.Lista.ListaOrdenada;
import model.Lista.Nodo;
import model.Utilitarios.Auxiliar;
import model.Utilitarios.Include;

/**
 * Classe responsável pela manipulação de dados em arquivo edição, exclusão e inserção
 * @author Neimar, Aurélio
 */
public class Registrador {

	ArvoreBinariaAVL arvore =  new ArvoreBinariaAVL(); 
	Ficheiro ficheiro =  new Ficheiro();
	static Consultas consulta = new Consultas();
	static ListaOrdenada<String> lista = new ListaOrdenada<String>();
		
	/**
	 * Método responsável pela leitura dos dados em arquivo e finalização das alterações
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public static void leArquivo(String nomeArquivo) throws IOException {		
		
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
	 * Método de inserção de dados no arquivo
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
		
		if(Auxiliar.getOpcao().equals("LISTA")){ //Definição de atividade
			Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere na última linha do arquivo
			leArquivo(nomeArquivo); //Lê arquivo após a insersão e padroniza a edição
			lista.editaArquivo(nomeArquivo);	
			
		}else if(Auxiliar.getOpcao().equals("ARVORE")){//Definição de atividade
			
			arvore a = null;
			
		    a = ArvoreBinariaAVL.inserir(a, 10 );
		    a = ArvoreBinariaAVL.inserir(a, 4);
		    a = ArvoreBinariaAVL.inserir(a, 7);
		    a = ArvoreBinariaAVL.inserir(a, 58);
		    a = ArvoreBinariaAVL.inserir(a, 24);
		    a = ArvoreBinariaAVL.inserir(a, 3);
		    a = ArvoreBinariaAVL.inserir(a, 99);
		 
		    System.out.print("EM : ");
		    ArvoreBinariaAVL.exibiremordem(a);
		    System.out.println();
		      
		    System.out.print("PRE : ");
		    ArvoreBinariaAVL.exibirpreordem(a);
		    System.out.println();
		       
		    System.out.print("POS : ");
		    ArvoreBinariaAVL.exibirposordem(a);
		    System.out.println();	
			
			
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
			executaComando(nomeArquivo); //loop para novas ações do menu
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