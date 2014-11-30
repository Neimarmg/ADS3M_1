package com.senac.estruturas.test;

import javax.jws.Oneway;

public class ListaDuplamenteEncadeada {
	private int tamanho; // quantidade de elementos...
    private Nodes inicio, fim, aux;  // sentinelas

    public ListaDuplamenteEncadeada() {// Construtor que cria uma lista vazia!
        tamanho = 0;
        inicio = new Nodes(null, null, null); // cria inicio
        fim = new Nodes(null, inicio, null); // cria fim que aponta para inicio! entendeu
        inicio.setProximo(fim);
        aux = fim;
    }

    public int getTamanho(){ // Retorna o numero de elementos na lista
        return tamanho;
    }

    public boolean EstaVazia(){
        return (tamanho == 0); 
    }

    public Nodes getPrimeiro() throws IllegalStateException {
        if(EstaVazia()){
            throw new IllegalStateException(
            	"A lista esta vazia, não é posivel retornar o primeiro nodo!");
        }
        return inicio.getProximo();
    }
    
    public Nodes getUltimo() throws IllegalStateException {// Retorna o ultimo nodo da lista!
        if (EstaVazia()){
            throw new IllegalStateException(
            	"A lista esta vazia, não é posivel retornar o ultimo nodo!");
        }
        return fim.getAnterior();
    }

    public Nodes getAnterior(Nodes v) throws IllegalArgumentException {// Se a inicio estiver vazia nado da lista
        if (v == inicio){
            throw new IllegalArgumentException(
            	"Não é possivel mover para traz do inicio da lista!");
        }
        return v.getAnterior();
    }
    
    public Nodes getProximo(Nodes v) throws IllegalArgumentException {
        if (v == fim){
            throw new IllegalArgumentException(
            	"Não é possivel mover para além do fim da lista!");
        }
        return v.getProximo();
    }
    
    public void addInicio(Nodes ant, Nodes prox) throws IllegalArgumentException { // Inserir o nodo z antes do dado 'v' um erro ocorre se 'v' ao o inicio da lista!      
    	Nodes nodo = getAnterior(ant); // Faz a troca dos ponteiros
        prox.setAnterior(nodo);
        prox.setProximo(ant);
        ant.setAnterior(prox);
        nodo.setProximo(prox);
        tamanho++;
    }
   
    public void addFim(Nodes ant, Nodes prox) throws IllegalArgumentException{ // Insere o dado 'z' apos o dado 'v'. Ocorre um erro se 'v' no fim!
        Nodes nodo = getProximo(ant);
        prox.setAnterior(ant);
        prox.setProximo(nodo);
        nodo.setAnterior(prox);
        ant.setProximo(prox);
        tamanho++;
    }
    
    public void addInicio(Nodes v){// Inseri dado 'v' no inicio da lista!
        addFim(inicio, v);
    }
    
    public void addFim(Nodes v){// Inseri dado 'v'no fim da lista!
        addInicio(fim, v);
    }
   
    public void Remover(Nodes v)throws Exception { // Remove dado 'v' da lista. Um erro ocorre se 'v' no iniçio ou no fim!
    	try { // Desliga o nodo da lista!
    		
    		Nodes w = getProximo(v); 		   
    		Nodes u = getAnterior(v);
    		
    		w.setAnterior(u);
		    u.setProximo(w);
		    v.setAnterior(null);
		    v.setProximo(null);
		    tamanho--;
		    
		}catch(NullPointerException e){ 
			System.out.print("Null Error de remoção");
		}
    }
   
    public boolean temAnterior(Nodes v){// Retorna se um determinado nodo tem um nodo anterior
        return (v != inicio);
    }

    public boolean temProximo(Nodes v){
        return (v != fim);
    }

    public String toString(){ // Retorna um representação de string da lista
    	String s = "";
    	try {	    	
	        Nodes v = inicio.getProximo();
	        while(v != fim){
	            s += v.getInfo();
	            v = v.getProximo();
	            if(v != fim) s += " " +"\n";
	            s += "";
	        }	                   
	   	} catch (Exception e) {
	   		System.out.println("\nA lista esta vazia não é possivél imprimir nada!\n");
		}
       return s;
    }
    
    public String bucaInfo(){
    	String res = " ";
    	try {    		 
			aux = getPrimeiro();    		
			if(aux != null){				
				while(aux != null ){					
					if (aux == null) {
						res = res +aux.getInfo() +" ";
					}					
					aux = aux.getProximo();				
				}					
    		}	
		} catch (Exception e) {
			System.out.println("\nA lista esta vazia!\n");				
		}
    	return res;  
    }
}
