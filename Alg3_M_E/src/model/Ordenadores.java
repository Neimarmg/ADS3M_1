package model;

import model.Utilitarios.Auxiliar;
import Aplicacao.Menus;
import Aplicacao.Prints;

/**
 * Classe respons�vel pela ondena��o de dados carregados de um arquivo 
 * @author Neimar, Aur�lio
 */
public class Ordenadores {
	
	int topo;
	int comparacoes;
	long tempoExecucao;
	String aux;
	String pivo;
	String nomeOrdenador;


	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * M�todo respons�vel pela manipula��o do vetor durante ordena��o bubleSort
	 * @param i
	 * @param j
	 */
	private void trocasItensBubleSort(int i, int j) {
		aux = Auxiliar.vetor[i];                	
		Auxiliar.vetor[i] = Auxiliar.vetor[j];
		Auxiliar. vetor[j] = aux;	
	}
		
	
	/**
	 * Metodo respons�vel pela ordena��o BubleSort
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean ordem) throws Exception {		
		try {
			for (int i = 1; i < Auxiliar.vetor.length; i++) {
	         	for (int j = i+1; j < Auxiliar.getVetor().length; j++) {	         		
	         		if (ordem == true) {	         			
		                if (Auxiliar.vetor[i].compareTo(Auxiliar.vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
			                comparacoes++;
		                }
	         		} else {
		                if (Auxiliar.vetor[i].compareTo(Auxiliar.vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	comparacoes++;
		                }
	         		} 
	         	}	         	
	         	tempoExecucao  = System.currentTimeMillis();	         	
	         }			
	
		} catch (NullPointerException e) {
		 	Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	/**
	 * M�todo respons�vel pelo execu��o do ordenador bubleSort
	 * @throws Exception
	 */
	private void executaBubleSort() throws Exception {
		Auxiliar.carregaArquivo(Auxiliar.digita("Nome do arquivo"));
		
		if (Auxiliar.getValidaArquivo() == true) {
			ordenaBubleSort(Auxiliar.defineOrdem(true));
		}		 
	}
		
	
	/**
	 * M�todo respens�vel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void carregaBubleSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante o vetor limpo antes do carregamento do ordenador
		executaBubleSort();
		
		if (imprimir == true) { // Abilita impress�o do vetor quando solicitado
			imprime(true,true, true, true);
		}
	}
	
	
// ======================== << Ordena��o QuickSort >> ====================================

	
	/**
	 * M�todo que partiona o vetor e ordena as partes individualmente
	 * @param vet
	 * @param ini
	 * @param fim
	 * @return topo
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
		    } else {
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
	 * M�todo que executa as etapas � ordena��o do vetor
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
	private void carregaQuickSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante vetor limpo antes do carregamento do ordenador
		Auxiliar.carregaArquivo(Auxiliar.digita("Nome do arquivo"));
		
		if (Auxiliar.getValidaArquivo() == true) { 
			boolean ordem = Auxiliar.defineOrdem(true);
			ordenaQuickSort(Auxiliar.vetor, 1, (Auxiliar.vetor.length-2),ordem );
			
			if (imprimir == true){ // Habilita impress�o do vetor quando solicitado
				imprime(ordem, true, true, true);
			}
		}	    
	}

	
//=============== << Compara��o estat�stica de ordenadores >> ===============================
	
	/**
	 * M�todo estat�stico que compara performance dos ordenadores
	 * @throws Exception
	 */
	public  void comparaOrdenadores() throws Exception {
		limpaVetor(true);
		nomeOrdenador = "BUBLE SORT COMPARARADA";
		carregaBubleSort(false);
		informaStatistica(true);
		limpaVetor(true);
		nomeOrdenador = "QUICK SORT COMPARARDA";
		carregaBubleSort(false);
		informaStatistica(true);
		selecionaOrdenador();
	}
	
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * M�todo que exibe o cabe�alho com a ordem de execu��o, crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private  void informaCabecalhoOrdem(boolean ordem,boolean exibirCabecalho) {	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	Prints.msgc("	ORDEM CRESCENTE " + nomeOrdenador.toUpperCase() + "\n\n");
			} else {
				Prints.msgc("	ORDEM DECRESCENTE " + nomeOrdenador.toUpperCase() +"\n\n");
			}
		 }
	}
	
	
	/**
	 * M�dodo respons�vel pela limpeza do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada em tempo de execu��o
	 */
	private  void limpaVetor(boolean limparVetor) {
		if (limparVetor == true) {
			for (int i = 0; i < Auxiliar.vetor.length; i++) {
				Auxiliar.vetor[i]= "";				
			}
		}
		Auxiliar.setIndex(0); // Limpa "index" do vetor executado anteriormente
	}

	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	private void informaStatistica(boolean mostraEstatisca) {	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O " + nomeOrdenador.toUpperCase()
				+ "\nTamanho do vetor: " + Auxiliar.getVetor().length
				+ "\nTotal de comparacoes: " + comparacoes
				+ "\nTempo total: " + tempoExecucao + "mls\n");
		}
	}
	
	
	/**
	 * M�dodo geral de impress�o da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private  void imprime(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho) {	
		informaCabecalhoOrdem(ordem,exibecabecalho);
		for (String dados : Auxiliar.vetor) { 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}

	
	/**
	 * M�todo respons�vel pela sele��o dos comandos para execu�ao dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Menus.menuOrdenadores();
		nomeOrdenador = Auxiliar.digita("");
		switch (nomeOrdenador) {			
			
		case "buble":
			carregaBubleSort(true);
			selecionaOrdenador();			
			break;
		
		case "quick":		
			carregaQuickSort(true);			
			selecionaOrdenador();
			break;
	
		case "comparar":
			comparaOrdenadores();
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