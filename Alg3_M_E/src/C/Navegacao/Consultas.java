package C.Navegacao;

import App.Menus;
import App.View;
import C.Registrador;
import C.Arquivos.Ficheiro;
import M.Dados;
import M.Lista.ListaEncadeada;
import M.Utilitarios.Auxiliar;


/**
 * Classe repons�vel pelas consultas em todas as estruras.
 * @author Neimar, Aurelio
 * @param <T>
 */
public class Consultas<T> {
	
	public int contador = 0;
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	/**
	 * M�todo que realiza ficheiro navega��o entre os registrador 
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
				+"\n\nTotal de compara��es:" +Auxiliar.getContador()+"\n");
				Auxiliar.setContador(0); //Limpa vari�vel contadora
				
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
	    		Auxiliar.setContador(Auxiliar.getContador()+1);
	    	} else {
	    		Auxiliar.setContador(Auxiliar.getContador()+1);
	        	if (campo < vet[meio]) {
	        		fim = meio - 1;	  
	        		Auxiliar.setContador(Auxiliar.getContador()+1);
	            }else {
	            	inicio = meio + 1;
	            	Auxiliar.setContador(Auxiliar.getContador()+1);
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
		
		if (campo <= Dados.getVetor().length){
		
			for (i = 0; i < Dados.getVetor().length; i++) {		    	
				vet[i] = i;
				View.msg("\nId: " +i +" " +Dados.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			View.msge("\nId inexistente!");
		}
		
		Dados.setIndex(0); // Limpa vetor para pr�xima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	
	/**
	 * 
	 * @throws Exception 
	 */
	public static void consultaEstruturas(String nomeArquivo) throws Exception{
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":			
			//consultaArquivo(nomeArquivo, Auxiliar.digita("Contato"),true);
			break;

		case "ARVORE":			
			Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
			Registrador.getArvoreBinaria().imprime();
	
			break;
			
		default:
			View.opcaoInvalida();
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
//====================<< Menu busca >> ========================================================		
		
	/**
	 * Seleciona comando de consulta
	 */
	public void selecionaComando() {
		try {
			Menus.menuConsultas();					
			switch (Auxiliar.digita("")) {
			
			case "navegar":
				View.objetoNaoImplementado();				
				selecionaComando();
				break;

			case "nome":				
				consultaEstruturas(Auxiliar.digita("Nome do arquivo"));
				selecionaComando();
				break;
			
			case "id":				
				carregaBuscaBinaria(Auxiliar.digita("Nome do arquivo"),	Auxiliar.digitaNumero("Nome a ser localizado"));
				selecionaComando();
				break;		
			
			case "arquivo":
				Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"), false, "", false, true);
				selecionaComando();
				break;
				
			case "sair":
				View.sair();
				break;
				
			default:
				View.opcaoInvalida();
				selecionaComando();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}