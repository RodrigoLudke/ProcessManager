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
            System.err.println("Erro ao salvar a fila.");
        }
    }

    public static int carregar(Processo[] fila) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fila.dat"))) {
            int tamanho = ois.readInt();
            for (int i = 0; i < tamanho; i++) {
                fila[i] = (Processo) ois.readObject();
            }
            System.out.println("Fila carregada com sucesso.");
            return tamanho;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a fila.");
            return 0;
        }
    }
}
