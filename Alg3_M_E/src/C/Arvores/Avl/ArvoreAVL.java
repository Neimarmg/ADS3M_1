package C.Arvores.Avl;

import App.View;

public class ArvoreAVL extends NodoAVL {

	public void inisert(NodoAVL aux, int valor) {
		insere(aux, valor);
	}


	public void imprimeOrdemInfixa(NodoAVL valor) {
		View.imprimeArvores(true, "IMPRESS�O DE ORDEM INFIXA - ");
		ordemInfixa(valor);
	}


	public void imprimeOrdemPreFixa(NodoAVL valor){
		View.imprimeArvores(true, "IMPRESS�O DE ORDEM PR�-FIXA - ");
		ordemPosFixa(valor);
	}


	public void imprimeOrdemPosFixa(NodoAVL valor) {
		View.imprimeArvores(true, "IMPRESS�O DE ORDEM P�S-FIXA - ");
		ordemPosFixa(valor);
	}


	public void imprimeAvore() {
		View.imprimeArvores(true, "IMPRESS�O DA - ");
		imprimeArvore();
	}
	
}