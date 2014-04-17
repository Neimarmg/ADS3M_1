package Navegacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Arquivos.Ficheiro;
import Utilitarios.Prints;

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
	 * M�todo global de impres�o de dados de arquivo
	 * @param nomeArquivo
	 * @param campo
	 * @param filtrar
	 * @throws IOException
	 */
	public void especifica(String nomeArquivo,String campo, boolean filtrar) throws IOException {
		try {
			FileReader r = new FileReader(nomeArquivo);
			br = new BufferedReader(r);
			String linha = br.readLine();
			Prints.msgb("Registro encontrados:");
			while(linha != null ){
				linha = br.readLine();
				if (filtrar == true){	
					if (linha.equals(campo)){
						Prints.msg("> " +linha +"\n");
					}
				}else{
					Prints.msg("> " +linha +"\n");
				}				
			}
			
			
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
	}
	
	
	public void carrega() {
		try {
			Prints.menuConsultaArquivo();
					
			switch (Prints.digita("")) {
			
			case "navegar":
				navega(Prints.digita("Nome do arquivo"));
				carrega();
				break;

			case "filtrar":				
				especifica(Prints.digita("Nome do arquivo"),Prints.digita("Contato"),true);
				carrega();
				break;
				
			case "arquivo":
				especifica(Prints.digita("Nome do arquivo"),"",false);
				carrega();
				break;
				
			case "sair":
				Prints.sair();
				break;
			default:
				Prints.opcaoInvalida();
				carrega();
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Realiza busca bin�ria dentro do arquivo
	 * @param nomeArquivo
	 * @param campo
	 * @throws IOException
	 */
	public void buscaBinaria(String nomeArquivo,String campo) throws IOException {
		
		/** 
		 * Professor: Para entender o assunto pesquisamos na Internet. Ap�s altera��es chegamos no c�digo TESTE abaixo.
		 * N�o convertemos para o seu projeto por falta de tempo. Achamos melhor entregar assim
		 * 
		 * 
		 * int db[] = new int[10];
	        int numero, i, inicio = 0, meio, fim = 4;
	        boolean localizador = false;

	        for (i = 0; i < 5; i++) {
	            System.out.print("Digite o " + (i + 1) + " n�mero: ");
	            db[i] = in.nextInt();
	        }

	        System.out.print("\nN�mero a ser localizado? ");

	        numero = in.nextInt();

	        i = 0;

	        meio = (inicio + fim) / 2;

	        while (inicio <= fim && localizador == false) {
	            if (db[meio] == numero) {
	            	localizador = true;
	            } else {
	            	if (numero < db[meio]) {
	            		fim = meio - 1;
	                } else {
	                    inicio = meio + 1;
	                }
	                meio = (inicio + fim) / 2;
	            }
	        }

	        if (localizador) {
	        	System.out.println("\nN�mero encontrado na posi��o [" + meio + "]" + ".");
	        } else {
	        	System.out.println("\nN�mero n�o encontrado");
	        }
	    in.close();    
	    }
	*/
		
	}
}