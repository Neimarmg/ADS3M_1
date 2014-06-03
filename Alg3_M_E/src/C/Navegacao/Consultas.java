package C.Navegacao;

import App.Menus;
import App.View;
import C.Registrador;
import C.Arquivos.Ficheiro;
import C.Arvores.Avl.ArvoreAVL;
import C.Lista.ListaEncadeada;
import C.Lista.Nodo;
import M.Dados;
import M.Utilitarios.Auxiliar;


/**
 * Classe reponsável pelas consultas em todas as estruturas
 * @author Neimar, Aurélio
 */
public class Consultas {
	
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	/**
	 * Método que realiza ficheiro navegação entre os registradores
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		View.objetoNaoImplementado();
	}

		
//====================<< Busca binária de registrador >> =======================================	
	
	int vet[] = new int [Ficheiro.getVetor().length];
	int i, inicio = 0, meio, fim = Ficheiro.getVetor().length;
    boolean localizador = false;
    
    
    /**
	 * Imprime resultado da busca binária
	 * @param campo
	 */
	private void imprimeBuscaBinaria(int campo) {
		if (localizador == true) {
			View.msgb("RESULTADO DE BUSCA BINÁRIA\n"
				+ "\nRegistro encontrado\n"
				+ "\n\nPosição [" + meio + "] " + Dados.vetor[meio]
				+ "\n\nTotal de comparações:" + Auxiliar.getContador() + "\n");
				Auxiliar.setContador(false); // Limpa variável contadora
				
		} else {
		   	View.msge("\nNúmero não encontrado");
		}
	}
		
    
	/**
	 * Realiza busca binária dentro do vetor carregado do arquivo
	 * @param campo
	 */
	private void executaBuscaBinaria(int campo) {
	    i = 0;
	    meio = (inicio + fim) / 2;

	    while (inicio <= fim && localizador == false) {
	    	if (vet[meio] == campo) {
	    		localizador = true;
	    		Auxiliar.setContador(true);
	    	} else {
	    		Auxiliar.setContador(true);
	        	if (campo < vet[meio]) {
	        		fim = meio - 1;
	        		Auxiliar.setContador(true);
	            } else {
	            	inicio = meio + 1;
	            	Auxiliar.setContador(true);
	            }
	        	meio = (inicio + fim) / 2;
	       }
	   }
	}
	

