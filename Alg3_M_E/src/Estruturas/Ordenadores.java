package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;

/**
 *Classe responsavel pela ondena��o de dados de arquivo 
 * @author Neimar e Aur�lio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int index = 0, trocas = 0 , tamanho = 34;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux;

	
	/**
	 * M�todo que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	private void executaArquivo(String nomeArquivo) throws Exception {
		
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
			//Aumenta tamanho do vetor.
			for (int i = index; i < vetor.length; i++) {
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
	        	Prints.msgc("ORDEM CRESCENTE\n\n");
			}else{
				Prints.msgc("ORDEM DECRESCENTE\n\n");
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
	}

	
	
//========================= << Ordena��o BubleSort >> ==============================
	
	/**
	 * Metodo responsavel pela ordena��o dos dados captados do arquivo
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void bubleSortOrdena(boolean ordem, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (ordem == true) {	         			 
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
			imprimeOrdenacao(ordem,mostraEstatisca,true,true);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento est� definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Metodo respensalvel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void bubleSortCarrega() throws Exception {
		executaArquivo(Prints.digita("Nome do arquivo"));
		if (validaArquivo == true){
			bubleSortOrdena(defineOrdem(),true);
		}
	}
	
// ======================== << Ordena��o QuickSort >> ====================================
	
	/**
	 * Metodo reponsavel para o particionamento do vetor
	 * @param vet
	 * @param inicio
	 * @param fim
	 * @return
	 */
	private void quickSortParticiona(String []vet, int esq, int dir,int i, int j) {
		try {	
			String pivo;
			i = esq; 
			j = dir;		
			
			pivo = vetor[i + j/2]; /* obtem o pivo */
			
			do {			
				//while (vetor[i].compareTo(vetor[i]) > pivo.compareTo(pivo))(i)++;
				
				//while (vetor[j].compareTo(vetor[j]) < pivo.compareTo(pivo))(j)--;	

					
				if (i <= j ) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					(i)++; (j)--;
					trocas++;
				}
									
			} while (i <= tamanho);

		} catch (NullPointerException e) {
			e.getMessage();
		}
    }
 

    /**
     * M�todo de execu��o do ordenador
     * @param vet
     * @param inicio
     * @param fim
     */
	private void quickSortOrdena(String []vet, int esq, int dir) {
		int i = 0 , j = 0;
		imprimeOrdenacao(true, true, true, true);
		quickSortParticiona(vet, esq, dir, i, j);
		if (esq <= j)quickSortOrdena(vet, esq, j);
		if (i <= dir)quickSortOrdena(vet, i, dir);  
    }   
    
	
	/**
	 * M�todo repons�vel pelo carregamento do erdenador QuickSort
	 * @throws Exception
	 */
	private void quickSortCarrega() throws Exception {
    	executaArquivo("l.txt" /*Prints.digita("Nome do arquivo"))*/);
    	
    	if (validaArquivo == true){
    		imprimeOrdenacao(true, false, false, false);
    		quickSortOrdena(vetor, 1, tamanho-1);
    		imprimeOrdenacao(true, true, true, true);
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
				"\nDADOS ESTAT�STICOS DA ORDENA��O\n"
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: \n" );
		}
	}
	
	
	/**
	 * M�dodo de impress�o da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private  void imprimeOrdenacao(boolean ordem,boolean mostraEstatisca,boolean limpaVetor,boolean exibecabecalho){	
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
	private boolean defineOrdem() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) { //Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { //Define ordem decrescete
			return false;
			
		} else { // Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineOrdem();
		}		
	}

	
	
	/**
	 * M�todo respons�vel pela sele��o dos comandos para execu�ao dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		//Prints.menuOrdenadores();				
		switch ("quick" /*Prints.digita("")*/) {			
			
		case "buble":
			bubleSortCarrega();
			selecionaOrdenador();			
			break;
		
		case "quick":		
			quickSortCarrega();			
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
}