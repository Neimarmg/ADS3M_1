package Model;

/**
 * Classe que define os niveis de jogo todos são estatico e finais 
 * @author Neimar,Aurelio
 */
public class NiveisMod {
	private static final int NIVEL1 = 1;
	private static final int MAPANIVEL1 = 10; //Tamanho do mapa 10x10
	private static final int PONTON1 = 6; //Pontos para cada nivel no mapa
	
	private static final int NIVEL2 = 2;
	private static final int MAPANIVEL2 = 15; //Tamanho do mapa 15x15
	private static final int PONTON2 = 12; //Pontos para cada nivel no mapa
	
	private static final int NIVEL3 = 3;
	private static final int MAPANIVEL3 = 20; //Tamanho do mapa 20x20
	private static final int PONTON3 = 21; //Pontos para cada nivel no mapa
	
	private static final int NIVEL4 = 4;
	private static final int MAPANIVEL4 = 25; //Tamanho do mapa 25x25
	private static final int PONTON4 = 30; //Pontos para cada nivel no mapa
	
	private static final int NIVEL5 = 5;
	private static final int MAPANIVEL5 = 30; //Tamanho do mapa 30x30
	private static final int PONTON5 = 42 ; //Pontos para cada nivel no mapa
	
	public static int getNivel1() {
		return NIVEL1;
	}
	
	public static int getMapanivel1() {
		return MAPANIVEL1;
	}
	
	public static int getNivel2() {
		return NIVEL2;
	}
	
	public static int getMapanivel2() {
		return MAPANIVEL2;
	}
	
	public static int getNivel3() {
		return NIVEL3;
	}
	
	public static int getMapanivel3() {
		return MAPANIVEL3;
	}
	
	public static int getNivel4() {
		return NIVEL4;
	}
	
	public static int getMapanivel4() {
		return MAPANIVEL4;
	}
	
	public static int getNivel5() {
		return NIVEL5;
	}
	
	public static int getMapanivel5() {
		return MAPANIVEL5;
	}
	
	public static int getPonton1() {
		return PONTON1;
	}
	
	public static int getPonton2() {
		return PONTON2;
	}
	
	public static int getPonton3() {
		return PONTON3;
	}
	
	public static int getPonton4() {
		return PONTON4;
	}
	
	public static int getPonton5() {
		return PONTON5;
	}

}
