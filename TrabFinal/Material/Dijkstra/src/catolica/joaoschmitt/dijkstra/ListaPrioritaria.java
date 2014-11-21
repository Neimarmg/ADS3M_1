package Dijkstra.src.catolica.joaoschmitt.dijkstra;

import java.util.Scanner;

public class ListaPrioritaria {

    static int vet[];
    static Scanner entrada = new Scanner(System.in);
    private static int tamanho;

    public ListaPrioritaria(int n) {
        vet = new int[n + 1];
        setTamanho(0);
    }

    public void inserir(int num, int dist[]) {
        int ind;
        if (getTamanho() < vet.length - 1) {
            setTamanho(getTamanho() + 1);
            ind=getTamanho();
            while (ind>1 && dist[vet[Pai(ind)]] > dist[num]) {
                vet[ind] = vet[Pai(ind)];
                ind= Pai(ind);
            }
            vet[ind] = num;
        }
    }

    public static int Pai(int x) {
        return x / 2;
    }

    public static void heap_fica(int i, int qtde, int dist[]) {
        
        int f_esq, f_dir, menor, aux;
        menor = i;
        if (2 * i + 1 <= qtde) {
            f_esq = 2 * 1;
            f_dir = 2 * i + 1;
            if (dist[vet[f_esq]] < dist[vet[f_dir]] && dist[vet[f_esq]] < dist[vet[i]]) {
                menor = 2 * i;
            } else if (dist[vet[f_dir]] < dist[vet[f_esq]] && dist[vet[f_dir]] < dist[vet[i]]) {
                menor = 2 * i + 1;
            }

        } else if (2 * i <= qtde) {
            f_esq = 2 * i;
            if (dist[vet[f_esq]] < dist[vet[i]]) {
                menor = 2 * i;
            }
        }
        if (menor != i) {
            aux = vet[i];
            vet[i] = vet[menor];
            vet[menor] = aux;
            heap_fica(menor, qtde, dist);
        }
    }

    public static void constroiheap(int dist[]) {
        for (int i = getTamanho()/2; i>= 1; i--) {
            heap_fica(i, getTamanho(), dist);
        }
    }
    
    public static int remover(int dist[]){
        if(getTamanho()==0) {
            System.out.println("Lista Vazia!");
        }
        else{
            int menor_prior=vet[1];
            vet[1]=vet[getTamanho()];
            setTamanho(getTamanho() - 1);
            heap_fica(1, getTamanho(), dist);
            return menor_prior;
        }
        return 0;
    }
    
    public static void imprimir(){
        for (int i = 1; i <= getTamanho(); i++) {
            System.out.println(" "+vet[i]);
        }
    }

	public static int getTamanho() {
		return tamanho;
	}

	public static void setTamanho(int tamanho) {
		ListaPrioritaria.tamanho = tamanho;
	}
}
