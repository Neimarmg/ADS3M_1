package M;

import M.Utilitarios.Auxiliar;

/**
 * Defição da estrutura da pila
 * @author Neimar
 */
public class PilhaModel {
	
	protected int tamanho;	
	protected Object[] vetor;
	protected Auxiliar ponteiro =  new Auxiliar();
	
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
	public int getTamanho() {
		return tamanho;
	}

	
	public Object[] getVetor() {
		return vetor;
	}	
	
	
	/**
	 * Restaura o estado atual do objeto compartilhado
	 * @return
	 */
	public Auxiliar getPonteiro() {
		return ponteiro;
	}
	
}