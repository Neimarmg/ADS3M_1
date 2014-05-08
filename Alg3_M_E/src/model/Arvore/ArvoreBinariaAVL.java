package model.Arvore;

public class ArvoreBinariaAVL {
	 
    public static class arvore {
 
        public int num, altd, alte;
        public arvore dir, esq;
    }
 
    public static arvore inserir(arvore aux, int num) {
        // o objeto novo é um objeto auxiliar
        arvore novo;
        if (aux == null) {
            novo = new arvore();
            novo.num = num;
            novo.altd = 0;
            novo.alte = 0;
            novo.esq = null;
            novo.dir = null;
            aux = novo;
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
            if (aux.esq.altd > aux.esq.alte) {
                aux.alte = aux.esq.altd + 1;
            } else {
                aux.alte = aux.esq.alte + 1;
            }
            aux = balanceamento(aux);
        } else {
            aux.dir = inserir(aux.dir, num);
            if (aux.dir.altd > aux.dir.alte) {
                aux.altd = aux.dir.altd + 1;
            } else {
                aux.altd = aux.dir.alte + 1;
            }
            aux = balanceamento(aux);
        }
        return aux;
    }
 
    public static arvore balanceamento(arvore aux) {
        int d, df;
        d = aux.altd - aux.alte;
        if (d == 2) {
            df = aux.dir.altd - aux.dir.alte;
            if (df >= 0) {
                aux = rotacao_esquerda(aux);
            } else {
                aux.dir = rotacao_direita(aux.dir);
                aux = rotacao_esquerda(aux);
            }
        } else if (d == -2) {
            df = aux.esq.altd - aux.esq.alte;
            if (df <= 0) {
                aux = rotacao_direita(aux);
            } else {
                aux.esq = rotacao_esquerda(aux.esq);
                aux = rotacao_direita(aux);
            }
        }
        return aux;
    }
 
    public static arvore rotacao_esquerda(arvore aux) {
        arvore aux1, aux2;
        aux1 = aux.dir;
        aux2 = aux1.esq;
        aux.dir = aux2;
        aux1.esq = aux;
        if (aux.dir == null) {
            aux.altd = 0;
        } else if (aux.dir.alte > aux.dir.altd) {
            aux.altd = aux.dir.alte + 1;
        } else {
            aux.altd = aux.dir.altd + 1;
        }
 
        if (aux1.esq.alte > aux1.esq.altd) {
            aux1.alte = aux1.esq.alte + 1;
        } else {
            aux1.alte = aux1.esq.altd + 1;
        }
        return aux1;
    }
 
    public static arvore rotacao_direita(arvore aux) {
        arvore aux1, aux2;
        aux1 = aux.esq;
        aux2 = aux1.dir;
        aux.esq = aux2;
        aux1.dir = aux;
        if (aux.esq == null) {
            aux.alte = 0;
        } else if (aux.esq.alte > aux.esq.altd) {
            aux.alte = aux.esq.alte + 1;
        } else {
            aux.alte = aux.esq.altd + 1;
        }
 
        if (aux1.dir.alte > aux1.dir.altd) {
            aux1.altd = aux1.dir.alte + 1;
        } else {
            aux1.altd = aux1.dir.altd + 1;
        }
        return aux1;
    }
 
    public static void exibiremordem(arvore aux) {
        if (aux != null) {
            System.out.print(aux.num + "  ");
            exibiremordem(aux.esq);
            exibiremordem(aux.dir);
        }
    }
 
    public static void exibirpreordem(arvore aux) {
        if (aux != null) {
            System.out.print(aux.num + ", ");
            exibirpreordem(aux.esq);
            exibirpreordem(aux.dir);
        }
    }
 
    public static void exibirposordem(arvore aux) {
        if (aux != null) {
            exibirposordem(aux.esq);
            exibirposordem(aux.dir);
            System.out.print(aux.num + ", ");
        }
    }
 
    public static void executa() {
 
       
    }
} 