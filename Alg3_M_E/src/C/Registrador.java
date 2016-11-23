package C;

import java.io.IOException;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import C.Arvores.Avl.ArvoreAVL;
import C.Arvores.Avl.NodoAVL;
import C.Arvores.Binaria.ArvoreBinaria;
import C.Arvores.RedBlack.ArvoreRBlack;
import C.Lista.ListaOrdenada;
import C.Lista.Nodo;
import M.Buffers;
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
	private static ArvoreRBlack<String> arvoreRedBlack = new ArvoreRBlack<String>();


	public static void setArvoreRedBlack(ArvoreRBlack<String> arvoreRedBlack) {
		Registrador.arvoreRedBlack = arvoreRedBlack;
	}

	/**
	 * M�todo de recupera��o do estado do objeto
	 * @return
	 */
	public static ArvoreRBlack<String> getArvoreRedBlack() {
		return arvoreRedBlack;
	}


	/**
	 * M�todo de recupera��o do estado do objeto
	 * @return
	 */
	public static ListaOrdenada<String> getLista() {
		return lista;
	}


	/**
	 * M�todo de recupera��o do estado do objeto
	 * @return
	 */
	public static ArvoreBinaria<String> getArvoreBinaria() {
		return arvoreBinaria;
	}

	public static void setAvl(ArvoreAVL avl) {
		Registrador.avl = avl;
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
		View.msge("\n�rvore inv�lida\n");
		Menus.menuArvores(true, ativaTipo, true);
	}

	NodoAVL nodoAvl  = new NodoAVL();


	/**
	 * M�todo respons�vel por receber os dados da leitura do arquivo, bem como inserir nas estruturas
	 * @param linha
	 * @throws Exception
	 */
	public static void copiaArquivo(String linha) throws Exception {

		switch (Auxiliar.getOpcao()) {

		case "LISTA":
			lista.insert(new Nodo<String>(linha), lista.getHead());
			break;

		case "ARVORE":

			if (Auxiliar.getDetalhes().equals("ab")) {
				arvoreBinaria.insere(new C.Arvores.Binaria.Nodo<String>(linha));// Insere o conte�do da linha

			} else if (Auxiliar.getDetalhes().equals("avl")) {
				getAvl().insere(avl, Dados.getIndex()); // Insere na �rvore o index da linha do arquivo

			} else if (Auxiliar.getDetalhes().equals("rb")) {
				getArvoreRedBlack().insere(linha); // Insere o conte�do da linha

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
		Include.addNovo(nomeArquivo, Contatos.getNome() + "," + Contatos.getFone() + "\n"); // Insere dado na �ltima linha do arquivo
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
	 * M�todo respons�vel pela inser��o de novo registro
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereRegistro(String nomeArquivo) throws Exception {

		switch (Auxiliar.getOpcao()) {

		case "LISTA":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
			lista.guardaEdicao();
			editaArquivo(nomeArquivo);
			break;

		case "ARVORE":
			
			switch (Auxiliar.getDetalhes()) {
				
			case "ab":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				arvoreBinaria.guardaEdicao();
				editaArquivo(nomeArquivo);
				break;
				
			case "avl":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				break;
				
			case "rb":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				break;	
				
			default:
				informaEstrutura(false);
				insereRegistro(nomeArquivo);
				break;
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
			insereRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;

		case "editar":
			View.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;

		case "remover":
			Buffers.setBuff(null); // Limpeza de "buffer"
			Buffers.setFile(null); // Limpeza de arquivo
			setAcum(""); // Limpeza de acumulador
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo, Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			View.sair();
			break;

		default:
			View.opcaoInvalida();
			executaComando(nomeArquivo); // "Loop" para novas a��es do menu
			break;
		}
	}
}