package M;

/**
 * Classe definidora da cordenadas
 * @author Grupo
 */
public class Coodenadas {
	protected static int x, y;
	protected static int custo;
	
	public static int getX() {
		return x;
	}
	
	public static void setX(int x) {
		Coodenadas.x = x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static void setY(int y) {
		Coodenadas.y = y;
	}
	
	public static int getCusto() {
		return custo;
	}
	
	public static void setCusto(int custo) {
		Coodenadas.custo = custo;
	}
}