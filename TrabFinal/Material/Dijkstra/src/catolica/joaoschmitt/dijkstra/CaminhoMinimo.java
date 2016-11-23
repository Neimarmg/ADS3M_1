package Dijkstra.src.catolica.joaoschmitt.dijkstra;

import java.util.Scanner;

public class CaminhoMinimo {

    public static class vertice {

        int num;
        int peso;
        vertice prox;
    }

    public static class listaadj {

        public vertice listav;
    }
    
    static ListaPrioritaria lista; //Lista de Prioridades
    static Scanner entrada = new Scanner(System.in);
    static int marcado[]; //Vetor para marcar visitação dos vértices
    static int pai[]; //Antecessor dos vértices no caminho minimo
    static int dist[]; //distancia minima em relação a origem
    static listaadj Adj[]; //Lista de adjacencias do vertice

    public static void main(String... args) {
        vertice novo;

        int tam, //Numero de vértices do grafo
                org, //vertice de origem da aresta
                dest, //vertice de destino da aresta
                op, //opcao do menu
                num = 0, //vertice de origem do caminho minimo
                flag = 0, //variavel para validacao do menu
                peso = 0; //peso da aresta do grafo
        String menu;
        System.out.println("Digite o numero de vertices do grafo orientado:");
        tam = entrada.nextInt();

        Adj = new listaadj[tam + 1];
        marcado = new int[tam + 1];
        pai = new int[tam + 1];
        dist = new int[tam + 1];

        for (int i = 1; i <= tam; i++) {
            Adj[i] = new listaadj();
            marcado[i] = 0;
        }

        System.out.println("\nAresta do grafo: VerticeOrigem( -1 para parar ): ");
        org = entrada.nextInt();
        System.out.println("\nAresta do grafo: VerticeDestino( -1 para parar ): ");
        dest = entrada.nextInt();

        while (org != -1 && dest != -1) {
            System.out.println("\nPeso na areasta");
            peso = entrada.nextInt();
            novo = new vertice();
            novo.num = dest;
            novo.peso = peso;
            novo.prox = Adj[org].listav;
            Adj[org].listav = novo;
            System.out.println("\nAresta do grafo: VerticeOrigem( -1 para parar ): ");
            org = entrada.nextInt();
            System.out.println("\nAresta do grafo: VerticeDestino( -1 para parar ): ");
            dest = entrada.nextInt();
        }
        do {
            menu = "\n1-Caminho Minimo"
                    + "\n2-Mostrar lista de adjacencias"
                    + "\n3-Mostrar distancias"
                    + "\n4-Sair"
                    + "\nDigite sua opcao:";
            System.out.println(menu);
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Digite um vértice de origem:");
                    num = entrada.nextInt();
                    for (int i = 1; i <= tam; i++) {
                        marcado[i] = 0;
                        dist[i] = 0;
                    }
                    dijkstra(Adj, tam, num);
                    flag = 1;
                    break;
                case 2:
                    mostrar_Adj(Adj, tam);
                    break;
                case 3:
                    if (flag == 0) {
                        System.out.println("É necessário realizar a busca primeiro");
                    } else {
                        mostrar_dist(tam, num);
                    }
                    break;
            }
        } while (op != 4);
    }

    static void dijkstra(listaadj Adj[], int tam, int v) {
        int i, w;
        int C[] = new int[tam];
        int tamC = 0;
        lista = new ListaPrioritaria(tam);
        dist[v] = 0;
        lista.inserir(v, dist);
        for (i = 1; i <= tam; i++) {
            if (i != v) {
                dist[i] = Integer.MAX_VALUE;
                pai[i] = 0;
                lista.inserir(i, dist);
            }
        }

        while (lista.getTamanho() != 0) {
            w = lista.remover(dist);
            C[tamC] = w;
            tamC++;

            vertice x = Adj[w].listav;
            while (x != null) {
                relax(w, x.num, x.peso);
                x = x.prox;
            }
            lista.constroiheap(dist);
        }
    }

    static void relax(int u, int v, int peso) {
        if (dist[v] > dist[u] + peso) {
            dist[v] = dist[u] + peso;
            pai[v] = u;
        }
    }

    static void mostrar_Adj(listaadj Adj[], int tam) {
        vertice v;
        for (int i = 1; i <= tam; i++) {
            v = Adj[i].listav;
            System.out.println("Entrada " + i + " ");
            while (v != null) {
                System.out.println("(" + i + "," + v.num + ")" + " ");
                v = v.prox;
            }
        }
    }

    static void mostrar_dist(int tam, int or) {
        System.out.println("Distância de origem " + or + " para os demais vértices\n");
        for (int i = 1; i <= tam; i++) {
            System.out.println("" + i + "-" + dist[i]);
        }
    }
}
