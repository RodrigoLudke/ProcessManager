package sistema;

import processos.Processo;

import java.io.*;

public class Utils {
    public static void salvar(Processo[] fila, int tamanho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fila.dat"))) {
            oos.writeInt(tamanho);
            for (int i = 0; i < tamanho; i++) {
                oos.writeObject(fila[i]);
            }
            System.out.println("Fila salva com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar a fila.");
        }
    }

    public static int carregar(Processo[] fila) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fila.dat"))) {
            int tamanho = ois.readInt();
            int maiorPid = 0;
            for (int i = 0; i < tamanho; i++) {
                fila[i] = (Processo) ois.readObject();
                if (fila[i].getPid() > maiorPid) {
                    maiorPid = fila[i].getPid();
                }
            }
            // Atualiza o próximo PID na classe Processo
            Processo.setProximoPid(maiorPid + 1);
            System.out.println("Fila carregada com sucesso.");
            return tamanho;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a fila.");
            return 0;
        }
    }
}