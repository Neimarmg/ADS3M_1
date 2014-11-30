package com.senac.jogos.labirinto;

import java.util.ArrayList;
import java.util.List;

public class Sala {

	Conexao[] conexoes = new Conexao[6];
	private List<Item> itens = new ArrayList<Item>();

	private static int getDirecaoIndex(String direcao) throws Exception {
		Direcao dir = Direcao.converte(direcao);
		return dir.getIndex();
	}
	public void setArmadilha(String direcao) throws Exception {
		conexoes[getDirecaoIndex(direcao)].setArmadilha();
	}

	public void addConexao(String direcao, int sala) throws Exception {
		int ndx = getDirecaoIndex(direcao);
		if (conexoes[ndx] != null)
			throw new Exception(" Sala sem conexao!");

		conexoes[ndx] = new Conexao(sala);
	}

	public Conexao getConexao(Direcao direcao) {
		return conexoes[direcao.getIndex()];
	}

	public void addItem(Item item) {
		itens.add(item);
	}
	public List<Item> getItens() {
		return itens;
	}

	public Conexao[] getConexoes() {
		return conexoes;
	}

	public String toString() {
		try {
			String st = "====================================\nA SALA TEM AS SEGUINTES DIRE��OES: \n";
			for (int i = 0; i < 6; i++)
				if (conexoes[i] != null)
					st += " => "+ Direcao.converte(i) + " " + conexoes[i]
							+"\n";
			if(itens.size() > 0){
				st += "-------------------------------------\n" 
						+"ITENS CONTIDOS NA SALA:"
						+"\n-------------------------------------\n";
				for(Item i : itens)
					st += ">>" + i + "\n";
			}
			return st ;
		} catch (Exception e) {
			return "Sala em situa��o invalida";
		}

	}

}
