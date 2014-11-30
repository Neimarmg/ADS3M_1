package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public class Labirinto {

	private static final Scanner teclado = new Scanner(System.in);

	private Sala[] salas;
	private int countSalas;
	private int salaAtual;
	private Jogador jogador;

	public void iniciaJogo(){
		leComando();
	}	
	
	
	public void leComando() 
	{
		inicializaLabirinto();

		do {
			out.println();
			exibeStatus();
			executaComando(teclado.nextLine());
		} while (!isGameOver());

		if (!jogador.isAlive()) {
			out.println("Voce Perdeu o jogo!");
		} else {
			out.println("Voce Ganhou o jogo");
		}

		teclado.close();
	}

	
	//@SuppressWarnings("resource")
	public void executaComando(String escolha) 
	{
		try {
			Scanner linha = new Scanner(escolha.toLowerCase());
			int cmd = converteComando(linha.next());

			if (!linha.hasNext())
				throw new Exception("COMANDO INCOMPLETO: esta faltando o segundo atributo");

			String s = linha.next();
			while (linha.hasNext())
				s += " " + linha.next();

			s = s.toLowerCase();

			switch (cmd) {
			case 1:
				Move(s);
				break;
			case 2:
				olha(s);
				break;
			case 3:
				ataca(s);
				break;
			case 4:
				soltaItem(s);
				break;
			case 5:
				pegaItem(s);
				break;
			}

		} catch (Exception e) {
			err.println(e.getMessage());
			return;
		}
	}

	
	public void pegaItem(String item) throws Exception 
	{
		Sala sala = salas[salaAtual];

		List<Item> itens = sala.getItens();
		for (Item i : itens) {
			if (item.equalsIgnoreCase(i.getDescricao())) {
				if (i instanceof Chave)
					jogador.setChave((Chave) i);
				if (i instanceof Arma)
					jogador.setArma((Arma) i);
				if (i instanceof Armadura)
					jogador.setArmadura((Armadura) i);

				itens.remove(i);
				return;
			}
		}

		throw new Exception("Item invalido");
	}
	

	public void soltaItem(String item) throws Exception 
	{
		Sala sala = salas[salaAtual];
		List<Item> itens = sala.getItens();

		if (item.equals("chave")) {
			itens.add(jogador.getChave());
			jogador.destroiChave();

		} else if (item.equals("arma")) {
			itens.add(jogador.getArma());
			jogador.mataArma();

		} else if (item.equals("armadura")) {
			itens.add(jogador.getArmadura());
			jogador.mataArmadura();

		} else
			throw new Exception("Item invalido");
	}

	
	public void ataca(String s) throws Exception 
	{
		Conexao conexao = getConexao(s);
		Inimigo inimigo = conexao.getInimigo();

		if (inimigo == null)
			throw new Exception("Sem inimigos no ataque");

		if (inimigo instanceof Armadilha) {
			if (Range.getPercentual() >= 80) {
				conexao.setInimigo(null);
				out.println("Armadilha desfeita!");
			} else {
				jogador.setDano(2 + jogador.getArmadura().getResistencia());
				out.println("FALHOU: a armadilha nao pode ser desarmada - 2pts de danos sofreu o jogador");
			}
		} else {
			atacaInimigo(inimigo);
			atacaJogador(inimigo);
			if (!inimigo.isAlive()) {
				out.println("Voce derrotou o " + inimigo + "\n");
				conexao.setInimigo(null);
			}
		}
	}

	
	public void atacaInimigo(Inimigo inimigo) 
	{
		if (Range.getPercentual() >= 20) {
			int ataque = jogador.getAtaque();
			inimigo.setDano(ataque);
			out.println("O " + inimigo + " recebeu " + ataque + " em danos.");
		} else {
			out.println("O " + inimigo + " conseguiu se defender.");
		}
	}

	
	public void atacaJogador(Inimigo inimigo) 
	{
		if (Range.getPercentual() >= 40) {
			int ataque = inimigo.getAtaque();
			jogador.setDano(ataque);
			out.println("O jogador recebeu " + (ataque) + " em danos do "
					+ inimigo);
			out.println(jogador);
		} else {
			out.println("O jogador conseguiu defender-se do ataque do "
					+ inimigo);
		}
	}


	public void olha(String direcao) throws Exception 
	{
		Conexao conexao = getConexao(direcao);

		out.println(conexao.getInfo());
	}

	
	public void Move(String direcao) throws Exception 
	{
		Conexao conexao = getConexao(direcao);
		Inimigo inimigo = conexao.getInimigo();
		
		if (inimigo != null) {
			if (inimigo instanceof Armadilha) {
				jogador.mataJogador();

				throw new Exception(
						"O jogador acaba de morrer em uma armadilha.");
			} else {
				throw new Exception("O jogador tem de lutar e vencer o " + inimigo
						+ " para continuar no labirinto.");
			}
		}

		Cor porta = conexao.getCor();
		if (porta != Cor.MARROM) {
			Chave chave = jogador.getChave();
			if (chave == null || chave.getCor() != porta)
				throw new Exception("O jogador necessita da chave: " + porta
						+ " para poder prosseguir");
		}

		salaAtual = conexao.getSala();
	}

	
	public boolean isGameOver() 
	{
		if (!jogador.isAlive())
			return true;

		if (salaAtual == 0)
			return true;

		return false;
	}

	
	public Conexao getConexao(String direc) throws Exception 
	{
		Direcao direcao = Direcao.converte(direc);
		Sala sala = salas[salaAtual];
		Conexao conexao = sala.getConexao(direcao);
		if (conexao == null)
			throw new Exception("Direcao Invalida");

		return conexao;
	}

	
	public static int converteComando(String com) throws Exception 
	{
		com = com.toLowerCase();
		if (com.equals("mover"))
			return 1;
		if (com.equals("olhar"))
			return 2;
		if (com.equals("atacar"))
			return 3;
		if (com.equals("largar"))
			return 4;
		if (com.equals("pegar"))
			return 5;
		throw new Exception("Comando " + com + " nao e valido");
	}

	
	public void exibeStatus()
	{
		out.println(salas[salaAtual]);
	}

	
	public void inicializaLabirinto() 
	{
		salas = new Sala[50];
		salas[0] = new Sala();
		countSalas = 0;
		jogador = new Jogador();

		try {
			leLabirinto(new Scanner(new FileInputStream("labirinto.txt")));
		} catch (Exception e) {
			err.println(e.getMessage());
			exit(1);
		}

		salaAtual = getRandomRoom();
	}

	
	public void imprimeLabirinto()
	{
	   for (Sala s: salas) {
	       if (s == null) break;
	            System.out.println(s);
	       }
	}
	
	
	public void leLabirinto(Scanner arquivo) throws Exception 
	{
		String cmd = arquivo.next().toLowerCase();
		while (cmd.equals("room")) {
			int salaId = arquivo.nextInt();
			salas[salaId] = new Sala();
			Sala sala = salas[salaId];
			countSalas++;

			String direcao = arquivo.next();

			do {
				if (arquivo.hasNextInt()) {
					salaId = arquivo.nextInt();
				} else if (arquivo.next().equalsIgnoreCase("EXIT")) {
					salaId = 0;
				} else
					break;

				sala.addConexao(direcao, salaId);

				if (!arquivo.hasNext())
					return;
				cmd = arquivo.next().toLowerCase();
				if (cmd.equals("trap")) {
					sala.setArmadilha(direcao);
					if (!arquivo.hasNext())
						return;
					cmd = arquivo.next();
				}
				direcao = cmd;
			} while (!cmd.equals("room"));
		}
		throw new Exception("Arquivo de descricao do labirinto invalido.");
	}

	
	public Conexao getRndConexaoSemInimigos() 
	{
		do {
			Sala sala = salas[getRandomRoom()];
			for (Conexao c : sala.getConexoes()) {
				if (c == null)
					continue;

				if (c.getInimigo() == null) {
					return c;
				}
			}

		} while (true);
	}

	
	public int getRandomRoom() 
	{
		return 1 + (int) (Math.random() * countSalas);
	}	
}