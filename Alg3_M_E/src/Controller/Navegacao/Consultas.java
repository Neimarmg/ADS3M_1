package Controller.Navegacao;

import Aplicacao.Menus;
import Aplicacao.Prints;
import Controller.Registrador;
import Controller.Arquivos.Ficheiro;
import model.Dados;
import model.Arvore.ArvoreBinaria;
import model.Lista.ListaEncadeada;
import model.Utilitarios.Auxiliar;


/**
 * Classe reponsável pelas consultas em todas as estruras.
 * @author Neimar, Aurelio
 * @param <T>
 */
public class Consultas<T> {
	
	public int contador = 0;
	Registrador registrador = new Registrador();
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	ArvoreBinaria<?> arvoreBinaria = new ArvoreBinaria<>();
	
	
	/**
	 * Método que realiza ficheiro navegação entre os registrador 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		Prints.objetoNaoImplementado();
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
			Prints.msgb("	RESULTADO DE BUSCA BINÁRIA\n"
				+ "\nRegistro encontrado\n"
				+ "\n\nPosição [" + meio + "] " + Dados.vetor[meio]
				+"\n\nTotal de comparações:" +Auxiliar.getContador()+"\n");
				Auxiliar.setContador(0); //Limpa variável contadora
				
		} else {
		   	Prints.msge("\nNúmero não encontrado");
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
	 * Método responsável pelo carregamento do arquivo.
	 * @param nomeArquivo
	 * @param campo
	 * @throws Exception
	 */
	public void carregaBuscaBinaria(String nomeArquivo,int campo) throws Exception {
		Ficheiro.leArquivo(nomeArquivo,true, "", false, false);			
		
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
		
		Dados.setIndex(0); // Limpa vetor para próxima consulta
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
			Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
			arvoreBinaria.imprime();
			
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
				Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"), false, "", false, true);
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