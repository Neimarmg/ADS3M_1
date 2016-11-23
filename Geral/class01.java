import java.util.Scanner;
public class class01 {
	public static int SC[]  = new int [10],  tanque = 6, posicao = 0;
	private static Scanner s;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int avancar = 0, retroceder = 0, carregar = 0, descarregar = 0;
		System.out.println("*T R A V E S S I A   N O   D E S E R T O *");
		System.out.println();
		while (true) {
			System.out.print("1- AVANCAR 2- RETROCEDER 3- CARREGAR 4- DESCARREGAR: ");
			int option = s.nextInt();
			switch (option) {
				case 1:
					System.out.print("Posicoes a avancar: ");
					avancar = s.nextInt();
					tanque = tanque - avancar;
					if (tanque < 0) metodo01();
					posicao = posicao + avancar;
					if (posicao == 10) {
						System.out.println();
						System.out.println("* P O S I C A O   F I N A L   A L C A N C A D A *");
						System.out.println("------------------------------------------------------");
						System.exit(0);
					}
					if (posicao > 10) {
						System.out.println();
						System.out.println("* M O V I M E N T O   I N V A L I D O *");
						System.out.println("------------------------------------------------------");
						break;
					}
					metodo02();
					break;
				case 2: {
					if (posicao == 0) {
						System.out.println();
						System.out.println("* AVANCE ALGUMA POSICAO ANTES DE RETROCEDER *");
						System.out.println("------------------------------------------------------");
						break;
					}
					System.out.print("Posicoes a retroceder: ");
					retroceder = s.nextInt();
					if (posicao > 0) posicao = posicao - retroceder;
					tanque = tanque - retroceder;
					if (posicao == 0 && (SC[0]) >= 0) {
						System.out.println();
						System.out.println(" * P O S I C A O   I N I C I A L *");
						System.out.println();
						System.out.println("* T A N Q U E   C A R R E G A D O *");
						System.out.println("------------------------------------------------------");
						tanque = 6;
						break;
					} else if (posicao == 0 && (SC[posicao - 1] >= 1)) {
						System.out.println();
						System.out.println("* T A N Q U E   C A R R E G A D O *");
						System.out.println("------------------------------------------------------");
						tanque = 6;
						break;
					} if (tanque <= -1) metodo01();
				    metodo02();
					break;
				}
				case 3: {
					if (posicao == 0) {
						System.out.println();
						System.out.println("* AVANCE ALGUMA POSICAO ANTES DE CARREGAR *");
						System.out.println("------------------------------------------------------");
						break;
					}
					System.out.print("Galoes a carregar: ");
					carregar = s.nextInt();
					if (carregar > 6) {
						System.out.println();
						System.out.println("* V A L O R   I N V A L I D O   P A R A   C A R G A *");
						System.out.println("------------------------------------------------------");
						break;
					}
					if (SC[posicao - 1] >= carregar) {
						SC[posicao - 1] = SC[posicao - 1] - carregar;
						tanque = tanque + carregar;
						metodo02();
					} else {
						System.out.println();
						System.out.println("* C O M B U S T I V E L   I N D I S P O N I V E L *");
						System.out.println("------------------------------------------------------");
					}	
					break;
				}
				case 4: {
					if (posicao == 0) {
						System.out.println();
						System.out.println("* AVANCE ALGUMA POSICAO ANTES DE DESCARREGAR *");
						System.out.println("------------------------------------------------------");
						break;
					}
					System.out.print("Galoes a descarregar: ");
					descarregar = s.nextInt();
					if ((SC[posicao - 1] + descarregar) > 9) {
						System.out.println();
						System.out.println("* G A L O E S   E X C E D I D O S *");
						System.out.println("------------------------------------------------------");
						break;
					}
					SC[posicao - 1]  = SC[posicao - 1] + descarregar;
					tanque = tanque - descarregar;
					if (tanque >= 0) metodo02();
					if (tanque <  0) metodo01();
					break;
				}
			}
		}
	}
	public static void metodo01() {
		System.out.println();
		System.out.print("* C O M B U S T I V E L   I N D I S P O N I V E L *");
		System.out.println();
		System.out.println();
		System.out.print("          * J O G O   E N C E R R A D O *");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.exit(0);
	}
	public static void metodo02() {
		for (int x = 0; x <= 9; x++) {
			System.out.print(SC[x]);
		}
		System.out.print("   G a l o e s   d e s c a r r e g a d o s");
		System.out.println();
		for (int y = 1; y <= 10; y++) {
			if (y != posicao) System.out.print(" ");
			if (y == posicao) {
				System.out.println("C");
				System.out.println("0123456789   T r a j e t o");
				metodo03();
				break;
			}
		}
	}
	public static void metodo03() {
		if (tanque <= 1) System.out.println("Situacao do tanque: " + tanque + " galao.");
		if (tanque >= 2) System.out.println("Situacao do tanque: " + tanque + " galoes.");
		System.out.println("------------------------------------------------------");
	}
}
