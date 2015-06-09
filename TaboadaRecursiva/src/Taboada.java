
public class Taboada {
	static int numerador = 0, denomidor = 0;	
	
	public static String calcula(){
		denomidor++;
		return denomidor +" * " +numerador +" = " +(denomidor * numerador);
	}
	
	public static void imprime(){
		if (denomidor < 10) {
			 System.out.println(calcula());
			 imprime();
		}else{
			numerador++;
			denomidor = 0;
		}			
	}
	
	public static void taboada(int tabAte){
		if (numerador < tabAte) {
			System.out.println("\nTaboada do: "+numerador); 
			imprime();
			taboada(tabAte);
		}		
	}
	
	public static void main(String[] args) {
		Taboada.taboada(10);
	}
}