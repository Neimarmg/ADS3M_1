package com.senac.jogos.labirinto;

public enum Direcao {
	NORTE("North", 0), 
	SUL("South", 1), 
	LESTE("East", 2), 
	OESTE("West", 3), 
	ACIMA("Up", 4), 
	ABAIXO("Down", 5);

	private String nameDir;
	private int index;

	public static Direcao converte(String direcao) throws Exception {
		if (direcao.equalsIgnoreCase("north") || direcao.equalsIgnoreCase("norte"))
			return NORTE;
		if (direcao.equalsIgnoreCase("south") || direcao.equalsIgnoreCase("sul"))
			return SUL;
		if (direcao.equalsIgnoreCase("east") || direcao.equalsIgnoreCase("leste"))
			return LESTE;
		if (direcao.equalsIgnoreCase("west") || direcao.equalsIgnoreCase("oeste"))
			return OESTE;
		if (direcao.equalsIgnoreCase("up") || direcao.equalsIgnoreCase("acima"))
			return ACIMA;
		if (direcao.equalsIgnoreCase("down") || direcao.equalsIgnoreCase("abaixo"))
			return ABAIXO;
		throw new Exception("Direcao nao valida.");
	}

	private Direcao(String s, int i) {
		this.nameDir = s;
		this.index = i;
	}

	public int getIndex() {
		return this.index;
	}

	public String toString() {
		return nameDir;
	}

	public static Direcao converte(int direcao) throws Exception {
		switch (direcao) {
		case 0:
			return NORTE;
		case 1:
			return SUL;
		case 2:
			return LESTE;
		case 3:
			return OESTE;
		case 4:
			return ACIMA;
		case 5:
			return ABAIXO;
		}
		throw new Exception("Direcao invalida.");
	}
}
