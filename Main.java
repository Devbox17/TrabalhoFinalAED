import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Passagem> passageirosAviao = new LinkedList<Passagem>();
        Queue<Passagem> filaAviao = new LinkedList<Passagem>();
        Passagem passagem = new Passagem();
        int posicao = 1, limiteAviao = 0, resposta = 0;

        // While que vai inserir novos passageiros até o "limite do avião"
        while (limiteAviao < 3) {
            System.out.printf("\nOlá, quer comprar uma passagem? (1 - Sim, 2 - Não): ");
            resposta = scanner.nextInt();

            if (resposta == 1) {
                passagem = new Passagem();
                passageirosAviao.add(passagem);
                limiteAviao++;
            } else {
                System.out.printf("Okay, tenha um bom dia!\n");
            }
        }

        System.out.printf("\n---- (Avião está Lotado) ----\n");

        if (limiteAviao == 3) {
            System.out.printf("\nBem, o avião está lotado!\nMas você pode ficar em uma fila de espera.");
            System.out.printf("\nVocê quer ficar em uma fila de espera? (1 - Sim, 2 - Não): ");
            resposta = scanner.nextInt();

            if (resposta == 1) {
                System.out.printf("Okay, passe o seus dados, vou registra-lo!\n");
                passagem = new Passagem();
                filaAviao.add(passagem);
            } else {
                System.out.printf("Okay, tenha um bom dia!");
            }
        }

        System.out.printf("\n---- Passagens do Avião ----\n");
        mostrarFila(passageirosAviao);

        System.out.println("");

        System.out.printf("\n---- Fila de Espera ----\n");
        mostrarFila(filaAviao);

        // queue.add(passagem);
        // passagem = new Passagem();
        // queue.add(passagem);
        // mostrarFila(queue);

        // System.out.println(passagem.toString());
    }

    public static void mostrarFila(Queue<Passagem> fila) {
        for (Passagem passagem : fila) {
            System.out.println(passagem.toString());
        }
    }
}
