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
	int index = 0, trocas = 0 , tamanho = 35;
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
	private int quickSortParticiona(String vet[], int inicio, int fim) {
        String pivo; 
        int i = 0, direita = 0;
        
        pivo = vet[inicio];
        direita = inicio;
        
        //Prints.msg("\npivoInicio " +vet[inicio] +"\n");
        
        for (i = inicio + 1; i <= fim; i++) {
        	//Prints.msg("\n\ni " +i +" fim "+fim +" cont "+trocas);
        	//Prints.msg("\nVET I: " +vetor[i] +" PIVO: "+pivo);
        	if (pivo.compareTo(pivo) > vetor[i].compareTo(vetor[i])) {
                
        		vetor[direita] = vetor[i];
                vetor[i] = vetor[direita + 1];
                direita++;
                trocas++;
                Prints.msg("\npassei ");
            }
        	//Prints.msg("\nvet " +vetor[i] +"\n");    
        }
        
        vet[direita] = pivo;
        //Prints.msg("\npivoFim " +topo +"\n");
        return direita;
    }
 
    
    /**
     * Método de execução do ordenador
     * @param vet
     * @param inicio
     * @param fim
     */
	private void quickSortOrdena(String vet[], int inicio, int fim) {
        int meio;
        
        if (inicio < fim) {
            meio = quickSortParticiona(vet, inicio, fim);
            	//Prints.msgr("\nMeio " +meio);
            quickSortOrdena(vet, inicio, meio);
            quickSortOrdena(vet, meio + 1, fim);
        }       
    }   
    
	
	/**
	 * Método reponsável pelo carregamento do erdenador QuickSort
	 * @throws Exception
	 */
	private void quickSortCarrega() throws Exception {
    	executaArquivo("l.txt" /*Prints.digita("Nome do arquivo"))*/);
    	
    	if (validaArquivo == true){
    		//imprimeOrdenacao(true, false, false, false);
    		quickSortOrdena(vetor, 1, (vetor.length - 1));
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
			//selecionaOrdenador();
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