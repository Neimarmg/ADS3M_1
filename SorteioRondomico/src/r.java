
import java.util.Random;
import java.util.Scanner;

public class r {
	static Scanner var = new Scanner(System.in);
	static String acum = "";
	static int qtNumeros;
	static int qtSorteios;		
	static int qtJogos;
	static float custo = 0;
	static Random radom  = new Random();
	
	
	public static void setAcum(String acum) {
		r.acum += acum;
	}
	
	public static String getAcum() {
		return acum;
	}
	
    public static String sorteiaNumeros(String jogo) {    	
    	acum += jogo +" =";
    	for(int i = 0; i < qtSorteios ;i++){ 
    		setAcum(" [" +radom.nextInt(qtNumeros)+"]");   	
 	    } 
    	setAcum("\n"); 
        return getAcum();        
	}
        
    public static void defineSorteios() {
	    for(int i = 0; i < qtJogos ;i++){ 	
			r.sorteiaNumeros("\n Jogo :" +i);
	   	}
    	System.out.println(getAcum());
    }
    
    public static void coletaDados() {
    	System.out.print("\nQuantidade de numeros do jogo:");
    	r.qtNumeros = var.nextInt();
    	System.out.print("\nQuantidade de numeros nos sorteios:");
    	r.qtSorteios = var.nextInt();
    	System.out.print("\nNumero de jogos:");
    	r.qtJogos = var.nextInt();
     	System.out.print("\nCusto por jogos:");
    	r.custo = var.nextFloat();  
    	System.out.print("\n=======================================\n");
    }
        
    public static float calculaCusto() {
    	return custo*qtJogos;
    }
    
    public static void caregaProcesso() {
    	coletaDados();
    	defineSorteios();
    	System.out.print("======================================="
    			+ "\n\nCusto total a pagar: R$ " +calculaCusto());
    }
        
    public static void main(String[] args) {    	
    	r.caregaProcesso();   	
    }
}
