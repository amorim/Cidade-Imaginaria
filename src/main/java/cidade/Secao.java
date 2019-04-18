package cidade;

import java.util.ArrayList;
import java.util.Arrays;

public class Secao {
    public boolean isCruzamento = false;
    public ArrayList<Direcao> direcoesPossiveis;
    public int x, y;
    public Carro carro;
    public int semaforoTimer, inc = 1;
    public int contador = 0;
    public boolean[] isSemaforoAberto;

    public static Secao instancia(Direcao direcao, int x, int y) {
        Secao secao = new Secao();
        secao.direcoesPossiveis = new ArrayList<>();
        secao.direcoesPossiveis.add(direcao);
        secao.x = x;
        secao.y = y;
        return secao;
    }

    public static Secao instanciaCruzamento(Direcao[] direcoes, int x, int y, int semaforo) {
        Secao secao = new Secao();
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
        if (o instanceof Secao) {
            Secao s = (Secao)o;
            return s.x == this.x && s.y == this.y;
        }
        return false;
    }

}
