package C.Navegacao;

import App.Menus;
import App.View;
import C.Registrador;
import C.Arquivos.Ficheiro;
import C.Lista.ListaEncadeada;
import M.Dados;
import M.Utilitarios.Auxiliar;


/**
 * Classe repons�vel pelas consultas em todas as estruras
 * @author Neimar, Aurelio
 */
public class Consultas {
	
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	/**
	 * M�todo que realiza ficheiro navega��o entre os registradores 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		View.objetoNaoImplementado();
	}	

		
//====================<< Busca bin�ria de registrador >> =======================================	
	
	int vet[] = new int [Ficheiro.getVetor().length];
	int i, inicio = 0, meio, fim = Ficheiro.getVetor().length;
    boolean localizador = false;
    
    
    /**
	 * Imprime resultado da busca bin�ria
	 * @param campo
	 */
	private void imprimeBuscaBinaria(int campo) {		
		if (localizador == true) {
			View.msgb("	RESULTADO DE BUSCA BIN�RIA\n"
				+ "\nRegistro encontrado\n"
				+ "\n\nPosi��o [" + meio + "] " + Dados.vetor[meio]
				+ "\n\nTotal de compara��es:" + Auxiliar.getContador() + "\n");
				Auxiliar.setContador(false); // Limpa vari�vel contadora
				
		} else {
		   	View.msge("\nN�mero n�o encontrado");
		}
	}
		
    
	/**
	 * Realiza busca bin�ria dentro do vetor carregado do arquivo
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
	 * M�todo respons�vel pelo carregamento do arquivo.
	 * @param nomeArquivo
	 * @param campo
	 * @throws Exception
	 */
	public void carregaBuscaBinaria(String nomeArquivo,int campo) throws Exception {
		Ficheiro.leArquivo(nomeArquivo,true, "", false, false);			
		
		if (campo <= Dados.getVetor().length) {
		
			for (i = 0; i < Dados.getVetor().length; i++) {		    	
				vet[i] = i;
				View.msg("\nId: " +i +" " + Dados.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			View.msge("\nId inexistente.");
		}
		
		Dados.setIndex(0); // Limpa vetor para pr�xima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	
	private void tPosFixa() throws Exception {		
		switch (Auxiliar.getOpcao()) {
			
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("binaria")) {				
				Registrador.getArvoreBinaria().travessiaPosFixa();
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {				
				View.objetoNaoImplementado();

			} else if(Auxiliar.getDetalhes().equals("redBlack")) {
				View.objetoNaoImplementado();				
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			tPosFixa();
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}
	
	
	private void tPrefixa() throws Exception {		

		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("binaria")) {				
				Registrador.getArvoreBinaria().travessiaPreFixa();
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {				
				View.objetoNaoImplementado();

			} else if (Auxiliar.getDetalhes().equals("redBlack") ) {
				View.objetoNaoImplementado();				
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			tPosFixa();			
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}	
	
	
	
	private void tInfixa() throws Exception {		
		switch (Auxiliar.getOpcao()) {
		
		case "ARVORE":
			
			if (Auxiliar.getDetalhes().equals("binaria")) {				
				Registrador.getArvoreBinaria().travessiaInfixa();
				
			} else if (Auxiliar.getDetalhes().equals("avl")) {				
				View.objetoNaoImplementado();

			} else if (Auxiliar.getDetalhes().equals("redBlack")) {
				View.objetoNaoImplementado();				
			}			
			break;
			
		default:
			View.opcaoInvalida();
			Menus.menuArvores(true, true, true);
			tPosFixa();			
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}	
	
	
//====================<< Menu busca >> ========================================================		
		
	/**
	 * Seleciona comando de consulta
	 */
	private void selecionaComando(String nomeArquivo) {
		try {
			Menus.menuConsultas();					
			switch (Auxiliar.digita("")) {
			
			case "novo":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "remover":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
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
				View.objetoNaoImplementado();
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
				Ficheiro.leArquivo(nomeArquivo, false, "", false, true);
				selecionaComando(nomeArquivo);
				break;
				
			case "nome":				
				View.objetoNaoImplementado();
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
	
	
	
	/**
	 * 
	 * @throws Exception 
	 */
	public void selecinaExtrutura() throws Exception {
		String nomeArquivo = Auxiliar.digita("Nome do arquivo");
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":			
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
			Registrador.getLista().imprime(true);
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