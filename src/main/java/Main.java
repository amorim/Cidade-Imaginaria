import ga.Decodificador;
import ga.GA;

import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //System.setOut(new PrintStream(new File("out.txt")));

        Random random = new Random();
        // Deixamos as posições de inicio e destino dos carros fixas durante toda a execução, uma vez que se
        // deixássemos o algoritmo mexer nesses parâmetros, ele acabaria por colocar os pares o mais próximo
        // possível.

        // Sendo assim, os parâmetros que o algoritmo altera são os temporizadores dos semáforos e a hora de saída
        // de cada carro.

        // O array abaixo representa as posições de início e destino para cada carro, as posições de ínicio estão
        // localizadas entre 0 e 19 e as de destino de 20 a 39
        int[] deps = random.ints(40, 0, 124).toArray();

        Decodificador decodificador = new Decodificador(deps);
        GA ga = new GA(32, 1000, 0.2d, 0.1d, 0.7f, decodificador, 3);
        int geracao = 0;
        final int intervalo = 2;
        final int trocaElite = 10;
        int geracaoAtual = 1;
        do {
            ga.evoluir(1);
            if ((++geracao) % intervalo == 0) {
                ga.trocarElite(trocaElite);
            }
            double aptidao = ga.getMelhorAptidao();
            // System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            if (aptidao <= 101.1)
                System.out.println("Geração: " + geracaoAtual + " - Número de vezes que carros esperaram em congestionamento: " + (int)(100.0d / aptidao));
            else {
                System.out.println("Geração: " + geracaoAtual + " - Nenhum carro aguardou, congestionamento zero");
                System.exit(0);
            }
            geracaoAtual++;
        } while (geracao < 1000);
    }
}
