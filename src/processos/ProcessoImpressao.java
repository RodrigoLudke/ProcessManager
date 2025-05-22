package processos;

public class ProcessoImpressao extends Processo {
    private Processo[] fila;
    private int tamanho;

    public ProcessoImpressao(Processo[] fila, int tamanho) {
        this.fila = fila;
        this.tamanho = tamanho;
    }

    @Override
    public void executar() {
        System.out.println("Fila de processos:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila[i]);
        }
    }

    @Override
    public String toString() {
        return "PID: " + pid + " - Impressão da fila";
    }
}

