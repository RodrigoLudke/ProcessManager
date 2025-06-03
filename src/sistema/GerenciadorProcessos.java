package sistema;

import processos.*;
import java.util.Scanner;

public class GerenciadorProcessos {
    private final int MAX = 100;
    private Processo[] fila;
    private int[] tamanho;

    public GerenciadorProcessos() {
        this.fila = new Processo[MAX];
        this.tamanho = new int[]{0};
    }

    public void criarProcesso(int tipo, Scanner sc) {
        if (tamanho[0] >= MAX) {
            System.out.println("Fila cheia!");
            return;
        }

        switch (tipo) {
            case 1 -> criarProcessoCalculo(sc);
            case 2 -> criarProcessoGravacao(sc);
            case 3 -> criarProcessoLeitura();
            case 4 -> criarProcessoImpressao();
            default -> System.out.println("Tipo inválido!");
        }
    }

    private void criarProcessoCalculo(Scanner sc) {
        while (true) {
            System.out.print("Digite a expressão (ex: 5+3): ");
            String input = sc.nextLine().replaceAll("\\s+", ""); // Remove espaços extras
            String[] tokens = input.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)"); // Divide entre números e operador

            if (tokens.length == 3) {
                fila[tamanho[0]++] = new ProcessoCalculo(new Expressao(
                        Double.parseDouble(tokens[0]),
                        Double.parseDouble(tokens[2]),
                        tokens[1].charAt(0)
                ));
                break; // Sai do loop após entrada válida
            } else {
                System.out.println("Expressão inválida! Use o formato correto. ");
            }
        }
    }

    private void criarProcessoGravacao(Scanner sc) {
        System.out.print("Digite a expressão para gravar: ");
        String[] tokens = sc.nextLine().split(" ");
        ProcessoGravacao processo = new ProcessoGravacao(new Expressao(
                Double.parseDouble(tokens[0]),
                Double.parseDouble(tokens[2]),
                tokens[1].charAt(0)
        ));
        fila[tamanho[0]++] = processo;
        processo.executar(); // Executa o processo imediatamente
    }

    private void criarProcessoLeitura() {
        fila[tamanho[0]++] = new ProcessoLeitura(fila, tamanho);
    }

    private void criarProcessoImpressao() {
        fila[tamanho[0]++] = new ProcessoImpressao(fila, tamanho[0]);
    }

    // Getters necessários
    public Processo[] getFila() {
        return fila;
    }

    public int[] getTamanho() {
        return tamanho;
    }
}