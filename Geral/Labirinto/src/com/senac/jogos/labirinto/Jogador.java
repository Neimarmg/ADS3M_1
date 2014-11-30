package com.senac.jogos.labirinto;

public class Jogador extends Personagem {

	private Arma arma;
	private Armadura armadura;
	private Chave chave;

	public Jogador() {
		super(1, 1, 20);
		this.arma = null;
		this.armadura = null;
		this.chave = null;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) throws Exception {
		if (this.arma == null)
			throw new Exception("Uma arma foi encontrada");
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) throws Exception {
		if (this.armadura == null)
			throw new Exception("Uma arma foi encontrada");
		this.armadura = armadura;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) throws Exception {
		if (this.arma == null)
			throw new Exception("Uma arma foi encontrada");
		this.chave = chave;
	}

	public int getAtaque() {
		int bonus = 0;
		if (arma != null)
			bonus += arma.getDano();
		return ataque + bonus;
	}
	
	public void setDano(int value) {
		int total = value - resistencia;
		if (armadura != null)
			total -= armadura.getResistencia();
		vida -= total;
	}

	public void mataJogador() {
		this.vida = 0;
	}

	public void mataArmadura() {
		this.armadura = null;
	}

	public void mataArma() {
		this.arma = null;
	}

	public void destroiChave() {
		this.chave = null;
	}

	public String toString() {
		int ataq = 0;
		ataq = ataque;

		int defesa = 0;
		defesa = resistencia;

		if (armadura != null) {
			defesa += armadura.getResistencia();
		}

		if (arma != null) {
			ataq += arma.getDano();
		}

		return "Jogador" + "\nVida: " + vida + "\nAtaque: " + ataq
				+ "\nDefesa: " + defesa;
	}
}
