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
	int index = 0, trocas = 0 , tamanho = 100;
	String vetor[] = new String[tamanho];
	FileReader file;
	BufferedReader buff;
	String linha ,aux;

	
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
	 * @param modo
	 * @param exibirCabecalho
	 */
	private  void informaCabecalhoModo(boolean modo,boolean exibirCabecalho){	
		 if (exibirCabecalho == true) {
			if (modo == true) {
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
	 * @param modo
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private  void ordenaBuble(boolean modo, boolean mostraEstatisca) throws Exception{		
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
			imprimeOrdenacao(modo,mostraEstatisca,true,true);
		} catch (NullPointerException e) {
			Prints.msge("\nO vetor de armazanamento está definido como null!"); 			
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
	private int perticionaVetor(String vet[], int inicio, int fim) {
        String pivoInicio; 
        int i, pivoFim;
        
        pivoInicio = vetor[inicio];
        pivoFim = inicio;
        
        Prints.msg("\npivoInicio " +vetor[inicio] +"\n");
        
        for (i = pivoFim + 1; i <= fim; i++) {
            if (vetor[i].compareTo(vet[i]) > pivoInicio.compareTo(pivoInicio)) {
                vetor[pivoFim] = vetor[i];
                vetor[i] = vetor[pivoFim + 1];
                pivoFim++;
                trocas++;
            }
        }
        
        vetor[pivoFim] = pivoInicio;
        Prints.msg("\npivoFim " +pivoFim +"\n");
        return pivoFim;
    }
 
    
    /**
     * Método de execução do ordenador
     * @param vet
     * @param inicio
     * @param fim
     */
	private void executaQuick(String vet[], int inicio, int fim) {
        int meio;
        
        if (inicio < fim) {
            meio = perticionaVetor(vet, inicio, fim);
            Prints.msgr("\nMeio " +meio);
            executaQuick(vet, inicio, meio);
            executaQuick(vet, meio + 1, fim);
           
        }        
    }   
    
	
	/**
	 * Método reponsável pelo carregamento do erdenador
	 * @throws Exception
	 */
	private void carregaQuick() throws Exception {
    	executaArquivo("l.txt" /*Prints.digita("Nome do arquivo"))*/);
    	if (validaArquivo == true){
    		executaQuick(vetor, 1, (vetor.length - 1));
    		imprimeOrdenacao(true, true, false, true);
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
	 * @param mostraEstatisca
	 * @param limpar
	 * @param exibecabecalho
	 */
	private  void imprimeOrdenacao(boolean modo,boolean mostraEstatisca,boolean limpar,boolean exibecabecalho){	
		informaCabecalhoModo(modo,exibecabecalho);
		for (String dados : vetor){ 
        	if (dados != null && dados != "") {
            	Prints.msg(dados + " \n");  
        	}        	
		}
		Prints.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpar);
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
		switch (Prints.digita("")) {			
			
		case "buble":
			executaArquivo(Prints.digita("Nome do arquivo"));
			if (validaArquivo == true){
				ordenaBuble(defineModoOrdencao(),true);
			}
			selecionaOrdenador();			
			break;
		
		case "quick":		
			carregaQuick();			
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