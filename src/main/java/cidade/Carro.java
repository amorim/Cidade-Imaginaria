package cidade;

public class Carro {
    public Secao secaoAtual;
    public boolean isEstacionado;
    public Secao secaoDestino;
    private Integer scheduledDeparture = null;
    private Integer nextTurnChoice = null;

    public Carro(Secao secao) {
        this.secaoAtual = secao;
        isEstacionado = true;
    }

    public void dirigir(Secao destino, int time) {
        scheduledDeparture = time;
        secaoDestino = destino;
    }

    public int update(Secao[][] secoes, int timeNow) {
        if (isEstacionado) {
            if (scheduledDeparture != null && timeNow >= scheduledDeparture) {
                if (secaoAtual.carro != null) {
                    // Existe um carro na secao, impossível sair da garagem
                    // System.out.println("cidade.Carro nao pode sair da garagem enquanto existe outro na posicao");
                    return 0;
                }
                secaoAtual.carro = this;
                isEstacionado = false;
            } else
                return 0;
        }
        Direcao d = secaoAtual.direcoesPossiveis.get(0);
        Direcao datual = new Direcao(secaoAtual.x, secaoAtual.y);
        datual.aplicar(d);
        Secao s = secoes[datual.x][datual.y];
        if (s.isCruzamento && s.direcoesPossiveis.size() > 1) {
            if (nextTurnChoice == null) {
                if (Math.random() < 0.5)
                    nextTurnChoice = 0;
                else
                    nextTurnChoice = 1;
            }
            if (!s.isSemaforoAberto[nextTurnChoice]) {
                // semaforo fechado
                // System.out.println("Semaforo fechado");
                return 0;
            }
        }
        if (secaoAtual.isCruzamento && secaoAtual.direcoesPossiveis.size() > 1) {
            d = secaoAtual.direcoesPossiveis.get(nextTurnChoice);
            datual = new Direcao(secaoAtual.x, secaoAtual.y);
            datual.aplicar(d);
            s = secoes[datual.x][datual.y];
            if (s.carro != null) {
                // carro na próxima secao
                //// System.out.println("cidade.Carro em (" + secaoAtual.x + "," + secaoAtual.y  + ") bloqueado pela carro a frente");
                return 1;
            }
            nextTurnChoice = null;
        }

        if (s.isCruzamento && s.direcoesPossiveis.size() == 1) {
            int index = 0;
            Direcao d1 = new Direcao(secaoAtual.direcoesPossiveis.get(0).x, secaoAtual.direcoesPossiveis.get(0).y);
            Direcao d2 = new Direcao(s.direcoesPossiveis.get(0).x, s.direcoesPossiveis.get(0).y);
            d1.aplicar(d2);

            if (d1.x != 0 && d1.y != 0)
                index = 1;
            if (!s.isSemaforoAberto[index]) {
                // semaforo fechado
                //// System.out.println("Semaforo fechado");
                return 0;
            }
        }

        if (s.carro != null) {
            // carro na próxima secao
            // System.out.println("cidade.Carro em (" + secaoAtual.x + "," + secaoAtual.y  + ") bloqueado pela carro a frente");
            return 1;
        }
        secaoAtual.carro = null;
        secaoAtual = s;
        s.carro = this;
        if (s.equals(secaoDestino)) {
            isEstacionado = true;
            s.carro = null;
            scheduledDeparture = null;
            secaoDestino = null;
        }
        return 0;
    }

}
