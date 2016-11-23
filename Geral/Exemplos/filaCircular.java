public class filaCircular {
		private String [] dados;
		private int heard;
		private int tail=0;
		
		public boolean isEmpty(){
			return (heard == tail);
		}
				
		public boolean isFull(){
			return nextIndex(tail) == heard;
		}
		
		public int nextTail(){
			// calculo que retorna o resto da divisão da possisao isso faz com que o vetor de a volta
			return (tail + 1)% dados.length;
		}
		
		public String peck() {
			if (!isEmpty()){
					return dados[heard];
			}return null;			
	
		}
		
		private void puch(String value) {
			if (!isEmpty()){
				return ;
			}
			//Situação que esta cheia quando o o tail esta atras do heard 8 e 0 
			dados[tail] =value;
			tail= (tail + 1)% dados.length;
		}
		
		
		private void pop() {
			if (!isEmpty()){
				return;
			}			
			heard = nextIndex(heard);			
		}
		
		public int nextIndex(int index){
			return (index +1) % dados.length;
		}
		

}
