package C.Arvores.Avl;

import App.View;

public class ArvoreAVL extends NodoAVL {
	NodoAVL raiz;
	
	public void inisert(NodoAVL aux, int val){
		raiz.insere(aux, val);
	}

	
	public void imprimeOrdemInfixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESSÃO DE ORDEM INFIXA - ");
		raiz.ordemInfixa(valor);
	}
	
	public void imprimeOrdemPreFixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESSÃO DE ORDEM PRÉ FIXA - ");
		raiz.ordemPosFixa(valor);
	}
	
	public void imprimeOrdemPosFixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESSÃO DE ORDEM PÓS FIXA - ");
		raiz.ordemPosFixa(valor);
	}

	
	public void imprimeAvore(){
		View.imprimeArvores(true,"IMPRESSÃO DA - ");
		raiz.imprimeArvore();
	}
}
