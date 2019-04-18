package ga;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GA {

    private int n, p, pe, pm, K;
    private double rhoe;
    private Decodificador decodificador;
    private ArrayList<Populacao> anterior = new ArrayList<>(), atual = new ArrayList<>();

    public GA(int n, int p, double pe, double pm, double rhoe, Decodificador decodificador, int K) {
        this.n = n;
        this.p = p;
        this.pe = (int) (pe * p);
        this.pm = (int) (pm * p);
        this.rhoe = rhoe;
        this.decodificador = decodificador;
        this.K = K;
        for (int i = 0; i < K; i++) {
            Populacao populacao = new Populacao(n, p);
            atual.add(populacao);
            inicializar(populacao);
            anterior.add(populacao);
        }
    }

    private void inicializar(Populacao populacao) {
        Random rand = new Random((new Date()).getTime());
        for (int j = 0; j < p; j++)
            for (int k = 0; k < n; k++)
                populacao.setAlelo(j, k, rand.nextDouble());
        for (int j = 0; j < p; j++) {
            ArrayList<Double> cromossomo = populacao.getCromossomoI(j);
            double aptidao = decodificador.decodificar(cromossomo);
            populacao.setAptidao(j, aptidao);
        }
        populacao.ordenarPorAptidao();
    }

    public double getMelhorAptidao() {
        double melhor = atual.get(0).getAptidao(0);
        for (int i = 1; i < K; i++)
            if (atual.get(i).getAptidao(0) < melhor)
                melhor = atual.get(i).getAptidao(0);
        return melhor;
    }

    public void evoluir(int geracoes) {
        for (int i = 0; i < geracoes; i++) {
            for (int j = 0; j < K; j++) {
                evolucao(atual.get(j), anterior.get(j));
                Populacao pop = atual.get(j);
                atual.set(j, anterior.get(i));
                anterior.set(j, pop);
            }
        }
    }

    public void trocarElite(int M) {
        for (int i = 0; i < K; i++) {
            int dest = p - 1;
            for (int j = 0; j < K; j++) {
                if (j == i) {
                    continue;
                }
                for (int m = 0; m < M; m++) {
                    ArrayList<Double> melhorJ = atual.get(j).getCromossomo(m);
                    ArrayList<Double> cromDest = atual.get(i).getCromossomo(dest);
                    for (int x = 0; x < melhorJ.size(); x++) {
                        cromDest.set(x, melhorJ.get(x));
                    }
                    atual.get(i).setAptidao(dest, atual.get(j).getAptidao(m));
                    dest--;
                }
            }
        }
        for (int j = 0; j < K; j++) {
            atual.get(j).ordenarPorAptidao();
        }
    }

    private void evolucao(Populacao atual, Populacao proxima) {
        int i = 0;
        int j;
        while (i < pe) {
            for (j = 0; j < n; j++) {
                proxima.setAlelo(i, j, atual.getCromossomo(i).get(j));
            }
            proxima.setAptidao(i, atual.getAptidao(i));
            i++;
        }
        Random rand = new Random((new Date()).getTime());
        while (i < p - pm) {
            int paiElite = rand.nextInt(pe);
            int paiNaoElite = pe + rand.nextInt(p - pe);
            for (j = 0; j < n; j++) {
                int pai = ((rand.nextDouble() < rhoe) ? paiElite : paiNaoElite);
                proxima.setAlelo(i, j, atual.getCromossomo(pai).get(j));
            }
            i++;
        }
        while (i < p) {
            for (j = 0; j < n; j++) {
                proxima.setAlelo(i, j, rand.nextDouble());
            }
            i++;
        }
        for (int x = pe; x < p; x++) {
            proxima.setAptidao(x, decodificador.decodificar(proxima.populacao.get(x)));
        }
        proxima.ordenarPorAptidao();
    }
}