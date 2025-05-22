package processos;

import java.io.*;

public class ProcessoLeitura extends Processo {
    private Processo[] fila;
    private int[] tamanho;

    public ProcessoLeitura(Processo[] fila, int[] tamanho) {
        this.fila = fila;
        this.tamanho = tamanho;
    }

    @Override
    public void executar() {
        try (BufferedReader reader = new BufferedReader(new FileReader("computation.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                double op1 = Double.parseDouble(partes[0]);
                char operador = partes[1].charAt(0);
                double op2 = Double.parseDouble(partes[2]);
                Expressao exp = new Expressao(op1, op2, operador);
                if (tamanho[0] < fila.length) {
                    fila[tamanho[0]++] = new ProcessoCalculo(exp);
                }
            }
            new PrintWriter("computation.txt").close(); // Limpa o arquivo
            System.out.println("Leitura e carregamento concluídos.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
        }
    }

    @Override
    public String toString() {
        return "PID: " + pid + " - Leitura";
    }
}

