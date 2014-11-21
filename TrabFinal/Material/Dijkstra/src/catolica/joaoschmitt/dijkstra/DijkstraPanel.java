package Dijkstra.src.catolica.joaoschmitt.dijkstra;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DijkstraPanel extends JPanel {

    DijkstraScreen.listaadj[] grafo;

    public void setAdjacencia(DijkstraScreen.listaadj[] lista) {
        grafo = lista;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (grafo != null) {
            int[][][] valores = new int[grafo.length][grafo.length][2];
            double posicao[][] = new double[grafo.length][2];

            for (int i = 0; i < grafo.length; i++) {
                for (int j = 0; j < grafo.length; j++) {
                    valores[i][j][0] = 0;
                }
            }

            for (int i = 1; i < valores.length; i++) {
                while (grafo[i].listav != null) {
                    for (int j = 1; j < valores.length; j++) {
                        if (grafo[i].listav.num == j) {
                            valores[i][j][0] = 1;
                            valores[i][j][1] = grafo[i].listav.peso;
                        }
                    }
                    grafo[i].listav = grafo[i].listav.prox;
                }
            }

            int flag = 0;
            for (int i = 1; i < grafo.length; i++) {
                for (int j = 1; j < grafo.length; j++) {
                    if (valores[i][j][0] == 0) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                }
                if (flag == 1) {
                    valores[i][0][0] = 1;
                }
            }
            double x = 0;
            double y = 0;
            int val = 600;
            for (int i = 1; i < valores.length; i++) {
                x = Math.random() * val;
                y = Math.random() * val;
                posicao[i][0] = x;
                posicao[i][1] = y;
                g.drawOval((int) x - 15, (int) y - 15, 50, 50);
            }

            g.setFont(new Font("Arial", 1, 25));
            for (int i = 1; i < valores.length; i++) {
                for (int j = 1; j < valores[i].length; j++) {
                    if (valores[i][j][0] == 1) {
                        g.drawLine((int) posicao[i][0], (int) posicao[i][1], (int) posicao[j][0], (int) posicao[j][1]);
                        g.drawString(String.valueOf(valores[i][j][1]),
                                (int) ((posicao[i][0] + 10 + posicao[j][0]) / 2),
                                (int) ((posicao[i][1] + 10 + posicao[j][1]) / 2));
                        g.drawString(String.valueOf(i), (int) posicao[i][0] + 10, (int) posicao[i][1] + 10);
                    }
                    if (valores[i][0][0] == 1) {
                        g.drawString(String.valueOf(i), (int) posicao[i][0] + 10, (int) posicao[i][1] + 10);
                    }
                }
            }
        }
    }
}
