package Dijkstra.src.catolica.joaoschmitt.dijkstra;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DijkstraScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ListaPrioritaria lista; //Lista de Prioridades
    static Scanner entrada = new Scanner(System.in);
    static int marcado[]; //Vetor para marcar visitação dos vértices
    static int pai[]; //Antecessor dos vértices no caminho minimo
    static int dist[]; //distancia minima em relação a origem
    static listaadj Adj[]; //Lista de adjacencias do vertice
    static JPanel commands = new JPanel();
    static JButton calcular = new JButton("Calcular");
    static JButton caminhoMinimo = new JButton("Caminho Minimo");
    static JButton mostarCaminho = new JButton("Mostrar Caminhos");
    static JTextField numVertices = new JTextField(25);
    static JTextArea menoresCaminhoTextArea = new JTextArea(30, 20);
    static DijkstraPanel telaGrafo = new DijkstraPanel();
    static int tam, org, dest, op, num = 0, flag = 0, peso = 0;

    public DijkstraScreen() {
        super("Algoritmo Dijkstra");
        this.setLayout(new BorderLayout());

        commands.add(calcular);
        commands.add(new JLabel("Numero de vértices"));
        commands.add(numVertices);
        commands.add(caminhoMinimo);
        commands.add(mostarCaminho);
        this.add(commands, BorderLayout.NORTH);
        this.add(telaGrafo, BorderLayout.CENTER);
        //this.add(menoresCaminhoTextArea, BorderLayout.EAST);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularGrafo();
                telaGrafo.repaint();
            }
        });
        caminhoMinimo.setEnabled(false);
        caminhoMinimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caminhoMinimo();
            }
        });
        mostarCaminho.setEnabled(false);
        mostarCaminho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCaminhos();
            }
        });

        this.setSize(1100, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void calcularGrafo() {
        tam = Integer.parseInt(numVertices.getText());
        vertice novo;
        vertice novo2;
        Adj = new listaadj[tam + 1];
        listaadj listaParaImpressao[] = new listaadj[tam + 1];
        marcado = new int[tam + 1];
        pai = new int[tam + 1];
        dist = new int[tam + 1];
        for (int i = 1;
                i <= tam;
                i++) {
            Adj[i] = new listaadj();
            listaParaImpressao[i] = new listaadj();
            marcado[i] = 0;
        }
        org = Integer.parseInt(JOptionPane.showInputDialog("Aresta do grafo: VerticeOrigem(-1 para parar)"));
        dest = Integer.parseInt(JOptionPane.showInputDialog("Aresta do grafo: VerticeDestino(-1 para parar)"));
        while (org != -1 && dest
                != -1) {
            peso = Integer.parseInt(JOptionPane.showInputDialog("Peso entre vertice " + org + " e " + dest));
            novo = new vertice();
            novo2 = new vertice();
            novo.num = dest;
            novo2.num = dest;
            novo.peso = peso;
            novo2.peso = peso;
            novo.prox = Adj[org].listav;
            novo2.prox = listaParaImpressao[org].listav;
            Adj[org].listav = novo;
            listaParaImpressao[org].listav = novo2;
            org = Integer.parseInt(JOptionPane.showInputDialog("Aresta do grafo: VerticeOrigem(-1 para parar)"));
            dest = Integer.parseInt(JOptionPane.showInputDialog("Aresta do grafo: VerticeDestino(-1 para parar)"));
        }

        telaGrafo.setAdjacencia(listaParaImpressao);
        caminhoMinimo.setEnabled(true);
    }

    public static void caminhoMinimo() {
        num = Integer.parseInt(JOptionPane.showInputDialog("Vertice de origem"));
        for (int i = 1; i <= tam; i++) {
            marcado[i] = 0;
            dist[i] = 0;
        }
        dijkstra(Adj, tam, num);
        mostarCaminho.setEnabled(true);
    }

    public void mostrarCaminhos() {
        mostrar_dist(tam, num);
    }

    public static class vertice {

        int num;
        int peso;
        vertice prox;
    }

    public class listaadj {

        public vertice listav;
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

    void mostrar_dist(int tam, int or) {

        String texto = "Distância de origem " + or + " para os demais vértices\n";
        for (int i = 1; i <= tam; i++) {
            texto += "" + i + "-" + dist[i] + "\n\n";
        }
        JOptionPane.showMessageDialog(null, texto);
        //menoresCaminhoTextArea.setText(texto);
    }
}
