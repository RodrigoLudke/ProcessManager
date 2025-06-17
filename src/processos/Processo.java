package processos;

import java.io.Serializable;

public abstract class Processo implements Serializable {
    protected int pid;
    private static int proximoPid = 1;

    public Processo() {
        this.pid = proximoPid++;
    }

    public int getPid() {
        return pid;
    }

    public static void setProximoPid(int novoProximoPid) {
        proximoPid = novoProximoPid;
    }

    public abstract void executar();
}