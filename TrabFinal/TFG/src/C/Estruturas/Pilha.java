package C.Estruturas;

import M.PilhaModel;
import M.Utilitarios.Auxiliar;
import V.View;

/**
 * Classe de execução da pilha
 * @author Neimar
 */
public class Pilha extends PilhaModel {
	
	/**
	 * Contrutor da classe	
	 * @param tamanhaDaPilha
	 */
	public Pilha(int tamanhaDaPilha) {
		getPonteiro().setPosicao(-1);
		setTamanho(tamanhaDaPilha);
		vetor = new Object[getTamanho()];
	}
	
	
	/**
	 * Verifica se a pilha está vazia	
	 * @return
	 */
	public boolean eVazia() {
		if (getPonteiro().getPosicao(0) == -1) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Retorana o tamanho da pilha
	 * @return
	 */
	public int tamanho() {
		if (eVazia()) {
			return 0;
		
		} else {
			return getPonteiro().getPosicao(1);
		}	
	}
	
	
	/**
	 * Permite a visualuzação do último ítem da pilha
	 * @return
	 */
	public Object ultimo() {
		if (eVazia()) {
			return null;
		} else {
			return vetor[getPonteiro().getPosicao(0)];
		}		
	}
	
	
	/**
	 * Desempilha elementos da pilha	
	 * @return
	 */
	public Object desempilha() {
		if (eVazia()) {
			return null;
		} else {
			return vetor[getPonteiro().getPosicao(-1)];
		}		
	}
		
	
	/**
	 * Empilha elementos da pilha
	 * @param elemento
	 */
	public void empilha(Object elemento) {
		if (getPonteiro().getPosicao(0) < getVetor().length - 1) {
			vetor[getPonteiro().getPosicao(2)] = elemento;
		}	
	}
	
	
	/**
	 * Método de impressão da pilha personalizada
	 * @param exibirPropriedades
	 * @param mostrarCabecalho
	 */
	public void imprime(boolean exibirPropriedades, boolean mostrarCabecalho) {
		if (mostrarCabecalho == true) {	
			View.msgc("Elemento(s) empilhado(s):\n");
		} else {
			View.msgc("");
		}
		
		
		if (eVazia() == true) {
			View.msge("\nPilha vazia!\n");
		}
			
		
		while (eVazia() == false) {
			View.msg(desempilha() +"\n");
			Auxiliar.setContador(true);
		}
		
		
		if (exibirPropriedades == true) {
			View.msgr("\nTamanho da pilha: " + getTamanho() 
					+ "\nElementos empilhados: "  + Auxiliar.getContador()
					+ "\nLivres: " +(getTamanho() - Auxiliar.getContador()));
			Auxiliar.setContador(false);
		} else {
			Auxiliar.setContador(false);
		}
	}
	
}