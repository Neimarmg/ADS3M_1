package C.Consultas;

import App.Menus;
import App.View;
import C.Registrador;
import C.Lista.ListaEncadeada;
import C.Lista.Nodo;
import M.Utilitarios.Auxiliar;


/**
 * Classe reponsável pelas consultas em todas as estruturas
 * @author Neimar, Aurélio
 */
public class Arvores {
	
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	



//====================<< Busca em estruturas java >> ========================================		
	/**
	 * 
	 * @throws Exception
	 */
	public void tPosFixa() throws Exception {
		switch (Auxiliar.getOpcao()) {
			
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().travessiaPosFixa(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Registrador.getAvl().imprimeOrdemPosFixa(Registrador.getAvl());
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
	public void tPrefixa() throws Exception {

		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("ab")) {
				Registrador.getArvoreBinaria().travessiaPreFixa(true);
				break;
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {
				Registrador.getAvl().imprimeOrdemPreFixa(Registrador.getAvl());
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
	public void tInfixa() throws Exception {
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
	public void buscaEmAltura() throws Exception {
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
	public void manipulaEstrutura(boolean inserirElemento) throws Exception {
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
					Registrador.getAvl();
					Registrador.getAvl().insere(Registrador.getAvl(),Auxiliar.digitaNumero("Elemento"));
				}
				Registrador.getAvl().imprimeAvore();
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
	public void removeElemento() throws Exception {
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
	

	
}