package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Utilitarios.Prints;

/**
 *Classe responsavel pela ondenação de dados de arquivo 
 * @author Neimar e Aurélio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int index = 0, comparacoes = 0 , tamanho = 36;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux, pivo;
	long tempoExecucao;

	
	/**
	 * Método que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	private void leArquivo(String nomeArquivo) throws Exception {
		
		try {
			validaArquivo = true; // Abilita de execução de ordenador
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
			validaArquivo = false; // Desabilita a execução de ordenador
		} catch (IOException e) {
			Prints.msge("\nO arquivo não pode ser fechado.\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espaço insufiente no array de armazenamento.\n");
		}
	}
	
	
	/**
	 * Exibe o cabeçalho do modo de ordenação crescente ou decrescente
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
	 * Método responsável pela limpesa do vetor após ordenação,
	 * de modo que possa ter suas posições livres,
	 * quando uma próxima ordenação for solicitada
	 */
	private  void limpaVetor(boolean limparVetor){
		if(limparVetor == true){
			for (int i = 0; i < vetor.length; i++) {
				vetor[i]= "";				
			}
		}
		index = 0;
	}

	
	/**
	 * Método geral responsavel pela troca dos dados do no vetor
	 * @param i
	 * @param j
	 */
	private void trocaItens(int i, int j){
		aux = vetor[i];                	
        vetor[i] = vetor[j];
        vetor[j] = aux;	
	}
	
//========================= << Ordenação BubleSort >> ==============================
	
	/**
	 * Metodo responsavel pela ordenação dos dados captados do arquivo
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
		                   	trocaItens(i, j);
			                comparacoes++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { // Ordem decrescente  
		                	trocaItens(i, j);
		                	comparacoes++;
		                }
	         		} 
	         	}
	         }			
			tempoExecucao  = DateFormat.MILLISECOND_FIELD; 
			imprimeOrdenacao(ordem,mostraEstatisca,true,true);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento está definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Metodo respensalvel pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	private void bubleSortCarrega() throws Exception {
		leArquivo(Prints.digita("Nome do arquivo"));
		if (validaArquivo == true){
			bubleSortOrdena(defineOrdem(),true);
		}
		 
	}
	
// ======================== << Ordenação QuickSort >> ====================================

	
	
	
	
	public void quickSortOrdenar(String []vet, int inicio, int fim) {
		int i, j;
		
		pivo = vet[inicio+fim/2];
		for (i = inicio; i < vetor.length; i++) {

			/*
			for (j = inicio; j < vetor.length/2; j++) {
				if (pivo.compareTo(vetor[i]) < vet[j].compareTo(vet[j]) && fim/2 >= j ){
					trocaItens(i , j);
					comparacoes++;				
				}
			}
			
			for (j = fim -1 ; j >= vet.length - (fim -1)  ; j--) {
				
				if (pivo.compareTo(vetor[i]) > vet[j].compareTo(vet[j]) && fim/2 <= j ){
					trocaItens(i , j);
					comparacoes++;	
				}				
			}
			*/
			for (j = 1 ; j < vetor.length; j++){
				if (vetor[j].compareTo(vetor[j]) < 0 ){
					trocaItens(i , j);
					comparacoes++;
				}
					
			}
		}
		
	}
	
	
	public void quickSortExecuta(String []vet, int inicio, int fim ) {
		
		quickSortOrdenar(vet, inicio, fim);
		
	}	
	
	
	public void quickSortCarrega() throws Exception {
		leArquivo(Prints.digita("Nome do arquivo"));
		quickSortExecuta(vetor, 1 , tamanho);
		imprimeOrdenacao(true, true, true,  true);
	}
	
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * Informa dados estatísticos específicos da ordenação
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTATÍSTICOS DA ORDENAÇÃO\n"
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de comparacoes: " +comparacoes
				+"\nTempo total: " +tempoExecucao +"\n");
		}
	}
	
	
	/**
	 * Médodo de impressão da lista de dados dos ordenadores
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
	 * Método que define a ordem de ordenação para todos os ordenadores
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
			
		} else { // Comando de validação de modo de ordenação
			Prints.opcaoInvalida();			
			return defineOrdem();
		}		
	}

	
	
	/**
	 * Método responsável pela seleção dos comandos para execuçao dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Prints.menuOrdenadores();				
		switch (Prints.digita("")) {			
			
		case "buble":
			bubleSortCarrega();
			selecionaOrdenador();			
			break;
		
		case "quick":		
			quickSortCarrega();			
			//selecionaOrdenador();
			break;
	
		case "comparar":
			imprimeOrdenacao(false, true, true, false);
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