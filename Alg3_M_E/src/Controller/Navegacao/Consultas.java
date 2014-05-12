package Controller.Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Arquivos.Ficheiro;
import model.Utilitarios.Auxiliar;

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
	
	int db[] = new int [Auxiliar.getTamanho()];
	int i, inicio = 0, meio, fim = Auxiliar.getTamanho();
    boolean localizador = false;
    
    
	/**
	 * Realiza busca bin�ria dentro do vetor carregado do arquivo
	 * @param campo
	 */
	private void executaBuscaBinaria(int campo){
	    i = 0;
	    meio = (inicio + fim) / 2;

	    while (inicio <= fim && localizador == false) {
	    	if (db[meio] == campo) {
	    		localizador = true;

	    	}else {
	    		
	        	if (campo < db[meio]) {
	        		fim = meio - 1;	        	
	            }else {
	            	inicio = meio + 1;
	            }
	        	meio = (inicio + fim) / 2;
	       }
	   }
	}
	

	/**
	 * Imprime resultado da busca bin�ria
	 * @param campo
	 */
	private void imprimeBuscaBinaria(int campo){		
		if (localizador == true) {
			Prints.msgb("	RESULTADO DE BUSCA BIN�RIA\n"
				+ "\nRegistro encontrado"
				+ "\n\nPosi��o [" + meio + "] " +Auxiliar.vetor[meio-1]);
		} else {
		   	Prints.msge("\nN�mero n�o encontrado");
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
		
		if (campo <= Auxiliar.getTamanho()){
		
			for (i = 0; i < Auxiliar.getTamanho(); i++) {		    	
				db[i] = i;
				Prints.msg("\nId: " +i +" " +Auxiliar.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);
			
		}else{
			Prints.msge("\nId inexistente!");
		}
		Auxiliar.setIndex(0); //Limpa vertor para pr�xima consulta
	}
	
	
//====================<< Menu busca >> =======================================		
		
	/**
	 * Seleciona comando de consulta
	 */
	public void selecionaComando() {
		try {
			Menus.menuConsultaArquivo();
					
			switch (Auxiliar.digita("")) {
			
			case "navegar":
				navega(Auxiliar.digita("Nome do arquivo"));
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
	