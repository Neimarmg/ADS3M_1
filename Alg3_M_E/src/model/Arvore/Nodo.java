package model.Arvore;

import Aplicacao.Prints;
import Controller.Registrador;
	
/**
 * Classo de gravacao do nodo
 * @author Neimar, Aurelio *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>>{
	protected Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;
	int contador = 0; 
	
	/**
	 * Contrutor da classe nodo
	 * @param valor
	 */
	public Nodo(T valor){
		pai = null;
		esq = null;
		dir = null;
		this.valor = valor;
	}
	
	
	private void setPai(Nodo<T> nodo) {
		this.pai = nodo;	
	}
	
	
	public T getValor(){
		return this.valor;
	}
	
	
	public void setValor(T valor){
		this.valor = valor;
	}

	/**
	 * Metodo responsavel pela insecao dos objetos na arvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(novo.getValor().compareTo(valor) < 0 ){
			if(esq ==null){
				esq = novo;
				novo.setPai(this);
			}else{
				esq.insere(novo);
			}
		}
		
		if(novo.getValor().compareTo(valor) > 0){
			if(dir ==null){
				dir = novo;
				novo.setPai(novo);
			}else {
				dir.insere(novo);
			}
		}
		return;
	}
	
	
	
	public void remove(){	
		
	}
	
	
	public void imprime(){
		Prints.msg("\n" + valor);
		if(esq != null){			
			esq.imprime();	
		}
		
		if(dir != null){
			dir.imprime();				
		}		
	}
		
	
	/**
	 * Metodo responsável por armazenar em terporariamente as alteração dos dados do arquivo
	 */
	public void guardaEdicao(){
		Registrador.setAcum(Registrador.getAcum() +"\n" +valor);
		if(esq != null){			
			esq.guardaEdicao();	
		}
		
		if(dir != null){
			dir.guardaEdicao();				
		}		
	}
		
	
	public void travessiaPosFixa(Nodo<T> no){
		if( no == null )  
			return;
		
			travessiaPosFixa(no.dir);
			travessiaPosFixa(no.esq);
			Prints.msg("\nTravessia pós-fixa :" +no.valor);
	}
		
	
	public void travessiaPreFixa(Nodo<T> no){
		if( no == null )  
			return;  
			
			Prints.msg("\nTravessia pré-fixa :" +no.valor);	
			travessiaPreFixa(no.dir);
			travessiaPreFixa(no.esq);		 
	}
	
	
	public void travessiaInfixa(Nodo<T> no){
		if( no == null )  
			return;
		
		 	travessiaInfixa(no.dir);
			Prints.msg("\nTravessia infixa :" +no.valor);	
			 travessiaInfixa(no.esq);		 
	}
	
	
	public int contaNodos(Nodo<T> no){
	     if(no == null)
	         return 0;
	     else 
	         return 1+contaNodos(no.esq)+contaNodos(no.dir);
	}
	
	
	public void buscaEmLargura(Nodo<T> no , String nome) {
		if ( no == null ) {  
			Prints.msg( " Nivel -1 " );  
	    
		}else if ( no.valor.compareTo(no.valor) == nome.compareTo(nome)){  
	    	Prints.msg(" Nivel " + contador );
	    
	    }else if ( no.valor.compareTo(no.valor) > nome.compareTo(nome)){  
	    	if ( no != null ) {  
	    		contador ++;  
	            buscaEmLargura(no.dir , nome );  
	        }  
	    
	    }else if ( no.valor.compareTo(no.valor) < nome.compareTo(nome)){  
	    	if( no != null){  
	    		contador ++;  
	            buscaEmLargura(no.dir , nome );  
	        }           
	    }  
	}
	
	
	
	public void buscEmAltura(){
	
	}
	
}
