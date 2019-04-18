package cidade;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Cidade {
    public Seção[][] secoes;
    public ArrayList<Seção> listaLinearDeSecoes;
    public ArrayList<Carro> carros;
    public ArrayList<Seção> noCrossing;
    private int loop = 0, cols = 0;

    public Cidade(int[] semaforo) {
        // region cidade.Cidade
        this.secoes = new Seção[19][19];
        this.secoes[0][0] = Seção.instancia(Direção.baixo(), 0, 0);
        this.secoes[1][0] = Seção.instancia(Direção.baixo(), 1, 0);
        this.secoes[2][0] = Seção.instancia(Direção.baixo(), 2, 0);
        this.secoes[3][0] = Seção.instancia(Direção.baixo(), 3, 0);
        this.secoes[4][0] = Seção.instancia(Direção.baixo(), 4, 0);
        this.secoes[5][0] = Seção.instancia(Direção.baixo(), 5, 0);
        this.secoes[6][0] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.baixo(), Direção.direita()), 6, 0, semaforo[0]);
        this.secoes[7][0] = Seção.instancia(Direção.baixo(), 7, 0);
        this.secoes[8][0] = Seção.instancia(Direção.baixo(), 8, 0);
        this.secoes[9][0] = Seção.instancia(Direção.baixo(), 9, 0);
        this.secoes[10][0] = Seção.instancia(Direção.baixo(), 10, 0);
        this.secoes[11][0] = Seção.instancia(Direção.baixo(), 11, 0);
        this.secoes[12][0] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.baixo()), 12, 0, semaforo[1]);
        this.secoes[13][0] = Seção.instancia(Direção.baixo(), 13, 0);
        this.secoes[14][0] = Seção.instancia(Direção.baixo(), 14, 0);
        this.secoes[15][0] = Seção.instancia(Direção.baixo(), 15, 0);
        this.secoes[16][0] = Seção.instancia(Direção.baixo(), 16, 0);
        this.secoes[17][0] = Seção.instancia(Direção.baixo(), 17, 0);
        this.secoes[18][0] = Seção.instancia(Direção.direita(), 18, 0);
        this.secoes[18][1] = Seção.instancia(Direção.direita(), 18, 1);
        this.secoes[18][2] = Seção.instancia(Direção.direita(), 18, 2);
        this.secoes[18][3] = Seção.instancia(Direção.direita(), 18, 3);
        this.secoes[18][4] = Seção.instancia(Direção.direita(), 18, 4);
        this.secoes[18][5] = Seção.instancia(Direção.direita(), 18, 5);
        this.secoes[18][6] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.direita()), 18, 6, semaforo[2]);
        this.secoes[18][7] = Seção.instancia(Direção.direita(), 18, 7);
        this.secoes[18][8] = Seção.instancia(Direção.direita(), 18, 8);
        this.secoes[18][9] = Seção.instancia(Direção.direita(), 18, 9);
        this.secoes[18][10] = Seção.instancia(Direção.direita(), 18, 10);
        this.secoes[18][11] = Seção.instancia(Direção.direita(), 18, 11);
        this.secoes[18][12] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.direita(), Direção.cima()), 18, 12, semaforo[3]);
        this.secoes[18][13] = Seção.instancia(Direção.direita(), 18, 13);
        this.secoes[18][14] = Seção.instancia(Direção.direita(), 18, 14);
        this.secoes[18][15] = Seção.instancia(Direção.direita(), 18, 15);
        this.secoes[18][16] = Seção.instancia(Direção.direita(), 18, 16);
        this.secoes[18][17] = Seção.instancia(Direção.direita(), 18, 17);
        this.secoes[18][18] = Seção.instancia(Direção.cima(), 18, 18);
        this.secoes[17][18] = Seção.instancia(Direção.cima(), 17, 18);
        this.secoes[16][18] = Seção.instancia(Direção.cima(), 16, 18);
        this.secoes[15][18] = Seção.instancia(Direção.cima(), 15, 18);
        this.secoes[14][18] = Seção.instancia(Direção.cima(), 14, 18);
        this.secoes[13][18] = Seção.instancia(Direção.cima(), 13, 18);
        this.secoes[12][18] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.cima(), Direção.esquerda()), 12, 18, semaforo[4]);
        this.secoes[11][18] = Seção.instancia(Direção.cima(), 11, 18);
        this.secoes[10][18] = Seção.instancia(Direção.cima(), 10, 18);
        this.secoes[9][18] = Seção.instancia(Direção.cima(), 9, 18);
        this.secoes[8][18] = Seção.instancia(Direção.cima(), 8, 18);
        this.secoes[7][18] = Seção.instancia(Direção.cima(), 7, 18);
        this.secoes[6][18] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.cima()), 6, 18, semaforo[5]);
        this.secoes[5][18] = Seção.instancia(Direção.cima(), 5, 18);
        this.secoes[4][18] = Seção.instancia(Direção.cima(), 4, 18);
        this.secoes[3][18] = Seção.instancia(Direção.cima(), 3, 18);
        this.secoes[2][18] = Seção.instancia(Direção.cima(), 2, 18);
        this.secoes[1][18] = Seção.instancia(Direção.cima(), 1, 18);
        this.secoes[0][18] = Seção.instancia(Direção.esquerda(), 0, 18);
        this.secoes[0][17] = Seção.instancia(Direção.esquerda(), 0, 17);
        this.secoes[0][16] = Seção.instancia(Direção.esquerda(), 0, 16);
        this.secoes[0][15] = Seção.instancia(Direção.esquerda(), 0, 15);
        this.secoes[0][14] = Seção.instancia(Direção.esquerda(), 0, 14);
        this.secoes[0][13] = Seção.instancia(Direção.esquerda(), 0, 13);
        this.secoes[0][12] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.esquerda()), 0, 12, semaforo[6]);
        this.secoes[0][11] = Seção.instancia(Direção.esquerda(), 0, 11);
        this.secoes[0][10] = Seção.instancia(Direção.esquerda(), 0, 10);
        this.secoes[0][9] = Seção.instancia(Direção.esquerda(), 0, 9);
        this.secoes[0][8] = Seção.instancia(Direção.esquerda(), 0, 8);
        this.secoes[0][7] = Seção.instancia(Direção.esquerda(), 0, 7);
        this.secoes[0][6] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.esquerda(), Direção.baixo()), 0, 6, semaforo[7]);
        this.secoes[0][5] = Seção.instancia(Direção.esquerda(), 0, 5);
        this.secoes[0][4] = Seção.instancia(Direção.esquerda(), 0, 4);
        this.secoes[0][3] = Seção.instancia(Direção.esquerda(), 0, 3);
        this.secoes[0][2] = Seção.instancia(Direção.esquerda(), 0, 2);
        this.secoes[0][1] = Seção.instancia(Direção.esquerda(), 0, 1);
        this.secoes[1][6] = Seção.instancia(Direção.baixo(), 1, 6);
        this.secoes[2][6] = Seção.instancia(Direção.baixo(), 2, 6);
        this.secoes[3][6] = Seção.instancia(Direção.baixo(), 3, 6);
        this.secoes[4][6] = Seção.instancia(Direção.baixo(), 4, 6);
        this.secoes[5][6] = Seção.instancia(Direção.baixo(), 5, 6);
        this.secoes[6][6] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.baixo(), Direção.direita()), 6, 6, semaforo[8]);
        this.secoes[7][6] = Seção.instancia(Direção.baixo(), 7, 6);
        this.secoes[8][6] = Seção.instancia(Direção.baixo(), 8, 6);
        this.secoes[9][6] = Seção.instancia(Direção.baixo(), 9, 6);
        this.secoes[10][6] = Seção.instancia(Direção.baixo(), 10, 6);
        this.secoes[11][6] = Seção.instancia(Direção.baixo(), 11, 6);
        this.secoes[12][6] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.baixo(), Direção.esquerda()), 12, 6, semaforo[9]);
        this.secoes[13][6] = Seção.instancia(Direção.baixo(), 13, 6);
        this.secoes[14][6] = Seção.instancia(Direção.baixo(), 14, 6);
        this.secoes[15][6] = Seção.instancia(Direção.baixo(), 15, 6);
        this.secoes[16][6] = Seção.instancia(Direção.baixo(), 16, 6);
        this.secoes[17][6] = Seção.instancia(Direção.baixo(), 17, 6);
        this.secoes[1][12] = Seção.instancia(Direção.cima(), 1, 12);
        this.secoes[2][12] = Seção.instancia(Direção.cima(), 2, 12);
        this.secoes[3][12] = Seção.instancia(Direção.cima(), 3, 12);
        this.secoes[4][12] = Seção.instancia(Direção.cima(), 4, 12);
        this.secoes[5][12] = Seção.instancia(Direção.cima(), 5, 12);
        this.secoes[6][12] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.cima(), Direção.direita()), 6, 12, semaforo[10]);
        this.secoes[7][12] = Seção.instancia(Direção.cima(), 7, 12);
        this.secoes[8][12] = Seção.instancia(Direção.cima(), 8, 12);
        this.secoes[9][12] = Seção.instancia(Direção.cima(), 9, 12);
        this.secoes[10][12] = Seção.instancia(Direção.cima(), 10, 12);
        this.secoes[11][12] = Seção.instancia(Direção.cima(), 11, 12);
        this.secoes[12][12] = Seção.instanciaCruzamento(vetorDeDirecoes(Direção.cima(), Direção.esquerda()), 12, 12, semaforo[11]);
        this.secoes[13][12] = Seção.instancia(Direção.cima(), 13, 12);
        this.secoes[14][12] = Seção.instancia(Direção.cima(), 14, 12);
        this.secoes[15][12] = Seção.instancia(Direção.cima(), 15, 12);
        this.secoes[16][12] = Seção.instancia(Direção.cima(), 16, 12);
        this.secoes[17][12] = Seção.instancia(Direção.cima(), 17, 12);
        this.secoes[6][1] = Seção.instancia(Direção.direita(), 6, 1);
        this.secoes[6][2] = Seção.instancia(Direção.direita(), 6, 2);
        this.secoes[6][3] = Seção.instancia(Direção.direita(), 6, 3);
        this.secoes[6][4] = Seção.instancia(Direção.direita(), 6, 4);
        this.secoes[6][5] = Seção.instancia(Direção.direita(), 6, 5);
        this.secoes[6][7] = Seção.instancia(Direção.direita(), 6, 7);
        this.secoes[6][8] = Seção.instancia(Direção.direita(), 6, 8);
        this.secoes[6][9] = Seção.instancia(Direção.direita(), 6, 9);
        this.secoes[6][10] = Seção.instancia(Direção.direita(), 6, 10);
        this.secoes[6][11] = Seção.instancia(Direção.direita(), 6, 11);
        this.secoes[6][13] = Seção.instancia(Direção.direita(), 6, 13);
        this.secoes[6][14] = Seção.instancia(Direção.direita(), 6, 14);
        this.secoes[6][15] = Seção.instancia(Direção.direita(), 6, 15);
        this.secoes[6][16] = Seção.instancia(Direção.direita(), 6, 16);
        this.secoes[6][17] = Seção.instancia(Direção.direita(), 6, 17);
        this.secoes[12][1] = Seção.instancia(Direção.esquerda(), 12, 1);
        this.secoes[12][2] = Seção.instancia(Direção.esquerda(), 12, 2);
        this.secoes[12][3] = Seção.instancia(Direção.esquerda(), 12, 3);
        this.secoes[12][4] = Seção.instancia(Direção.esquerda(), 12, 4);
        this.secoes[12][5] = Seção.instancia(Direção.esquerda(), 12, 5);
        this.secoes[12][7] = Seção.instancia(Direção.esquerda(), 12, 7);
        this.secoes[12][8] = Seção.instancia(Direção.esquerda(), 12, 8);
        this.secoes[12][9] = Seção.instancia(Direção.esquerda(), 12, 9);
        this.secoes[12][10] = Seção.instancia(Direção.esquerda(), 12, 10);
        this.secoes[12][11] = Seção.instancia(Direção.esquerda(), 12, 11);
        this.secoes[12][13] = Seção.instancia(Direção.esquerda(), 12, 13);
        this.secoes[12][14] = Seção.instancia(Direção.esquerda(), 12, 14);
        this.secoes[12][15] = Seção.instancia(Direção.esquerda(), 12, 15);
        this.secoes[12][16] = Seção.instancia(Direção.esquerda(), 12, 16);
        this.secoes[12][17] = Seção.instancia(Direção.esquerda(), 12, 17);
        //endregion
        listaLinearDeSecoes = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (this.secoes[i][j] != null)
                    listaLinearDeSecoes.add(this.secoes[i][j]);
            }
        }
        carros = new ArrayList<>();
        noCrossing = new ArrayList<>();
        listaLinearDeSecoes.forEach(s -> {
            if (!s.isCruzamento)
                noCrossing.add(s);
        });
    }

     private void atualizar() {
         for (Seção s: listaLinearDeSecoes)
             s.update();
        for (Carro c: carros) {
            cols += c.update(this.secoes, loop);
        }
        loop++;
     }

     public int simular(int loops, boolean save) {
        if (save) {
            try {
                System.setOut(new PrintStream("out.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
         for (int i = 0; i < loops; i++) {
            atualizar();
            if (save) {
             for (int k = 0; k < 19; k++) {
                 for (int j = 0; j < 19; j++) {
                     if (secoes[k][j] == null) {
                         System.out.print("   ");
                     } else {
                         if (secoes[k][j].carro == null)
                             System.out.print(" - ");
                         else
                             System.out.print(" C ");
                     }
                 }
                 System.out.println();
             }
            }
         }
        return cols;
     }



    private static Direção[] vetorDeDirecoes(Direção... direcoes) {
        return direcoes;
    }

}
