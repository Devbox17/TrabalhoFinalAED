import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Queue<Passagem> passageirosAviao = new LinkedList<Passagem>();
        Queue<Passagem> filaAviao = new LinkedList<Passagem>();
        Passagem passagem = new Passagem();
        int posicao = 1, limiteAviao = 0, resposta = 0;

        
        limiteAviao = inserirPassagemAviao(limiteAviao, resposta, passagem, passageirosAviao);
        inserirFilaDeEspera(limiteAviao, resposta, passagem, filaAviao);
        mostrarPassagemAviao(passageirosAviao);
        mostrarFilaDeEspera(filaAviao);
    }

    public static int inserirPassagemAviao(int limiteAviao, int resposta, Passagem passagem,
            Queue<Passagem> passageirosAviao) {
        Scanner scanner = new Scanner(System.in);

        // O valor 3 foi pré-definido como o valor máximo de passageiros do Avião
        if (limiteAviao == 3) {
            System.out.printf("Não pode inserir mais passageiros, deve ir pra fila de espera!");
        } else {
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
        }
        return limiteAviao;
    }

    public static void inserirFilaDeEspera(int limiteAviao, int resposta, Passagem passagem,
            Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);

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
    }

    public static void mostrarPassagemAviao(Queue<Passagem> passagens) {
        System.out.printf("\n---- Passagens do Avião ----\n");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.toString());
        }
        System.out.println("");
    }

    public static void mostrarFilaDeEspera(Queue<Passagem> passagens) {
        System.out.printf("\n---- Fila de Espera ----\n");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.toString());
        }
        System.out.println("");
    }
}
