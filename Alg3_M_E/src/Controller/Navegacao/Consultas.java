package Controller.Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Registrador;
import Controller.Arquivos.Ficheiro;
import model.Utilitarios.Auxiliar;


/**
 * Classe repons�vel pelas consultas em todas as estruras.
 * @author Neimar, Aurelio
 */
public class Consultas {
	public int contador = 0;
	Ficheiro ficheiro = new Ficheiro();
	private BufferedReader br;
	
	/**
	 * M�todo que realiza ficheiro navega��o entre os registros 
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
			Prints.msgc("Registros encontrados:\n");
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
	
//====================<< Busca bin�ria de registros >> =======================================	
	
	int vet[] = new int [Auxiliar.getVetor().length];
	int i, inicio = 0, meio, fim = Auxiliar.getVetor().length;
    boolean localizador = false;
    
    
    /**
	 * Imprime resultado da busca bin�ria
	 * @param campo
	 */
	private void imprimeBuscaBinaria(int campo) {		
		if (localizador == true) {
			Prints.msgb("	RESULTADO DE BUSCA BIN�RIA\n"
				+ "\nRegistro encontrado"
				+ "\n\nPosi��o [" + meio + "] " + Auxiliar.vetor[meio]);
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
		Auxiliar.carregaArquivo(nomeArquivo);			
		
		if (campo <= Auxiliar.getVetor().length){
		
			for (i = 0; i < Auxiliar.getVetor().length; i++) {		    	
				vet[i] = i;
				Prints.msg("\nId: " +i +" " +Auxiliar.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			Prints.msge("\nId inexistente!");
		}
		Auxiliar.setIndex(0); // Limpa vetor para pr�xima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	
	/**
	 * 
	 * @throws IOException
	 */
	public void consultaEstruturas() throws IOException{
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			Registrador.leArquivo(Auxiliar.digita("Nome do arquivo"));
			break;

		case "ARVORE":
			Prints.objetoNaoImplementado();
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
				consultaArquivo(Auxiliar.digita("Nome do arquivo"),Auxiliar.digita("Contato"),true);
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