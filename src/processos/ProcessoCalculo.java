package processos;

public class ProcessoCalculo extends Processo {
    private double op1;
    private String operador;
    private double op2;

    public ProcessoCalculo(int pid, double op1, String operador, double op2) {
        super(pid);
        this.op1 = op1;
        this.operador = operador;
        this.op2 = op2;
    }

    @Override
    public void executar() {
        double resultado = 0;
        switch (operador) {
            case "+" -> resultado = op1 + op2;
            case "-" -> resultado = op1 - op2;
            case "*" -> resultado = op1 * op2;
            case "/" -> resultado = op2 != 0 ? op1 / op2 : Double.NaN;
            default -> System.out.println("Operador inválido.");
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public String toString() {
        return "PID: " + pid + " | Cálculo: " + op1 + " " + operador + " " + op2;
    }
}
