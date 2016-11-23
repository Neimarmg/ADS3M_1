public class Pilha<T> {
	
	Object[] dados;
	int topo;
	
	public Pilha(int tam) throws Exception{
		if(tam < 1){
			throw new Exception("Tamanho de pilha invalido!");
		}
		dados = new Object[tam];
	}
	
	public void push(T valor) throws PilhaCheia{
		if(isFull()){
			throw new PilhaCheia();
		}
		
		dados[topo] = valor;
		topo ++;
	}
	
	public boolean isFull(){
		return topo == dados.length;
	}
	
	public T pop() throws PilhaVazia{
		if(isEmpty()){
			throw new PilhaVazia();
		}
		topo --;
		return ((T)dados[topo]);
	}

	public boolean isEmpty() {
		return topo == 0;
	}
	
}