package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;

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
	private int esquerda;
	
	//Ficheiro ficheiro = new Ficheiro();
	
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
	 * @param crescente
	 */
	private  void informaCabecalhoModo(boolean crescente){	
        if (crescente == true) {
        	Prints.msgc("ORDEM CRESCENTE\n\n");
		}else{
			Prints.msgc("ORDEM DECRESCENTE\n\n");
		} 
	}
	
	
	/**
	 * Método responsável pela limpesa do vetor após ordenação,
	 * de modo que possa ter suas posições livres,
	 * quando uma próxima ordenação for solicitada
	 */
	private  void limpaVetor(){	
		for (int i = 0; i < vetor.length; i++) {
			vetor[i]= "";
		}
	}

	
	
//========================= << Ordenação BubleSort >> ==============================
	
	/**
	 * Metodo responsavel pela ordenação dos dados captados do arquivo
	 * @param modo
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBubleSort(boolean modo, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (modo == true) {	         			 
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
			imprimeOrdenacao(modo,mostraEstatisca);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento está definido como null!"); 			
		}	    
	}
	
	
	
// ======================== << Ordenação QuickSort >> ====================================
	
	public static void quicksort(int vet[], int ini, int fim) {
        int meio;
 
        if (ini < fim) {
            meio = partition(vet, ini, fim);
            quicksort(vet, ini, meio);
            quicksort(vet, meio + 1, fim);
        }
    }
 
    public static int partition(int vet[], int ini, int fim) {
        int pivo, topo, i;
        pivo = vet[ini];
        topo = ini;
        Prints.msg("\npivo " +pivo +"\n");
        for (i = ini + 1; i <= fim; i++) {
            if (vet[i] < pivo) {
                vet[topo] = vet[i];
                vet[i] = vet[topo + 1];
                topo++;
            }
        }
        vet[topo] = pivo;
        return topo;
    }
 
    
    public static void ma() {
 
        //Scanner in = new Scanner(System.in);
 
    	int v[] = new int[35];
        int i;
 	
        for (i = 0; i < v.length; i++) {
            v[i] = i*-3/2 ;
            System.out.println((i + 1) + "° número: " + v[i]);
        }
 
        quicksort(v, 0, (v.length - 1));
 
       
        for (i = 0; i < v.length; i++) {        	
            System.out.println((i + 1) + "° número: " + v[i]);
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
	 * @param modo
	 */
	private  void imprimeOrdenacao(boolean modo,boolean mostraEstatisca){	
		informaCabecalhoModo(modo);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor();
	}


	/**
	 * Método que define o modo de ordenação para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	private boolean defineModoOrdencao() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) {
			return true;
			
		} else if (modo.equals("d")) {
			return false;
			
		} else { // Comando de validação de modo de ordenação
			Prints.opcaoInvalida();			
			return defineModoOrdencao();
		}		
	}

	
	/**
	 * Método responsável pela seleção dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		
		Prints.menuOrdenadores();				
		switch ("quick" /*Prints.digita("")*/) {			
			
		case "buble":
			executaArquivo(Prints.digita("Nome do arquivo"));
			if (validaArquivo == true){
				ordenaBubleSort(defineModoOrdencao(),true);
			}
			selecionaOrdenador();			
			break;
		
		case "quick":		
			executaArquivo("l.txt" /*Prints.digita("Nome do arquivo"))*/);
			if (validaArquivo == true){
				ma();
				//imprimeOrdenacao(true, true);
			}
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