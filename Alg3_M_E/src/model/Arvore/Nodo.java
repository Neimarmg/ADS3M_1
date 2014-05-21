package model.Arvore;

import model.Utilitarios.Auxiliar;
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
	
	
	/**
	 * M�todo de impress�o de toda a �rvore	
	 */
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
	 * Metodo respons�vel por armazenar em terporariamente as altera��o dos dados do arquivo
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
	
	
	/**
	 * Percorre a �rvore p�s ordem
	 * @param no
	 */
	public void travessiaPosFixa(Nodo<T> no){
		if( no == null )  
			return;
		
			travessiaPosFixa(no.dir);
			travessiaPosFixa(no.esq);
			Prints.msg("\nTravessia p�s-fixa :" +no.valor);
	}
	
	
	/**
	 * Percorre a �rvore pr� ordem
	 * @param no
	 */
	public void travessiaPreFixa(Nodo<T> no){
		if( no == null )  
			return;  
			
			Prints.msg("\nTravessia pr�-fixa :" +no.valor);	
			travessiaPreFixa(no.dir);
			travessiaPreFixa(no.esq);		 
	}
	
	
	/**
	 * Percorre a �rvore forma infixa
	 * @param no
	 */
	public void travessiaInfixa(Nodo<T> no){
		if( no == null )  
			return;
		
		 	travessiaInfixa(no.esq);
			Prints.msg("\nTravessia infixa :" +no.valor);	
			travessiaInfixa(no.dir);		 
	}
	
	
	/**
	 * Conta novos existentes na �rvore
	 * @param no
	 * @return
	 */
	public int contaNodos(Nodo<T> no){
	     if(no == null)
	         return 0;
	     else 
	         return 1+contaNodos(no.esq)+contaNodos(no.dir);
	}
	
	
	/**
	 * Percore arvore a contando o niveis de profundidade
	 * @param no
	 * @param nome
	 */
	public void buscEmAltura(Nodo<T> no , String nome) {
		if ( no == null ) {  
			Prints.msg( " Nivel -1 " );  
	    
		}else if ( no.valor.compareTo(no.valor) == nome.compareTo(nome)){  
	    	Prints.msg(" Nivel " +Auxiliar.getContador());
	    
	    }else if ( no.valor.compareTo(no.valor) > nome.compareTo(nome)){  
	    	if ( no != null ) {  
	    		Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
	            buscEmAltura(no.dir , nome );  
	        }
	    
	    }else if ( no.valor.compareTo(no.valor) < nome.compareTo(nome)){  
	    	if( no != null){  
	    		Auxiliar.setContador(Auxiliar.getContador()+1); //Contador    
	            buscEmAltura(no.dir , nome );  
	        } 
	    }
	}
	
	
	/**
	 * Percorre a �rvore em busca do elemento solicitado.
	 * @param no
	 * @param campo
	 * @param comparacoes
	 */
	public void buscaDado(Nodo<T> no, T campo){		
		if (no == null){
			Prints.msg("\nDado n�o encontrado na �rvore!" +
					"\nComparacoes: " +Auxiliar.getContador());			
		}else {		
			
			int comper = campo.compareTo(no.getValor());
			
			if ( comper == 0){
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				Prints.msg(no + "\nComparacoes: " +Auxiliar.getContador());				
			
			}else if (comper < 0){
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				buscaDado(no.esq, campo);
			
			}else {
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				buscaDado(no.dir,campo);
			}
		}	
	}
	
	
	/**
	 * M�todo de remo��o " n�o consegui implementar"
	 * @param no
	 * @param campo
	 */
	public void remove(Nodo<T> no, T campo){
		Prints.objetoNaoImplementado();
	}
}
