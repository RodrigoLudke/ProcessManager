package processos;

public class ProcessoCalculo extends Processo {
    private Expressao expressao;

    public ProcessoCalculo(Expressao expressao) {
        this.expressao = expressao;
    }

    @Override
    public void executar() {
        System.out.println("Executando processo de cálculo PID " + pid + ": " + expressao + " = " + expressao.calcular());
    }

    @Override
    public String toString() {
        return "PID: " + pid + " - Calculo - " + expressao;
    }
}
