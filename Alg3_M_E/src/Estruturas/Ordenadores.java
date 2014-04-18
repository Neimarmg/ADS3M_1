package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import Utilitarios.Prints;

public class Ordenadores {
	
	int aux, i = 0;
	static int tamanho = 1;
	String vetor[] = new String[1];
	boolean controle;
	FileReader file;
	BufferedReader buff;
	String linha;

	public static int getTamanho() {
		return tamanho;
	}
	
	/**
	 *  
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public  void defineTamanhaVetor(String nomeArquivo ) throws IOException{
		file = new FileReader(nomeArquivo);		
		buff = new BufferedReader(file);
		linha = buff.readLine();
		
		while(linha != null ) {
			linha = buff.readLine();
			tamanho++;		
		}
		
		Prints.msg("\t" +getTamanho() +"\n");
	}
	
	
	
	/**
	 * Método de carregamento de arquivo para um array de strings
	 * @param nomeArquivo
	 * @throws IOException 
	 */
	public  void executaArquivo(String nomeArquivo ) {
		
		try {
			defineTamanhaVetor(nomeArquivo);
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			vetor[1] = new String[getTamanho()];
			while(linha != null ) {
				linha = buff.readLine();
				i++;
				if (linha != null) {
					vetor[i]= linha;	
					Prints.msg("\n" +i +" " +vetor[i]);
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
	
	public void ordenaBubleSort(){
		
		for (int i = 0; i < vetor.length; i++) {
			controle = true;
			for (int j = 0; j < vetor.length-1; j++) {
				if (vetor[j] > vetor[j+1]) {
					aux =vetor[j];
					vetor[j] =vetor[j+1];
					vetor[j+1] = aux;
					controle = false;					
				}		
			}
			if (controle == true) {
				break;
			}
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
