package M;

import App.View;
import C.Arquivos.Ficheiro;
import M.Utilitarios.Auxiliar;

/**
 * Classe respons�vel pela ondena��o de dados carregados de um arquivo 
 * @author Neimar, Aur�lio
 */
public class Ordenadores {
	
	static int topo;
	static long tempoExecucao;
	static String aux;
	static String pivo;
	static String nomeOrdenador;
	
	
	public static void setNomeOrdenador(String nomeOrdenador) {
		Ordenadores.nomeOrdenador = nomeOrdenador;
	}
	
	public static String getNomeOrdenador() {
		return nomeOrdenador;
	}

	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * M�todo respons�vel pela manipula��o do vetor durante ordena��o bubleSort
	 * @param i
	 * @param j
	 */
	private static void trocasItensBubleSort(int i, int j) {
		aux = Dados.vetor[i];                	
		Dados.vetor[i] = Dados.vetor[j];
		Dados.vetor[j] = aux;	
	}
		
	/**
	 * Metodo respons�vel pela ordena��o BubleSort
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private static void ordenaBubleSort(boolean ordem) throws Exception {		
		try {
			for (int i = 1; i < Dados.vetor.length; i++) {
	         	for (int j = i+1; j < Dados.getVetor().length; j++) {	         		
	         		if (ordem == true) {	         			
		                if (Dados.vetor[i].compareTo(Dados.vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
		                   	Auxiliar.setContador(true);
		                }
	         		} else {
		                if (Dados.vetor[i].compareTo(Dados.vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	Auxiliar.setContador(true);
		                }
	         		} 
	         	}	         	
	         	tempoExecucao  = System.currentTimeMillis();	         	
	         }			
	
		} catch (NullPointerException e) {
		 	View.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	/**
	 * M�todo respons�vel pelo execu��o do ordenador bubleSort
	 * @throws Exception
	 */
	private static void executaBubleSort() throws Exception {
		Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"), true, null, false, false);
		
		if (Dados.getValidaArquivo() == true) {
			ordenaBubleSort(Auxiliar.defineOrdem(true));
		}		 
	}
		
	
	/**
	 * M�todo respens�vel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	public static void carregaBubleSort(boolean imprimir) throws Exception {
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
	private static int particionaVetorQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int i;
	    pivo = vet[ini];
	    topo = ini;
	 
	    for (i = ini + 1; i <= fim; i++) {
	    	if(ordem == true){
		    	if (vet[i].compareTo(pivo) < 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	 topo++;
			    	 Auxiliar.setContador(true);
		    	}
		    } else {
		    	if (vet[i].compareTo(pivo) > 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	topo++;
			    	Auxiliar.setContador(true);
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
	private static void ordenaQuickSort(String vet[], int ini, int fim, boolean ordem) {
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
	public static void carregaQuickSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante vetor limpo antes do carregamento do ordenador
		Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"),true, null, false, false);
		
		if (Dados.getValidaArquivo() == true) { 
			boolean ordem = Auxiliar.defineOrdem(true);
			ordenaQuickSort(Dados.vetor, 1, (Dados.vetor.length-2),ordem );
			
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
	public static void comparaOrdenadores() throws Exception {
		limpaVetor(true);
		nomeOrdenador = "BUBLE SORT COMPARADA";
		carregaBubleSort(false);
		informaStatistica(true);
		limpaVetor(true);
		nomeOrdenador = "QUICK SORT COMPARADA";
		carregaBubleSort(false);
		informaStatistica(true);
	}
	
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * M�todo que exibe o cabe�alho com a ordem de execu��o, crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private static  void informaCabecalhoOrdem(boolean ordem,boolean exibirCabecalho) {	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	View.msgc("	ORDEM CRESCENTE " + nomeOrdenador.toUpperCase() + "\n\n");
			} else {
				View.msgc("	ORDEM DECRESCENTE " + nomeOrdenador.toUpperCase() +"\n\n");
			}
		 }
	}
	
	
	/**
	 * M�dodo respons�vel pela limpeza do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada em tempo de execu��o
	 */
	private static  void limpaVetor(boolean limparVetor) {
		if (limparVetor == true) {
			for (int i = 0; i < Dados.vetor.length; i++) {
				Dados.vetor[i]= "";				
			}
		}
		Dados.setIndex(0); // Limpa "index" do vetor executado anteriormente
	}

	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	private static void informaStatistica(boolean mostraEstatisca) {	
		if (mostraEstatisca == true) { 
			View.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O " + nomeOrdenador.toUpperCase()
				+ "\nTamanho do vetor: " + Dados.getVetor().length
				+ "\nTotal de comparacoes: " + Auxiliar.getContador()
				+ "\nTempo total: " + tempoExecucao + "mls\n");
		}
		Auxiliar.setContador(false);
	}
	
	
	/**
	 * M�dodo geral de impress�o da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private static  void imprime(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho) {	
		informaCabecalhoOrdem(ordem,exibecabecalho);
		for (String dados : Dados.vetor) { 
        	if (dados != null && dados != "") {
            	View.msg(dados + " \n");  
        	}        	
		}
		View.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}
}