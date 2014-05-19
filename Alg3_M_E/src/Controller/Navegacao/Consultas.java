package Controller.Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Registrador;
import Controller.Arquivos.Ficheiro;
import model.Dados;
import model.Lista.ListaEncadeada;
import model.Utilitarios.Auxiliar;


/**
 * Classe repons�vel pelas consultas em todas as estruras.
 * @author Neimar, Aurelio
 */
public class Consultas {
	
	public int contador = 0;
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	private BufferedReader br;
	
	
	/**
	 * M�todo que realiza ficheiro navega��o entre os registrador 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		Prints.objetoNaoImplementado();
	}	

	
	/**
	 * M�todo global de impress�o de dados de arquivo 
	 * @param nomeArquivo
	 * @param campo
	 * @param filtrar
	 * @throws IOException
	 */
	public void consultaArquivo(String nomeArquivo,String campo, boolean filtrar) throws IOException {
		try {
			FileReader r = new FileReader(nomeArquivo);
			br = new BufferedReader(r);
			String linha = br.readLine();
			Prints.msgc("Registrador encontrados:\n\n");
			while(linha != null ) {
				linha = br.readLine();
				if (filtrar == true) { // Imprime dados coincidentes com o par�metro	
					if (linha.equals(campo)) {
						Prints.msg("> " + linha + "\n");
					}
				} else {
					Prints.msg("> " + linha + "\n");
				}				
			}			
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
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
			Prints.msgb("	RESULTADO DE BUSCA BIN�RIA\n"
				+ "\nRegistro encontrado"
				+ "\n\nPosi��o [" + meio + "] " + Dados.vetor[meio]);
		} else {
		   	Prints.msge("\nN�mero n�o encontrado");
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

	    	} else {
	    		
	        	if (campo < vet[meio]) {
	        		fim = meio - 1;	        	
	            }else {
	            	inicio = meio + 1;
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
		Ficheiro.leArquivo(nomeArquivo,true);			
		
		if (campo <= Dados.getVetor().length){
		
			for (i = 0; i < Dados.getVetor().length; i++) {		    	
				vet[i] = i;
				Prints.msg("\nId: " +i +" " +Dados.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			Prints.msge("\nId inexistente!");
		}
		
		Dados.setIndex(0); // Limpa vetor para pr�xima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	
	/**
	 * 
	 * @throws Exception 
	 */
	public void consultaEstruturas(String nomeArquivo) throws Exception{
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":			
			//consultaArquivo(nomeArquivo, Auxiliar.digita("Contato"),true);
			break;

		case "ARVORE":
			Ficheiro.leArquivo(nomeArquivo,false);
			//registrador.insereNovoRegistro(nomeArquivo);
			break;
			
		default:
			Prints.opcaoInvalida();
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
				Prints.objetoNaoImplementado();				
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
				consultaArquivo(Auxiliar.digita("Nome do arquivo"),"",false);
				selecionaComando();
				break;
				
			case "sair":
				Prints.sair();
				break;
				
			default:
				Prints.opcaoInvalida();
				selecionaComando();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}