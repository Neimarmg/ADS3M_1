package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Utilitarios.Prints;

/**
 *Classe responsavel pela ondena��o de dados carregados de um arquivo 
 * @author Neimar e Aur�lio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int topo, index = 0, comparacoes = 0, tamanho = 34;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux, pivo, nomeOrdenador;
	long tempoExecucao;

	
	/**
	 * M�todo que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	private void leArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Abilita de execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;
				//Prints.msg(vetor[index] +"\n");
			}			
			
			for (int i = index; i < vetor.length; i++) { //Aumenta tamanho do vetor.
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; // Desabilita a execu��o de ordenador
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado.\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espa�o insufiente no array de armazenamento.\n");
		}
	}
	
	
	/**
	 * Exibe o cabe�alho do modo de ordena��o crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private  void informaCabecalhoModo(boolean ordem,boolean exibirCabecalho){	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	Prints.msgc("	ORDEM CRESCENTE "+nomeOrdenador +"\n\n");
			}else{
				Prints.msgc("	ORDEM DECRESCENTE "+nomeOrdenador +"\n\n");
			}
		 }
	}
	
	
	/**
	 * M�todo respons�vel pela limpesa do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada
	 */
	private  void limpaVetor(boolean limparVetor){
		if(limparVetor == true){
			for (int i = 0; i < vetor.length; i++) {
				vetor[i]= "";				
			}
		}
		index = 0;
	}

	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * M�todo geral responsavel pela troca dos dados do no vetor
	 * @param i
	 * @param j
	 */
	private void trocasItensBubleSort(int i, int j){
		aux = vetor[i];                	
        vetor[i] = vetor[j];
        vetor[j] = aux;	
	}
		
	
	/**
	 * Metodo responsavel pela ordena��o dos dados captados do arquivo
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean ordem, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (ordem == true) {	         			 
		                if (vetor[i].compareTo(vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
			                comparacoes++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	comparacoes++;
		                }
	         		} 
	         	}
	         	tempoExecucao  = System.currentTimeMillis();
	         }			
			imprimeOrdenacao(ordem,mostraEstatisca,true,true);
		} catch (NullPointerException e) {
		 	Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Metodo respensalvel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void carregaBubleSort() throws Exception {
		leArquivo(Prints.digita("Nome do arquivo"));
		if (validaArquivo == true){
			ordenaBubleSort(especificaOrdem(),true);
		}		 
	}
	
// ======================== << Ordena��o QuickSort >> ====================================

	/**
	 * M�todo que partiona o vetor e ordena as partes
	 * @param vet
	 * @param ini
	 * @param fim
	 * @return
	 */
	private int particionaVetorQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int i;
	    pivo = vet[ini];
	    topo = ini;
	 
	    for (i = ini + 1; i <= fim; i++) {
	    	if(ordem == true){
		    	if (vet[i].compareTo(pivo) < 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	 topo++;
			    	comparacoes++;
		    	}
		    }else{
		    	if (vet[i].compareTo(pivo) > 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	topo++;
			    	comparacoes++;
		    	}	
		    }	
	    	tempoExecucao  = System.currentTimeMillis();
	     }
	    vet[topo] = pivo;
	    return topo;
	 }
	 
	
	/**
	 * M�todo que executa as etapas a ordena��o do vetor
	 * @param vet
	 * @param ini
	 * @param fim
	 */
	private void ordenaQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int meio;		
		if (ini < fim) {
			meio = particionaVetorQuickSort(vet, ini, fim, ordem);
		    ordenaQuickSort(vet, ini, meio, ordem);
		    ordenaQuickSort(vet, meio + 1, fim, ordem);
		}		
	}
	
	
	/**
	 * M�todo de carregamento e valida��o do ordenador 
	 * @throws Exception
	 */
	private void carregaQuickSort() throws Exception {
		leArquivo(Prints.digita("Nome do arquivo"));
		
		if (validaArquivo == true){ 
			boolean ordem = especificaOrdem();
			ordenaQuickSort(vetor, 1, (vetor.length-2),ordem );
			imprimeOrdenacao(ordem, true, true, true);
		}	    
	}
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O " +nomeOrdenador
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de comparacoes: " +comparacoes
				+"\nTempo total: " +tempoExecucao +"\n");
		}
		comparacoes = 0;		
	}
	
	
	/**
	 * M�dodo de impress�o da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private  void imprimeOrdenacao(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho){	
		informaCabecalhoModo(ordem,exibecabecalho);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}


	/**
	 * M�todo que define a ordem de ordena��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	private boolean especificaOrdem() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) { //Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { //Define ordem decrescete
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return especificaOrdem();
		}		
	}

	
	/**
	 * M�todo respons�vel pela sele��o dos comandos para execu�ao dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Prints.menuOrdenadores();				
		switch (Prints.digita("")) {			
			
		case "buble":
			nomeOrdenador = "BUBLE SORT ";
			carregaBubleSort();
			selecionaOrdenador();			
			break;
		
		case "quick":		
			nomeOrdenador = "QUICK SORT ";
			carregaQuickSort();			
			selecionaOrdenador();
			break;
	
		case "comparar":
			Prints.objetoNaoImplementado();
			selecionaOrdenador();
			break;
		case "sair":
			Prints.sair();
			break;
				
		default:
			Prints.opcaoInvalida();
			selecionaOrdenador();
			break;
		}
	}
}