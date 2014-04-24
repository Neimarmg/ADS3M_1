package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;

/**
 *Classe responsavel pela ondenação de dados de arquivo 
 * @author Neimar e Aurélio
 */
public class Ordenadores {
	
	boolean validaArquivo; 
	int index = 0, trocas = 0 , tamanho = 34;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux;

	
	/**
	 * Método que carrega dados do arquivo para um "array" de "strings"
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	private void executaArquivo(String nomeArquivo) throws Exception {
		
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
			//Aumenta tamanho do vetor.
			for (int i = index; i < vetor.length; i++) {
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
			Prints.msge("\nO vetor de armazanamento está definido como null!"); 			
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
	
// ======================== << Ordenação QuickSort >> ====================================
	
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
     * Método de execução do ordenador
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
	 * Método reponsável pelo carregamento do erdenador QuickSort
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
	 * Informa dados estatísticos específicos da ordenação
	 * @param mostraEstatica
	 */
	private  void informaStatistica(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTATÍSTICOS DA ORDENAÇÃO\n"
				+"\nTamanho do vetor: " +tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: \n" );
		}
	}
	
	
	/**
	 * Médodo de impressão da lista de dados dos ordenadores
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