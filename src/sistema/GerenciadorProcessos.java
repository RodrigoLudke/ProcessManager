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
        System.out.print("Digite a expressão (ex: 5 + 3): ");
        String[] tokens = sc.nextLine().split(" ");
        fila[tamanho[0]++] = new ProcessoCalculo(new Expressao(
                Double.parseDouble(tokens[0]),
                Double.parseDouble(tokens[2]),
                tokens[1].charAt(0)
        ));
    }

    private void criarProcessoGravacao(Scanner sc) {
        System.out.print("Digite a expressão para gravar: ");
        String[] tokens = sc.nextLine().split(" ");
        fila[tamanho[0]++] = new ProcessoGravacao(new Expressao(
                Double.parseDouble(tokens[0]),
                Double.parseDouble(tokens[2]),
                tokens[1].charAt(0)
        ));
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