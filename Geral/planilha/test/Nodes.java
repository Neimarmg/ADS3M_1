package com.senac.estruturas.test;

public class Nodes {
    protected String  info; 
    protected Nodes anterior, proximo;
    

    public Nodes(String e, Nodes ant, Nodes prox) 
    {
        info = e;
        anterior = ant;
        proximo = prox;
    }

    public String getInfo()
    {
        return info;
    }

    public Nodes getAnterior()
    {
        return anterior;
    }

    public Nodes getProximo()
    {
        return proximo;
    }

    public void setInfo(String novo)
    {
        info = novo;
    }

    public void setAnterior(Nodes novoAnterior)
    {
        anterior = novoAnterior;
    }

    public void setProximo(Nodes NovoProximo)
    {
        proximo = NovoProximo;
    }
}