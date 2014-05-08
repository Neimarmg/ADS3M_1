package model.Arvore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Contatos;
import model.Lista.ListaOrdenada;
import model.Lista.Nodo;
import Aplicacao.Prints;

public class ArvoreBinaria {
    private No raiz;
    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;
 
    public ArvoreBinaria() { }
 
    public ArvoreBinaria getArvoreDireita() {
        return arvoreDireita;
    }
 
    public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
        this.arvoreDireita = arvoreDireita;
    }
 
    public ArvoreBinaria getArvoreEsquerda() {
        return arvoreEsquerda;
    }
 
    public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
        this.arvoreEsquerda = arvoreEsquerda;
    }
 
    public No getRaiz() {
        return raiz;
    }
 
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
 
    public void insereContato(String nome,String fone) {
        Contatos contato = new Contatos(nome, fone);
        No no = new No(contato);
        inserir(no);
    }
 
    public void inserir(No no) {
        if (this.raiz == null) {
            this.raiz = no;
        } else {
            if (no.getAluno().getMatricula() > this.raiz.getAluno().getMatricula()) {
                if (this.arvoreDireita == null) {
                    this.arvoreDireita = new ArvoreBinaria();
                }
                this.arvoreDireita.inserir(no);
            } else if (no.getAluno().getMatricula() < this.raiz.getAluno().getMatricula()) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new ArvoreBinaria();
                }
                this.arvoreEsquerda.inserir(no);
            }
        }
    }
 
    public void percorrerInOrder() {
        if (this.raiz == null) {
           return;
        }
 
        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerInOrder();
        }
 
        System.out.println("Matrícula: " + this.raiz.getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getAluno().getNome());
        
        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerInOrder();
        }
    }
 
    public void percorrerPreOrder() {
        if (this.raiz == null) {
           return;
        }
 
        System.out.println("Matrícula: " + this.raiz.getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getAluno().getNome());
 
        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerPreOrder();
        }
 
        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerPreOrder();
        }
    }
 
    public void percorrerPostOrder() {
        if (this.raiz == null) {
           return;
        }
 
        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerPostOrder();
        }
 
        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerPostOrder();
        }
 
        System.out.println("Matrícula: " + this.raiz.getAluno().getMatricula());
        System.out.println("Nome: " + this.raiz.getAluno().getNome());
    }
 
    public Contatos busca(int matricula) {
        if (this.raiz == null) {
            return null;
        } else {
            if (matricula == this.raiz.getAluno().getMatricula()) {
                return this.raiz.getAluno();
            } else {
                if (matricula > this.raiz.getAluno().getMatricula()) {
                    if (this.arvoreDireita == null) {
                        return null;
                    }
                    return this.arvoreDireita.busca(matricula);
                } else {
                    if (this.arvoreEsquerda == null) {
                        return null;
                    }
                    return this.arvoreEsquerda.busca(matricula);
                }
            }
        }
    } 
    
    
    /**
	 * Método responsável pela leitura dos dados em arquivo e finalização das alterações
	 * @param nomeArquivo
	 * @throws IOException
	 */
	public void leArquivo(String nomeArquivo) throws IOException {
		ListaOrdenada<String> lista = new ListaOrdenada<String>();		
		
		try{
			FileReader file = new FileReader(nomeArquivo);
			BufferedReader buff = new BufferedReader(file);
			String linha = buff.readLine();
			
			while(linha != null ){
				linha = buff.readLine();
				lista.insert(new Nodo<String>(linha), lista.getHead());
				
			}			
			buff.close();
			
		} catch (NullPointerException e) {
			Prints.msgb("Arquivo embranco.");;
		} catch (FileNotFoundException e1) {
			Prints.msgb("Arquivo inexistente.");
		}
		lista.imprime(false);
		editaArquivo(nomeArquivo);		
	}
}