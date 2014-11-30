import sun.net.www.content.text.plain;

public class fila {
	private String [] dados;
	private int heard;
	private int tail=0;
	
	public boolean isEmpty(){
		return (heard == tail);
	}
	
	
	public boolean isFull(){
		return (tail == dados.length;
	}
	
	public String peck() {
		if (!isEmpty()){
				return dados[heard];
		}return null;
		
		if (!isEmpty()){
			dados[tail]= value;
			tail++;
		}	
	}
	
	private void puch(String value) {
		//????
	}
	
	private void pop() {
		if (!isEmpty()){
			dados[heard]= null;
			heard++;
		}	
	}
	
	
	
	
	
	
	
	//public static void main(String[] args) {
	//}

}