	/**
	 * Método responsável pelo carregamento do arquivo
	 * @param nomeArquivo
	 * @param campo
	 * @throws Exception
	 */
	public void carregaBuscaBinaria(String nomeArquivo, int campo) throws Exception {
		Ficheiro.leArquivo(nomeArquivo, true, "", false, false);
		
		if (campo <= Dados.getVetor().length) {
		
			for (i = 0; i < Dados.getVetor().length; i++) {
				vet[i] = i;
				View.msg("\nId: " + i +" " + Dados.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			View.msge("\nId inexistente.");
		}
		
		Dados.setIndex(0); // Limpa vetor para próxima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	/**
	 * 
	 * @throws Exception
	 */
	private void tPosFixa() throws Exception {
		switch (Auxiliar.getOpcao()) {
			
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().travessiaPosFixa(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Registrador.getAvl().imprimeOrdenPosFixa(Registrador.getAvl());
				break;
				
			} else if (Auxiliar.getDetalhes().equals("rb")) {
				View.objetoNaoImplementado();
				break;
				
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condição de saída quando atividade for inválida
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	private void tPrefixa() throws Exception {

		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().travessiaPreFixa(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Registrador.getAvl().imprmeOrdenPreFixa(Registrador.getAvl());
				break;
				
			} else if (Auxiliar.getDetalhes().equals("rb")) {
				View.objetoNaoImplementado();
				break;
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condição de saída quando atividade for inválida
		}
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	private void tInfixa() throws Exception {
		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().travessiaInfixa(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Registrador.getAvl().imprimeOrdemInfixa(Registrador.getAvl());
				break;
				
			} else if (Auxiliar.getDetalhes().equals("rb")) {
				View.objetoNaoImplementado();
				break;
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condição de saída quando atividade for inválida
		}
	}	
	
	/**
	 * 
	 * @throws Exception
	 */
	private void buscaEmAltura() throws Exception {
		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().buscEmAltura(Auxiliar.digita("Elemento"), true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				View.objetoNaoImplementado();
				break;
				
			} else if (Auxiliar.getDetalhes().equals("rb")) {
				View.objetoNaoImplementado();
				break;
			}
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, false, true);
			tPosFixa();
			break; // Condição de saída quando atividade for inválida
		}
	}
	

//====================<< Include em Estruturas de dados >> =====================================	

	/**
	 * 
	 * @throws Exception
	 */
	private void manipulaEstrutura(boolean inserirElemento) throws Exception {
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			if (inserirElemento == true) {
				Registrador.getLista().insert(
						new Nodo<String>(Auxiliar.digita("Elemento")), lista.getHead());
			}
			Registrador.getLista().imprime(true);
			break;
			
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				if (inserirElemento == true) {
					Registrador.getLista().insert(new Nodo<String>(Auxiliar.digita("Elemento")), lista.getHead());
				}
				Registrador.getArvoreBinaria().imprime(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				if (inserirElemento == true) {
					Registrador.setAvl(new ArvoreAVL());
					Registrador.getAvl().insere(Registrador.getAvl(),Auxiliar.digitaNumero("Elemento numérico"));
				}
				Registrador.getAvl().imprimeAvl(Registrador.getAvl());
				break;
				
			} else if (Auxiliar.getDetalhes().equals("rb")) {
				if (inserirElemento == true) {
					Registrador.setArvoreRedBlack(Registrador.getArvoreRedBlack());
					Registrador.getArvoreRedBlack().insere(Auxiliar.digita("Elemento"));
				}
				Registrador.getArvoreRedBlack().imprimirNodos(true);
				break;
			}
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);					
			break; // Condição de saída quando atividade for inválida
		}
	}
 
	/**
	 * Método estruturado para implementação de exclusão de elementos de todas as estruturas
	 * @throws Exception
	 */
	private void removeElemento() throws Exception {
		View.objetoNaoImplementado();
		View.msge("\nPasso a passo do plano de implementação:\n");
		switch (Auxiliar.getOpcao()) {
				
		case "LISTA":
			View.msge("\nPasso 1: Carregar o arquivo na lista \n"
					 +"\nPasso 2: Digitar o elemento à ser excluído\n"
					 +"\nPasso 3: Percorrer a lista\n"
					 +"\nPasso 4: Se encontrado excluir\n"
					 +"\nPasso 5: Atualizar a lista\n");
			break;
			
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("binaria")) {
				View.msge("\nPasso 1: Carregar o arquivo na árvore \n"
						 + "\nPasso 2: Digitar o elemento à ser excluído\n"
						 + "\nPasso 3: Percorrer a árvore\n"
						 + "\nPasso 4: Se encontrado excluir\n"
						 + "\nPasso 5: Atualizar e realocar elementos\n");
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				View.msge("\nPasso 1: Carregar o arquivo na árvore \n"
						 + "\nPasso 2: Digitar o elemento à ser excluído\n"
						 + "\nPasso 3: Percorrer a árvore\n"
						 + "\nPasso 4: Se encontrado excluir\n"
						 + "\nPasso 5: Atualizar e realocar elementos para fazer o rebalanciamento\n");
				break;
			} else if (Auxiliar.getDetalhes().equals("rb")) {
					View.msge("\nSem planejamento ainda:\n");
				break;
			}
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			break; // Condição de saída quando atividade for inválida
		}
	}
	
	
//====================<< Menu ex >> ========================================================		
		
	/**
	 * Seleciona definições de estrutura à ser utilizada
	 */
	private void selecionaComando(String nomeArquivo) {
		try {
			Menus.menuConsultas();
			switch (Auxiliar.digita("")) {
			
			case "novo":
				manipulaEstrutura(true);
				selecionaComando(nomeArquivo);
				break;
			
			case "remover":
				removeElemento();
				break;
				
			case "posfixa":
				tPosFixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "prefixa":
				tPrefixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "infixa":
				tInfixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "contar":
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "altura":
				buscaEmAltura();
				selecionaComando(nomeArquivo);
				break;
			
			case "profundidade":
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "id":
				carregaBuscaBinaria(nomeArquivo, Auxiliar.digitaNumero("Id a ser localizado"));
				selecionaComando(nomeArquivo);
				break;
				
			case "navegar":
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "arquivo":
				Ficheiro.leArquivo(nomeArquivo, false, null, false, true);
				selecionaComando(nomeArquivo);
				break;
				
			case "nome":
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
		
			case "imprimir":
				manipulaEstrutura(false);
				selecionaComando(nomeArquivo);
				break;
			
				
			case "sair":
				View.sair();
				break;
			
			default:
				View.opcaoInvalida();
				selecionaComando(nomeArquivo);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//====================<< Menu definidor e atividade >> ====================			
	
	/**
	 * Método de execução de atividade
	 * @throws Exception 
	 */
	public void selecinaExtrutura() throws Exception {
		String nomeArquivo = Auxiliar.digita("Nome do arquivo");
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
			selecionaComando(nomeArquivo);
			break;

		case "ARVORE":
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
			selecionaComando(nomeArquivo);
			break;
		
		case "BINARIA":
			selecionaComando(nomeArquivo);
			break;
		
		default:
			View.opcaoInvalida();
			break;
		}
	}
	
}