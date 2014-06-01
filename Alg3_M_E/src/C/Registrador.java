package C;

import java.io.IOException;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import C.Arvores.Avl.ArvoreAVL;
import C.Arvores.Binaria.ArvoreBinaria;
import C.Lista.ListaOrdenada;
import C.Lista.Nodo;
import M.Contatos;
import M.Dados;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Include;

/**
 * Classe respons�vel pela manipula��o de dados em arquivo: edi��o, exclus�o e inser��o
 * @author Neimar, Aur�lio
 * @param <T>
 */
public class Registrador {
	
	private static String acum =""; // Acumulador de dados para edi��o de arquivo 
	private static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	private static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();
	private static ArvoreAVL avl = new ArvoreAVL();
	
	
	/**
	 * M�todo de recupera��o do estado do objeto
	 * @return
	 */
	public static ArvoreBinaria<String> getArvoreBinaria() {
		return arvoreBinaria;
	}
	
	
	/**
	 * M�todo de recupera��o do estado do objeto
	 * @return
	 */
	public static ArvoreAVL getAvl() {
		return avl;
	}
	
	
	public static void setAcum(String acum) {
		Registrador.acum += acum;
	}
	
	
	public static String getAcum() {
		return acum;
	}
	
	/**
	 * Informa quando a estrura de opera��o � inv�lida
	 * @param ativaTipo
	 * @throws Exception
	 */
	public static void informaEstrutura(boolean ativaTipo) throws Exception {
		View.msge("\nArvore inv�lida\n");
		Menus.menuArvores(true, ativaTipo, true);
	}
	
	
	/**
	 * M�todo respons�vel por receber os dados da leitura do arquivo, bem como insirir nas etruturas		
	 * @param linha
	 * @throws Exception
	 */
	public static void copiaArquivo(String linha) throws Exception {

		switch (Auxiliar.getOpcao()) {
	
		case "LISTA":			
			lista.insert(new Nodo<String>(linha), lista.getHead());
			break;
		
		case "ARVORE":
			
			if(Auxiliar.getDetalhes().equals("binaria")) {				
				arvoreBinaria.insere(new C.Arvores.Binaria.Nodo<String>(linha));
			
			} else if (Auxiliar.getDetalhes().equals("avl")) {				
				avl.inserir(avl,Dados.getIndex());
				

			} else if(Auxiliar.getDetalhes().equals("redBlack")) {
				View.objetoNaoImplementado();
				
			} else {
				informaEstrutura(false);
				copiaArquivo(linha);
			}
			
			break;
			
		default:
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}
	
	
	/**
	 * M�todo que l� dados do teclado
	 * @throws Exception
	 */
	private void gravaDados(String nomeArquivo) throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); // Insere dado na �ltima linha do arquivo
	}
	
	
	/**
	 * M�todo respons�vel por salvar altera��es 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	private void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, getAcum());
		setAcum(""); // Par�metro de limpeza de "cache" do acumulador 
	}
	
					
	/**
	 * M�todo respons�vel pela insers�o de novo registro
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereNovoRegistro(String nomeArquivo) throws Exception {
						
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // L� arquivo ap�s a insers�o e padroniza a edi��o
			lista.guardaEdicao();
			editaArquivo(nomeArquivo);
				
			break;

		case "ARVORE":			
			if(Auxiliar.getDetalhes().equals("binaria")) {
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
				arvoreBinaria.guardaEdicao();
				editaArquivo(nomeArquivo);	
			
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
				avl.imprmeOrdenPreFixa(avl);
				
				Ficheiro.setIndex(0);
				
			
			} else if(Auxiliar.getDetalhes().equals("redBlack")) {
				
			
			} else {
				informaEstrutura(false);
				insereNovoRegistro(nomeArquivo);
			}			
			break;
			
		default:
			View.msge("\nAtividade inv�lida!\n");
			break;
		}
	}


	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public void executaComando(String nomeArquivo) throws Exception {
		Menus.menuInclude("DADOS");
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		
		case "editar":
			View.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case "remover" :			
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			View.sair();
			break;
		
		default:
			View.opcaoInvalida();
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		}	
	}
}