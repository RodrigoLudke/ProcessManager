package sistema;

import processos.Processo;
import java.util.ArrayList;

public class GerenciadorProcessos {
    private ArrayList<Processo> fila = new ArrayList<>();
    int proximoPid = 1;

    public void adicionarProcesso(Processo processo) {
        fila.add(processo);
        System.out.println("Processo adicionado com PID: " + processo.getPid());
    }

    public void executarProximo() {
        if (!fila.isEmpty()) {
            Processo p = fila.remove(0);
            p.executar();
        } else {
            System.out.println("Fila vazia.");
        }
    }

    public void executarPorPid(int pid) {
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getPid() == pid) {
                Processo p = fila.remove(i);
                p.executar();
                return;
            }
        }
        System.out.println("Processo não encontrado.");
    }

}
