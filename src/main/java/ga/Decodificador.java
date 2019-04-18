package ga;

import cidade.Carro;
import cidade.Cidade;

import java.util.ArrayList;


public class Decodificador {

    public static double map(double n, double start1, double stop1, double start2, double stop2) {
        return ((n - start1) / (stop1 - start1)) * (stop2 - start2) + start2;
    }

    int[] saidas;

    public Decodificador(int[] saidas) {
        this.saidas = saidas;
    }

    public double decodificar(ArrayList<Double> cromossomo) {
        int[] semaf = new int[12];
        //int[] saidas = new int[40];
        int[] tempos = new int[20];
        for (int i = 0; i < 12; i++)
            semaf[i] = (int) map(cromossomo.get(i), 0.0d, 1.0d, 0.0d, 101.0d);
//       for (int i = 12; i < 52; i++)
//           saidas[i - 12] = (int) map(cromossomo.get(i), 0, 1, 0, 124);
        for (int i = 12; i < 32; i++)
            tempos[i - 12] = (int) map(cromossomo.get(i), 0.0d, 1.0d, 0.0d, 100.0d);
        Cidade cidade = new Cidade(semaf);
        for (int i = 0; i < 20; i++) {
            cidade.carros.add(new Carro(cidade.noCrossing.get(saidas[i])));
            cidade.carros.get(i).dirigir(cidade.noCrossing.get(saidas[i + 20]), tempos[i]);
        }
        int res = cidade.simular(1000, false);
        if (res == 0) {
//            cidade.Cidade cidade2 = new cidade.Cidade(semaf);
//            for (int i = 0; i < 20; i++) {
//                cidade2.carros.add(new cidade.Carro(cidade2.noCrossing.get(saidas[i])));
//                cidade2.carros.get(i).dirigir(cidade2.noCrossing.get(saidas[i + 20]), tempos[i]);
//            }
//            cidade2.simular(1000, true);
            return 102;
        }
        return 100.0d / res;
    }
}