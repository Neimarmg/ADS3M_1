
package Model;

public class NaviosModel {
	
	private static int portaAvioes = 5;
	private static int QtPortaAvioes = 1;

	private static int destroyers = 4;
	private static int QtDestroyers = 1 ;
	
	private static int fragatas  = 3;
	private static int QtFragatas  = 1 ;
	
	private static int torpedeiros = 2;
	private static int QtTorpedeiros = 1 ;
	
	private static int submarinos = 1;
	private static int QtSubmarinos  = 1 ;
	
	//=================<<portaAvioes>>=================


	public static void setPortaAvioes(int portaAvioes) {
		NaviosModel.portaAvioes = portaAvioes;
	}
	
	public static int getPortaAvioes() {
		return portaAvioes;
	}
	
	public static void setQtPortaAvioes(int qtPortaAvioes) {
		QtPortaAvioes = qtPortaAvioes;
	}
	
	public static int getQtPortaAvioes() {
		return QtPortaAvioes;
	}

		
	//=================<< destroyers >>==================
	
	public static void setDestroyers(int destroyers) {
		NaviosModel.destroyers = destroyers;
	}
	
	public static int getDestroyers() {
		return destroyers;
	}
	
	public static void setQtDestroyers(int qtDestroyers) {
		QtDestroyers = qtDestroyers;
	}
	
	public static int getQtDestroyers() {
		return QtDestroyers;
	}
		
	//=================<< fragatas >>====================
	
	public static void setFragatas(int fragatas) {
		NaviosModel.fragatas = fragatas;
	}
	
	
	public static int getFragatas() {
		return fragatas;
	}
		
	public static void setQtFragatas(int qtFragatas) {
		QtFragatas = qtFragatas;
	}
	
	public static int getQtFragatas() {
		return QtFragatas;
	}
	
	
	//=================<< torpedeiros >>==================
	
	public static void setQtTorpedeiros(int qtTorpedeiros) {
		QtTorpedeiros = qtTorpedeiros;
	}
	
	public static int getTorpedeiros() {
		return torpedeiros;
	}
	
	public static void setTorpedeiros(int torpedeiros) {
		NaviosModel.torpedeiros = torpedeiros;
	}
	
	public static int getQtTorpedeiros() {
		return QtTorpedeiros;
	}
	//=================<< submarinos >>==================
	
	public static void setSubmarinos(int submarinos) {
		NaviosModel.submarinos = submarinos;
	}
	
	public static int getSubmarinos() {
		return submarinos;
	}
	
	public static void setQtSubmarinos(int qtSubmarinos) {
		QtSubmarinos = qtSubmarinos;
	}
	
	public static int getQtSubmarinos() {
		return QtSubmarinos;
	}
}
