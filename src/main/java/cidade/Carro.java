package cidade;

public class Carro {
    public Seção secaoAtual;
    public boolean isEstacionado;
    public Seção secaoDestino;
    private Integer scheduledDeparture = null;
    private Integer nextTurnChoice = null;

    public Carro(Seção secao) {
        this.secaoAtual = secao;
        isEstacionado = true;
    }

    public void dirigir(Seção destino, int time) {
        scheduledDeparture = time;
        secaoDestino = destino;
    }

    public int update(Seção[][] secoes, int timeNow) {
        if (isEstacionado) {
            if (scheduledDeparture != null && timeNow >= scheduledDeparture) {
                if (secaoAtual.carro != null) {
                    // Existe um carro na seção, impossível sair da garagem
                    // System.out.println("cidade.Carro não pode sair da garagem enquanto existe outro na posição");
                    return 0;
                }
                secaoAtual.carro = this;
                isEstacionado = false;
            } else
                return 0;
        }
        Direção d = secaoAtual.direcoesPossiveis.get(0);
        Direção datual = new Direção(secaoAtual.x, secaoAtual.y);
        datual.aplicar(d);
        Seção s = secoes[datual.x][datual.y];
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
            datual = new Direção(secaoAtual.x, secaoAtual.y);
            datual.aplicar(d);
            s = secoes[datual.x][datual.y];
            if (s.carro != null) {
                // carro na próxima seção
                //// System.out.println("cidade.Carro em (" + secaoAtual.x + "," + secaoAtual.y  + ") bloqueado pela carro a frente");
                return 1;
            }
            nextTurnChoice = null;
        }

        if (s.isCruzamento && s.direcoesPossiveis.size() == 1) {
            int index = 0;
            Direção d1 = new Direção(secaoAtual.direcoesPossiveis.get(0).x, secaoAtual.direcoesPossiveis.get(0).y);
            Direção d2 = new Direção(s.direcoesPossiveis.get(0).x, s.direcoesPossiveis.get(0).y);
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
            // carro na próxima seção
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
