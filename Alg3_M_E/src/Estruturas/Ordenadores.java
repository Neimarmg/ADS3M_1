package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Utilitarios.Prints;

public class Ordenadores {
	
	boolean validaArquivo; 
	int index = 0, trocas = 0 , tamanho = 100;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux;
	
	//Ficheiro ficheiro = new Ficheiro();
	
	/**
	 * M�todo que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	public  void executaArquivo(String nomeArquivo ) throws Exception {
		
		try {
			validaArquivo = true; // Abilita de execu��o de ordenador
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;				
				vetor[index]= linha;
			}
			
			//Aumenta tamanho do vetor.
			for (int i = index; i < vetor.length; i++) {
				vetor[i]= "";
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistente\n");
			validaArquivo = false; //// Desabilita de execu��o de ordenador
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado.\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espa�o insufiente no array de armazenamento.\n");
		}
	}
	
	
	/**
	 * Exibe o cabe�alho do modo de ordena��o crescente ou decrescente
	 * @param crescente
	 */
	public void informaCabecalhoModo(boolean crescente){	
        if (crescente == true) {
        	Prints.msgc("ORDEM CRESCENTE\n\n");
		}else{
			Prints.msgc("ORDEM DECRESCENTE\n\n");
		} 
	}
	
	
	/**
	 * M�todo respons�vel pela limpesa do vetor ap�s ordena��o,
	 * de modo que possa ter suas posi��es livres,
	 * quando uma pr�xima ordena��o for solicitada
	 */
	public void limpaVetor(){	
		for (int i = 0; i < vetor.length; i++) {
			vetor[i]= "";
		}
	}

//========================= << Ordena��o BubleSort >> ==============================
	
	public void ordenaBubleSort(boolean crescente, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (crescente == true) {	         			 
		                if (vetor[i].compareTo(vetor[j]) > 0) { // Ordem crescente  
		                	aux = vetor[i];                	
			                vetor[i] = vetor[j];
			                vetor[j] = aux;
			                trocas++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	aux = vetor[i];                	
		                	vetor[i] = vetor[j];
		                	vetor[j] = aux;
		                	trocas++;
		                }
	         		} 
	         	}
	         }	         	 
			imprimeBubleSort(crescente,mostraEstatisca);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	/**
	 * Informa dados estat�sticos espec�ficos da ordena��o
	 * @param mostraEstatica
	 */
	public void informaStatisticaBubleSort(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STICOS DA ORDENA��O\n"
				+"\nTamanho do vetor: "+tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: " );
		}
	}
	
	
	/**
	 * M�dodo de impress�o da lista de dados do ordenador BubleSort
	 * @param crescente
	 */
	public void imprimeBubleSort(boolean crescente,boolean mostraEstatisca){	
		informaCabecalhoModo(crescente);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		//Prints.msgl();
		informaStatisticaBubleSort(mostraEstatisca);
		limpaVetor();
	}
	
// ======================== << Ordena��o QuickSort >> ====================================
	
	int inicio = 0, fim = tamanho;
	 public void quick_sort() {
		   int meio;
		 
		   if (inicio < fim) {
		     meio = partition(vetor, inicio, fim);
		     quick_sort(vetor, ini, meio);
		     quick_sort(vetor, meio + 1, fim);
		   }
		 }
		 
		 public static int partition(int []v, int ini, int fim) {
		   int pivo, topo, i;
		   pivo = v[ini];
		   topo = ini;
		 
		   for (i = ini + 1; i <= fim; i++) {
		     if (v[i] < pivo) {
		       v[topo] = v[i];
		       v[i] = v[topo + 1];
		       topo++;
		     }
		   }
		   v[topo] = pivo;
		   return topo;
		 }
	
// << Menu de acesso aos ordenadores >>
	/**
	 * M�todo que define o modo de ordena��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	public boolean defineModoOrdencao() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) {
			return true;
			
		} else if (modo.equals("d")) {
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineModoOrdencao();
		}		
	}

	
	/**
	 * M�todo respons�vel pela sele��o dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		//quick_sort([]vetor, 0,tamanho);
		Prints.menuOrdenadores();
		
			
		switch (Prints.digita("")) {			
			
		case "buble":
			executaArquivo(Prints.digita("Nome do arquivo"));
			if (validaArquivo == true){
				ordenaBubleSort(defineModoOrdencao(),true);
			}
			selecionaOrdenador();			
			break;
		
		case "quick":		
			executaArquivo(Prints.digita("Nome do arquivo"));
			if (validaArquivo == true){
				//??(defineModoOrdencao(),true);
			}
			selecionaOrdenador();	
			selecionaOrdenador();
			break;
	
		case "comparar":		
		
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

	private void quick_sort(String linha2, int ini, int tamanho2) {
		// TODO Auto-generated method stub
		
	}
}