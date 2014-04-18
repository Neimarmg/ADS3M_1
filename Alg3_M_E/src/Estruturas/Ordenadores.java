package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;

public class Ordenadores {
	
	int v[]={1, 2, 3, 8, 4 ,6, 7, 5};
	int aux;
	boolean controle;
	String linha;
	
	
	/**
	 * Método de carregaento de arquivo
	 * @param nomeArquivo
	 */
	public  void executaArquivo(String nomeArquivo){
		try {
			FileReader f = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(f);
			linha = br.readLine();
			while(linha != null ) {
				linha = br.readLine();
				System.out.println(linha);
			}
			br.close();			
		} catch (FileNotFoundException e) {
			Prints.msgb("Nome do arquivo incorreto ou inexistente.");
			Prints.sair();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	
	
	

	
//================<<Ordenação BubleSort>>=====================
	
	public void ordenaBubleSort(){
		for (int i = 0; i < v.length; i++) {
			controle = true;
			for (int j = 0; j < v.length-1; j++) {
				if (v[j] > v[j+1]) {
					aux =v[j];
					v[j] =v[j+1];
					v[j+1] = aux;
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
		for (int i = 0; i < v.length; i++) {
			Prints.msg("" +v[i] +"\n");
		}
	}
		
	
	
	/**
	 * Método responsável pela seleção dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {	
		Prints.menuOrdenadores();		
					
		switch (Prints.digita("")) {			
			
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
		}	
	}
}
