package M;

/**
 * Classo de gravacao do nodo
 * @author Neimar, Aurelio *
 * @param <T>
 */
public class NodoM<T>{
	protected NodoM<T> pai;
	private NodoM<T> esq;
	private NodoM<T> dir;
	private T valor;
	
	public void setDir(NodoM<T> dir) {
		this.dir = dir;
	}
	
	public NodoM<T> getDir() {
		return dir;
	}
	
	public void setEsq(NodoM<T> esq) {
		this.esq = esq;
	}
	
	public NodoM<T> getEsq() {
		return esq;
	}
	
	public void setPai(NodoM<T> pai) {
		this.pai = pai;
	}
	
	public NodoM<T> getPai() {
		return pai;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
}
