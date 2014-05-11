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
	 * Método que realiza ficheiro navegação entre os registros 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		Prints.objetoNaoImplementado();
	}	

	/**
	 * Método global de impressão de dados de arquivo 
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
				if (filtrar == true) { // Imprime dados coincidentes com o parâmetro	
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
	
//====================<< Busca binaria de rigitros >> =======================================	
	
	int db[] = new int [Auxiliar.getTamanho()];
	String nome; 
	int i, idContato, inicio = 0, meio, fim = Auxiliar.getTamanho();
    boolean localizador = false;

	/**
	 * Realiza busca binária dentro do arquivo
	 * @param nomeArquivo
	 * @param campo
	 */
	public void executaBuscaBinaria(String nomeArquivo,String campo){
		
	    i = 0;

	    meio = (inicio + fim) / 2;

	    while (inicio <= fim && localizador == false) {
	    	if (db[meio] == idContato) {
	    		localizador = true;

	    	}else {

	        	if (idContato < db[meio]) {
	        		fim = meio - 1;	        	
	            }else {
	            	inicio = meio + 1;
	            }
	        	meio = (inicio + fim) / 2;
	       }
	   }
	    

	}

	
	public void imprimeBuscaBinaria(){		
		if (localizador) {
			Prints.msg("\nNúmero encontrado na posição [" + meio + "] " +".");
		} else {
		   	Prints.msg("\nNúmero não encontrado");
		}
	}
	
	
	
	public void carregaBuscaBinaria(String nomeArquivo,String campo) throws Exception {
			Auxiliar.carregaArquivo(nomeArquivo);
			
		    for (i = 0; i < Auxiliar.getTamanho(); i++) {
		    	Prints.msg("\n" +Auxiliar.vetor[i]);
		    	if (Auxiliar.vetor[i] != null ){

		    		db[i] = i; 
		    		
		    		if (nome.equals(Auxiliar.vetor[i])){
		    			idContato = i;
		    		}
		    	}
		    }
		    
		   // imprimeBuscaBinaria();
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

			case "filtrar":				
				consultaArquivo(Auxiliar.digita("Nome do arquivo"),Auxiliar.digita("Contato"),true);
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
	