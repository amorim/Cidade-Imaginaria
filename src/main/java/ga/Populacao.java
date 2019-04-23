package ga;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class Populacao {

    ArrayList<Pair<Double, Integer>> aptidao;
    ArrayList<ArrayList<Double>> populacao;

    public double getAptidao(int i) {
        Pair<Double, Integer> item = aptidao.get(i);
        return item.getKey();
    }

    ArrayList<Double> getCromossomo(int i) {
        int chave = aptidao.get(i).getValue();
        return populacao.get(chave);
    }

    public Populacao(int n, int p) {
        populacao = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            ArrayList<Double> cromossomos = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cromossomos.add(0.0);
            }
            populacao.add(cromossomos);
        }
        aptidao = new ArrayList<>();
        for (int j = 0; j < p; j++) {
            Pair pair = new MutablePair(0.0, j);
            aptidao.add(pair);
        }
    }

    public void ordenarPorAptidao() {
        aptidao.sort((x, y) -> {
            double res = y.getKey() - x.getKey();
            int resInt;
            if (res > 0.0) {
                resInt = 1;
            } else if (res == 0.0) {
                resInt = 0;
            } else {
                resInt = -1;
            }
            return resInt;

        });
    }

    public void setAptidao(int i, double f) {
        Pair<Double, Integer> p = new MutablePair<>(f, i);
        aptidao.set(i, p);
    }

    void setAlelo(int j, int k, Double rand) {
        populacao.get(j).set(k, rand);
    }

    ArrayList<Double> getCromossomoI(int i) {
        return populacao.get(i);
    }
}