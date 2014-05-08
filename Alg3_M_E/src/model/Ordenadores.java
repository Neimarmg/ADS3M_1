package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Utilitarios.Auxiliar;
import Aplicacao.Menus;
import Aplicacao.Prints;

/**
 * Classe responsável pela ondenação de dados carregados de um arquivo 
 * @author Neimar e Aurélio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int topo;
	int index = 0;
	int comparacoes;
	int tamanho = 50;
	long tempoExecucao;
	String vetor[] = new String[tamanho];
	String aux;
	String pivo;
	String nomeOrdenador;
	String linha;
	FileReader file;
	BufferedReader buff;

	
	/**
	 * Método que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException
	 */
	private void leArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Abilita execução de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;
			}			
			
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor após carregamento dos dados do arquivo
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; // Desabilita a execução de ordenador
		
		} catch (IOException e) {
			Prints.msge("\nO arquivo não pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nEspaço insufiente no array de armazenamento.\n");
		}
		
	}
	
	
	/**
	 * Método que exibe o cabeçalho com a ordem de execução, crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private  void informaCabecalhoOrdem(boolean ordem,boolean exibirCabecalho){	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	Prints.msgc("	ORDEM CRESCENTE " + nomeOrdenador.toUpperCase() + "\n\n");
			} else {
				Prints.msgc("	ORDEM DECRESCENTE " + nomeOrdenador.toUpperCase() +"\n\n");
			}
		 }
	}
	
	
	/**
	 * Médodo responsável pela limpeza do vetor após ordenação,
	 * de modo que possa ter suas posições livres,
	 * quando uma próxima ordenação for solicitada em tempo de execução
	 */
	private  void limpaVetor(boolean limparVetor) {
		if (limparVetor == true) {
			for (int i = 0; i < vetor.length; i++) {
				vetor[i]= "";				
			}
		}
		index = 0; // Limpa index do vetor executado anteriormente
	}

	
//========================= << Ordenação BubleSort >> ==============================
	
	/**
	 * Método responsável pela manipulação do vetor, durante a ordenação do bubleSort
	 * @param i
	 * @param j
	 */
	private void trocasItensBubleSort(int i, int j) {
		aux = vetor[i];                	
        vetor[i] = vetor[j];
        vetor[j] = aux;	
	}
		
	
	/**
	 * Metodo responsável pela ordenação do BubleSort
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean ordem) throws Exception {		
		try {
			for (int i = 1; i < vetor.length; i++) {
	         	for (int j = i+1; j < vetor.length; j++) {	         		
	         		if (ordem == true) {	         			
		                if (vetor[i].compareTo(vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
			                comparacoes++;
		                }
	         		} else {
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	comparacoes++;
		                }
	         		} 
	         	}	         	
	         	tempoExecucao  = System.currentTimeMillis();	         	
	         }			
	
		} catch (NullPointerException e) {
		 	Prints.msge("\nO vetor de armazanamento está definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Método responsável pelo execução do ordenador bubleSort
	 * @throws Exception
	 */
	private void executaBubleSort() throws Exception {
		leArquivo(Auxiliar.digita("Nome do arquivo"));
		if (validaArquivo == true) {
			ordenaBubleSort(Auxiliar.defineOrdem(true));
		}		 
	}
		
	
	/**
	 * Método respensável pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void carregaBubleSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante o vetor limpo antes do carregamento do ordenador
		executaBubleSort();
		
		if (imprimir == true) { // Abilita impressão do vetor quando solicitado
			imprime(true,true, true, true);
		}
	}
	
	
// ======================== << Ordenação QuickSort >> ====================================

	
	/**
	 * Método que partiona o vetor e ordena as partes idividualmente
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
	 * Método que executa as etapas à ordenação do vetor
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
	 * Método de carregamento e validação do ordenador 
	 * @throws Exception
	 */
	private void carregaQuickSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante que o vetor limpo antes do carregamento do ordenador
		leArquivo(Auxiliar.digita("Nome do arquivo"));
		
		if (validaArquivo == true) { 
			boolean ordem = Auxiliar.defineOrdem(true);
			ordenaQuickSort(vetor, 1, (vetor.length-2),ordem );
			
			if (imprimir == true){ //Abilita impressão do vetor quando solicitado
				imprime(ordem, true, true, true);
			}
		}	    
	}

	
//=============== << Comparação estatística de ordenadores >> ===============================
	
	/**
	 * Método estatístico que compara performance dos ordenadores
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
	 * Informa dados estatísticos específicos da ordenação
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca) {	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTATÍSTICOS DA ORDENAÇÃO " + nomeOrdenador.toUpperCase()
				+ "\nTamanho do vetor: " + tamanho
				+ "\nTotal de comparacoes: " + comparacoes
				+ "\nTempo total: " + tempoExecucao + "mls\n");
		}
	}
	
	
	/**
	 * Médodo geral de impressão da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private  void imprime(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho) {	
		informaCabecalhoOrdem(ordem,exibecabecalho);
		for (String dados : vetor) { 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}


	
	/**
	 * Método responsável pela seleção dos comandos para execuçao dos ordenadores
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