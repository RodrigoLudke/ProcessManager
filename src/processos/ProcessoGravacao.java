package processos;

import java.io.*;

public class ProcessoGravacao extends Processo {
    private Expressao expressao;

    public ProcessoGravacao(Expressao expressao) {
        this.expressao = expressao;
    }

    @Override
    public void executar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("computation.txt", true))) {
            writer.write(expressao.toString());
            writer.newLine();
            System.out.println("Gravou expressão: " + expressao);
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo.");
        }
    }

    @Override
    public String toString() {
        return "PID: " + pid + " - Gravação - " + expressao;
    }
}

