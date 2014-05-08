package model.Arvore;

import model.Contatos;

public class No {
    private Contatos aluno;

    public No(Contatos aluno) {
        this.aluno = aluno;
    }

    public Contatos getAluno() {
        return aluno;
    }

    public void setAluno(Contatos aluno) {
        this.aluno = aluno;
    }
}