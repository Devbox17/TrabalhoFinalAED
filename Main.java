import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Queue<Passagem> queue = new LinkedList<Passagem>();
        Passagem passagem = new Passagem();

        queue.add(passagem);
        passagem = new Passagem();
        queue.add(passagem);
        mostrarFila(queue);

        // System.out.println(passagem.toString());
    }

    public static void mostrarFila(Queue<Passagem> fila) {
        for (Passagem passagem : fila) {
            System.out.println(passagem.toString());
        }
    }
}
