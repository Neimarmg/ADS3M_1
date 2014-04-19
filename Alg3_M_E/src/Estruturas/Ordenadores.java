package Estruturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utilitarios.Prints;

public class Ordenadores {
	
	String aux;
	int index = 0, trocas = 0 , tamanho = 100;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha;

	/**
	 * M�todo de carregamento de dados do arquivo para um array de strings
	 * @param nomeArquivo
	 * @throws Exception 
	 * @throws IOException z
	 */
	public  void executaArquivo(String nomeArquivo ) throws Exception {
		try {
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
			Prints.msge("\nArquivo inexistenten\n");
		} catch (IOException e) {
			Prints.msge("\nO arquivo n�o pode ser fechado\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espa�o insufiente no array de armazenamento\n");
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
	 * M�todo respons�vel pela limpesa do vetor ap�s ordena��o
	 * de modo que possa ter suas posi��es livres quando uma pr�xima ordena��o for solicitada.
	 */
	public void limpaVetor(){	
		for (int i = 0; i < vetor.length; i++) {
			vetor[i]= "";
		}
	}

//================<< Ordena��o BubleSort >>=================================================
	
	public void ordenaBubleSort(boolean crescente, boolean mostraEstatisca) throws Exception{		
		try {
			for (int i = 1; i < vetor.length; i++){
	         	for (int j = i+1; j < vetor.length; j++){	         		
	         		if (crescente == true) {	         			 
		                if (vetor[i].compareTo(vetor[j]) > 0) { //Ordem crescente  
		                	aux = vetor[i];                	
			                vetor[i] = vetor[j];
			                vetor[j] = aux;
			                trocas++;
		                }
	         		}else{
		                if (vetor[i].compareTo(vetor[j]) < 0) { //Ordem descrescente  
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
			Prints.msge("\nO vetor de armazanamento esta definido como null!"); 			
		}	    
	}
	
	/**
	 * Imforma dados estat�ticos espec�ficod da orden��o
	 * @param mostraEstatica
	 */
	public void informaStatisticaBubleSort(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTAT�STCOS DA ORDENA��O\n"
				+"\nTamanho do vetor: "+tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: " );
		}
	}
	
	
	/**
	 * Medodo de impress�o da lista de dados do ordenador BubleSort
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
	
	
//================<< Ordena��o QuickSort >>=================================================
	
	public  void ordenaQuickSort(){
	
	
	
	}
		
	
	
	
//==============<< Menus de acesso ao ordenadores >>========================================
	/**
	 * M�todo que define o modo de ordan��o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	public boolean defineModoOrdencao() throws Exception{	
		Prints.menuModoOrdenacao();
		String modo  = Prints.digita("Modo");
		
		if (modo.equals("c")) {
			return true;
			
		}else if (modo.equals("d")){
			return false;
			
		}else{//Comando de valida��o de modo de ordena��o
			Prints.opcaoInvalida();			
			return defineModoOrdencao();
		}		
	}


	/**
	 * M�todo respons�vel pela sele��o dos ordenadores
	 * @throws Exception
	 */
	public void selecionaOrdenador() throws Exception {			
		Prints.menuOrdenadores();		
			
		switch (Prints.digita("")) {			
			
		case "buble":
			executaArquivo(Prints.digita("Nome do arquivo "));			
			ordenaBubleSort(defineModoOrdencao(),true);
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
