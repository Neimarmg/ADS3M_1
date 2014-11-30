package com.senac.estruturas;


import com.senac.planilha.Planilha;

public class ListaDE {
	private int tamanho; 
    private Nodes inicio, fim, aux;  

    public ListaDE() {
        tamanho = 0;
        inicio = new Nodes(null, null, null); 
        fim = new Nodes(null, inicio, null); 
        inicio.setProximo(fim);
        aux = fim;
    }

    public int getTamanho()
    { 
        return tamanho;
    }

    public boolean EstaVazia()
    {
        return (tamanho == 0); 
    }

    public Nodes getPrimeiro() throws IllegalStateException 
    {
        if(EstaVazia()){
            throw new IllegalStateException(
            	"A lista esta vazia, não é posivel retornar o primeiro nodo!");
        }
        return inicio.getProximo();
    }
    
    public Nodes getUltimo() throws IllegalStateException 
    {
        if (EstaVazia()){
            throw new IllegalStateException(
            	"A lista esta vazia, não é posivel retornar o ultimo nodo!");
        }
        return fim.getAnterior();
    }

    public Nodes getAnterior(Nodes v) throws IllegalArgumentException 
    {
        if (v == inicio){
            throw new IllegalArgumentException(
            	"Não é possivel mover para traz do inicio da lista!");
        }
        return v.getAnterior();
    }
    
    public Nodes getProximo(Nodes v) throws IllegalArgumentException 
    {
        if (v == fim){
            throw new IllegalArgumentException(
            	"Não é possivel mover para além do fim da lista!");
        }
        return v.getProximo();
    }
    
    private void addInicio(Nodes ant, Nodes prox) throws IllegalArgumentException 
    { 
    	Nodes nodo = getAnterior(ant); 
        prox.setAnterior(nodo);
        prox.setProximo(ant);
        ant.setAnterior(prox);
        nodo.setProximo(prox);
        tamanho++;
    }
   
    private void addFim(Nodes ant, Nodes prox) throws IllegalArgumentException
    { 
        Nodes nodo = getProximo(ant);
        prox.setAnterior(ant);
        prox.setProximo(nodo);
        nodo.setAnterior(prox);
        ant.setProximo(prox);
        tamanho++;
    }
    
    public void addInicio(Nodes v)
    {
        addFim(inicio, v);
    }
    
    public void addFim(Nodes v)
    {
        addInicio(fim, v);
    }
   
    public void Remover(Nodes v)throws Exception 
    { 
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

    public String toString()
    { 
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
    
    public String bucaInfo()
    {
    	Planilha p = new Planilha();    	
    	String res = " ";
    	try {    		 
			aux = getPrimeiro();    		
			if(aux != null){				
				while(aux != null ){
					if (aux.getInfo().equals(p.getValCelula())){
						res = res +aux.getInfo() +" ";					
						aux = aux.getProximo();	
					}else{
						System.err.println("\nNão foram encontrados valores na lista!\n");
					}						
				}					
    		}	
		} catch (Exception e) {
			System.out.println("\nA lista esta vazia!\n");				
		}
    	return res;  
	}    
}

