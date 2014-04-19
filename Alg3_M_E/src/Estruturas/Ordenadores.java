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
	 * Método de carregamento de dados do arquivo para um array de strings
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
			Prints.msge("\nO arquivo não pode ser fechado\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			Prints.msge("\nO Espaço insufiente no array de armazenamento\n");
		}
	}
	
	
	/**
	 * Exibe o cabeçalho do modo de ordenação crescente ou decrescente
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
	 * Método responsável pela limpesa do vetor após ordenação
	 * de modo que possa ter suas posições livres quando uma próxima ordenação for solicitada.
	 */
	public void limpaVetor(){	
		for (int i = 0; i < vetor.length; i++) {
			vetor[i]= "";
		}
	}

//================<< Ordenação BubleSort >>=================================================
	
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
	 * Imforma dados estatíticos específicod da ordenção
	 * @param mostraEstatica
	 */
	public void informaStatisticaBubleSort(boolean mostraEstatisca){	
		if (mostraEstatisca == true) { 
			Prints.msg(
				"\nDADOS ESTATÍSTCOS DA ORDENAÇÃO\n"
				+"\nTamanho do vetor: "+tamanho
				+"\nTotal de trocas: " +trocas
				+"\nTempo total: " );
		}
	}
	
	
	/**
	 * Medodo de impressão da lista de dados do ordenador BubleSort
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
	
	
//================<< Ordenação QuickSort >>=================================================
	
	public  void ordenaQuickSort(){
	
	
	
	}
		
	
	
	
//==============<< Menus de acesso ao ordenadores >>========================================
	/**
	 * Método que define o modo de ordanção para todos os ordenadores
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
			
		}else{//Comando de validação de modo de ordenação
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
