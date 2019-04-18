package cidade;

public class Direção {
    public int x, y;

    public Direção() {

    }

    public Direção(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direção cima() {
        Direção direcao = new Direção();
        direcao.x = -1;
        direcao.y = 0;
        return direcao;
    }

    public static Direção baixo() {
        Direção direcao = new Direção();
        direcao.x = 1;
        direcao.y = 0;
        return direcao;
    }

    public static Direção esquerda() {
        Direção direcao = new Direção();
        direcao.x = 0;
        direcao.y = -1;
        return direcao;
    }

    public static Direção direita() {
        Direção direcao = new Direção();
        direcao.x = 0;
        direcao.y = 1;
        return direcao;
    }

    public void aplicar(Direção direção) {
        this.x += direção.x;
        this.y += direção.y;
    }

}
