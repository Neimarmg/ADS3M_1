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
	public void abreArquivo(String nomeArquivo,String campo, boolean filtrar) throws IOException {
		try {
			FileReader r = new FileReader(nomeArquivo);
			br = new BufferedReader(r);
			String linha = br.readLine();
			Prints.msgb("Registros encontrados:");
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
				abreArquivo(Auxiliar.digita("Nome do arquivo"),Auxiliar.digita("Contato"),true);
				selecionaComando();
				break;
				
			case "arquivo":
				abreArquivo(Auxiliar.digita("Nome do arquivo"),"",false);
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

	/**
	 * Realiza busca binária dentro do arquivo
	 * @param nomeArquivo
	 * @param campo
	 * @throws IOException
	 */
	public void buscaBinaria(String nomeArquivo,String campo)  {
		
		int db[] = new int[10];
	    int numero, i, inicio = 0, meio, fim = 4;
	    boolean localizador = false;

	    for (i = 0; i < 5; i++) {
	    	db[i] = Auxiliar.digitaNumero("Digite um " + (i + 1) + " número: ");
	    }
	    
	    numero = Auxiliar.digitaNumero("\nNúmero a ser localizado? ");

	    i = 0;

	    meio = (inicio + fim) / 2;

	    while (inicio <= fim && localizador == false) {
	    	if (db[meio] == numero) {
	    		localizador = true;
	        
	    	}else {
	           	
	        	if (numero < db[meio]) {
	        		fim = meio - 1;	        	
	            }else {
	            	inicio = meio + 1;
	            }
	        	meio = (inicio + fim) / 2;
	       }
	   }
	   if (localizador) {
	    	Prints.msg("\nNúmero encontrado na posição [" + meio + "]" + ".");
	   } else {
		   Prints.msg("\nNúmero não encontrado");
	   }
	}
}