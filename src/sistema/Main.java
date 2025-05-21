package sistema;

import java.util.Scanner;
import processos.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProcessos gerenciador = new GerenciadorProcessos();

        while (true) {
            System.out.println("""
                1. Criar processo de cálculo
                2. Executar próximo processo
                3. Executar processo por PID
                4. Sair
                Escolha: """);

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.print("Operando 1: ");
                    double op1 = sc.nextDouble();
                    System.out.print("Operador (+, -, *, /): ");
                    String operador = sc.next();
                    System.out.print("Operando 2: ");
                    double op2 = sc.nextDouble();
                    ProcessoCalculo p = new ProcessoCalculo(gerenciador.proximoPid++, op1, operador, op2);
                    gerenciador.adicionarProcesso(p);
                }
                case 2 -> gerenciador.executarProximo();
                case 3 -> {
                    System.out.print("Informe o PID: ");
                    int pid = sc.nextInt();
                    gerenciador.executarPorPid(pid);
                }
                case 4 -> {
                    System.out.println("Encerrando.");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
