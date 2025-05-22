package sistema;

import java.util.Scanner;
import processos.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 100;
        Processo[] fila = new Processo[MAX];
        int[] tamanho = {0}; // Usado como referência para leitura

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                --- MENU ---
                1. Criar processo
                2. Executar próximo
                3. Executar por PID
                4. Salvar fila
                5. Carregar fila
                0. Sair
            """);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Tipo (1=Calculo, 2=Gravação, 3=Leitura, 4=Impressão):");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    if (tamanho[0] >= MAX) {
                        System.out.println("Fila cheia!");
                        break;
                    }
                    switch (tipo) {
                        case 1 -> {
                            System.out.print("Digite a expressão (ex: 5 + 3): ");
                            String[] tokens = sc.nextLine().split(" ");
                            fila[tamanho[0]++] = new ProcessoCalculo(new Expressao(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]), tokens[1].charAt(0)));
                        }
                        case 2 -> {
                            System.out.print("Digite a expressão para gravar: ");
                            String[] tokens = sc.nextLine().split(" ");
                            fila[tamanho[0]++] = new ProcessoGravacao(new Expressao(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]), tokens[1].charAt(0)));
                        }
                        case 3 -> fila[tamanho[0]++] = new ProcessoLeitura(fila, tamanho);
                        case 4 -> fila[tamanho[0]++] = new ProcessoImpressao(fila, tamanho[0]);
                        default -> System.out.println("Tipo inválido!");
                    }
                }
                case 2 -> {
                    if (tamanho[0] == 0) {
                        System.out.println("Fila vazia!");
                    } else {
                        fila[0].executar();
                        for (int i = 1; i < tamanho[0]; i++) fila[i - 1] = fila[i];
                        tamanho[0]--;
                    }
                }
                case 3 -> {
                    System.out.print("Digite o PID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < tamanho[0]; i++) {
                        if (fila[i].getPid() == pid) {
                            fila[i].executar();
                            for (int j = i + 1; j < tamanho[0]; j++) fila[j - 1] = fila[j];
                            tamanho[0]--;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("PID não encontrado.");
                }
                case 4 -> Utils.salvar(fila, tamanho[0]);
                case 5 -> tamanho[0] = Utils.carregar(fila);
            }

        } while (opcao != 0);

        sc.close();
    }
}


