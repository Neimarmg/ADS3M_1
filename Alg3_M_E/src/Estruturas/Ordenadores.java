package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Utilitarios.Prints;

public class Ordenadores {
	
	String aux;
	int index = 0, trocas = 0;
	String vetor[] = new String[28];
	boolean controle;
	FileReader file;
	BufferedReader buff;
	String linha;


	/**
	 * Método de carregamento de dados do arquivo para um array de strings
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException 
	 */
	public  void executaArquivo(String nomeArquivo ) throws Exception {
		try {
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			while(linha != null ) {
				linha = buff.readLine();
				index++;
				if (linha != null) {
					vetor[index]= linha;				
				}					
			}			
			buff.close();
		} catch (FileNotFoundException e) {
			Prints.msge("\nArquivo inexistenten\n");
		} catch (IOException e) {
			Prints.msge("\nO arquivo não pode ser fechado\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espaço insufiente no array de armazenamento\n");
		}
	}
	
	
//================<<Ordenação BubleSort>>=====================
	
	public void ordenaBubleSort(boolean crescente) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){	
				controle = true;
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (crescente == true) {	         			 
		                if (vetor[i].compareTo(vetor[j]) > 0) { //Ordem crescente  
		                	aux = vetor[i];                	
		                	vetor[i] = vetor[j];
		                	vetor[j] = aux; 
		                	trocas++;
		                	controle = false;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { //Ordem descrescente  
		                	aux = vetor[i];                	
		                	vetor[i] = vetor[j];
		                	vetor[j] = aux;
		                	trocas++;
		                	controle = false;
		                }
	         		}
	         		
	         		if (crescente == true) {
						break;
					}
	         	}
			}			
			//imprimeBubleSort(crescente);
		} catch (NullPointerException e) {
			System.out.print("\n"); 
			imprimeBubleSort(crescente);
		}	    
	}
	
	
	/**
	 * Medodo de impressão da lista de dados do ordenador BubleSort
	 * @param crescente
	 */
	public void imprimeBubleSort(boolean crescente){	
        if (crescente == true) {
        	Prints.msgc("ORDEM CRESCENTE\n\n");
		}else{
			Prints.msgc("ORDEM DECRESCENTE\n\n");
		}		
		for (String dados : vetor) 
        	if (dados != null) {	
            	Prints.msg(dados + " \n");  
        	}
	}
	
	
//================<<Ordenação BubleSort>>=====================
	
	public  void ordenaQuickSort(){
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
//=======================<<>>=================================
	
	/**
	 * Imprime dados do vetor ordenados
	 */
	public  void imprime(){
		for (int i = 0; i < vetor.length; i++) {
			Prints.msg("" +vetor[i] +"\n");
		}
	}
		
	
	
	/**
	 * Método responsável pela seleção dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {	
		//Prints.menuOrdenadores();		
		executaArquivo("l.txt");
		ordenaBubleSort(false);
		/*switch (Prints.digita("")) {			
			
		case "buble":		
			
			selecionaOrdenador();
			break;
		
		case "quick":		
		
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
		}*/	
	}
}
