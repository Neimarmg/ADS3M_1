package C.Arvores.Avl;

import App.View;

public class ArvoreAVL extends NodoAVL {
	NodoAVL raiz;
	
	public void inisert(NodoAVL aux, int val){
		raiz.insere(aux, val);
	}

	
	public void imprimeOrdemInfixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESS�O DE ORDEM INFIXA - ");
		raiz.ordemInfixa(valor);
	}
	
	public void imprimeOrdemPreFixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESS�O DE ORDEM PR� FIXA - ");
		raiz.ordemPosFixa(valor);
	}
	
	public void imprimeOrdemPosFixa(ArvoreAVL valor){
		View.imprimeArvores(true,"IMPRESS�O DE ORDEM P�S FIXA - ");
		raiz.ordemPosFixa(valor);
	}

	
	public void imprimeAvore(){
		View.imprimeArvores(true,"IMPRESS�O DA - ");
		raiz.imprimeArvore();
	}
}
