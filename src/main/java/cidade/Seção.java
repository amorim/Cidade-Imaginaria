package cidade;

import java.util.ArrayList;
import java.util.Arrays;

public class Seção {
    public boolean isCruzamento = false;
    public ArrayList<Direção> direcoesPossiveis;
    public int x, y;
    public Carro carro;
    public int semaforoTimer, inc = 1;
    public int contador = 0;
    public boolean[] isSemaforoAberto;

    public static Seção instancia(Direção direcao, int x, int y) {
        Seção secao = new Seção();
        secao.direcoesPossiveis = new ArrayList<>();
        secao.direcoesPossiveis.add(direcao);
        secao.x = x;
        secao.y = y;
        return secao;
    }

    public static Seção instanciaCruzamento(Direção[] direcoes, int x, int y, int semaforo) {
        Seção secao = new Seção();
        secao.direcoesPossiveis = new ArrayList<>();
        secao.direcoesPossiveis.addAll(Arrays.asList(direcoes));
        secao.isCruzamento = true;
        secao.x = x;
        secao.y = y;
        secao.semaforoTimer = semaforo;
        secao.isSemaforoAberto = new boolean[2];
        secao.isSemaforoAberto[0] = true;
        return secao;
    }

    public void update() {
        if (!isCruzamento)
            return;
        contador += inc;
        if (contador == semaforoTimer) {
            isSemaforoAberto[1] = true;
            isSemaforoAberto[0] = false;
            inc = -1;
        }
        if (contador == 0) {
            isSemaforoAberto[1] = false;
            isSemaforoAberto[0] = true;
            inc = 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Seção) {
            Seção s = (Seção)o;
            return s.x == this.x && s.y == this.y;
        }
        return false;
    }

}
