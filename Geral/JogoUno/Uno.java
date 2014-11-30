import java.util.Scanner;

public class Uno {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		Carta carta = new Carta(Naipe.COPAS, 10);
		
		Baralho baralho = new Baralho(13);
		
		try{
			while (true){
				System.out.print(baralho.compra() + " ");
			}
		}catch (Exception e){
			
		}
		
	}
	
}