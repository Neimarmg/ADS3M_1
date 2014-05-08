package model.Arvore;

import model.Contatos;

public class No {
    private Contatos nome;

    public No(Contatos aluno) {
        this.nome = aluno;
    }

    public void setNome(Contatos nome) {
		this.nome = nome;
	}
    
    public Contatos getNome() {
		return nome;
	}
}