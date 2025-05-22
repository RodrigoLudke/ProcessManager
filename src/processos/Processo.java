package processos;

// Superclasse abstrata para todos os processos
public abstract class Processo {
    protected int pid;
    private static int proximoPid = 1;

    public Processo() {
        this.pid = proximoPid++;
    }

    public int getPid() {
        return pid;
    }

    public abstract void executar();
}

