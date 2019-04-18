package cidade;

public class Direcao {
    public int x, y;

    public Direcao() {

    }

    public Direcao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direcao cima() {
        Direcao direcao = new Direcao();
        direcao.x = -1;
        direcao.y = 0;
        return direcao;
    }

    public static Direcao baixo() {
        Direcao direcao = new Direcao();
        direcao.x = 1;
        direcao.y = 0;
        return direcao;
    }

    public static Direcao esquerda() {
        Direcao direcao = new Direcao();
        direcao.x = 0;
        direcao.y = -1;
        return direcao;
    }

    public static Direcao direita() {
        Direcao direcao = new Direcao();
        direcao.x = 0;
        direcao.y = 1;
        return direcao;
    }

    public void aplicar(Direcao direcao) {
        this.x += direcao.x;
        this.y += direcao.y;
    }

}
