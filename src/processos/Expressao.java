package processos;

public class Expressao {
    private double op1;
    private double op2;
    private char operador;

    public Expressao(double op1, double op2, char operador) {
        this.op1 = op1;
        this.op2 = op2;
        this.operador = operador;
    }

    public double calcular() {
        return switch (operador) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op2 != 0 ? op1 / op2 : Double.NaN;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return op1 + " " + operador + " " + op2;
    }
}
