import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<Passagem> passageirosAviao = new LinkedList<Passagem>();
        Queue<Passagem> filaAviao = new LinkedList<Passagem>();
        Passagem passagem = new Passagem();
        int posicao = 1, limiteAviao = 0, resposta = 0;

        menu(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);

        // limiteAviao = inserirPassagemAviao(limiteAviao, resposta, passagem,
        // passageirosAviao);
        // inserirFilaDeEspera(limiteAviao, resposta, passagem, filaAviao);
        // mostrarPassagemAviao(passageirosAviao);
        // mostrarFilaDeEspera(filaAviao);
        // limiteAviao = removerPassagemAviao(limiteAviao, resposta, passagem,
        // passageirosAviao, filaAviao);
        // mostrarPassagemAviao(passageirosAviao);
        // mostrarFilaDeEspera(filaAviao);
    }

    public static void menu(int limiteAviao, int resposta, Passagem passagem, Queue<Passagem> passageirosAviao,
            Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n______Painel Passagens Áreas LTDA_____");
            System.out.println("|                                    |");
            System.out.println("|    1 - Inserir Passagem            |");
            System.out.println("|    2 - Remover Passagem            |");
            System.out.println("|    3 - Inserir Fila de Espera      |");
            System.out.println("|    4 - Mostrar Passageiros         |");
            System.out.println("|    5 - Mostrar Fila de Espera      |");
            System.out.println("|    6 - Sair                        |");
            System.out.println("|____________________________________|");
            System.out.print("Digite um número: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:
                    limiteAviao = inserirPassagemAviao(limiteAviao, resposta, passagem, passageirosAviao);
                    break;

                case 2:
                    limiteAviao = removerPassagemAviao(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
                    break;

                case 3:
                    inserirFilaDeEspera(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
                    break;

                case 4:
                    mostrarPassagemAviao(passageirosAviao);
                    break;

                case 5:
                    mostrarFilaDeEspera(filaAviao);
                    break;
            }
        } while (resposta != 6);
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

    public static int removerPassagemAviao(int limiteAviao, int resposta, Passagem passagem,
            Queue<Passagem> passageirosAviao, Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);
        Passagem aux = new Passagem();

        do {
            System.out.printf("\nOlá, quer cancelar a sua passagem?");
            System.out.printf("\nEscreva o código da passagem para remoção: ");
            String codigoPassagem = scanner.nextLine();

            for (Passagem passagem2 : passageirosAviao) {
                if (passagem2.codigoPassagem.equals(codigoPassagem)) {
                    passageirosAviao.remove(passagem2);
                    limiteAviao--;
                }
            }

            for (Passagem passagem3 : filaAviao) {
                aux = passagem3;
                filaAviao.remove();
                passageirosAviao.add(aux);
            }

            System.out.printf("Existe mais cancelamentos de passagens? (1 - Sim, 2 - Não): ");
            resposta = scanner.nextInt();

        } while (resposta == 1);

        return limiteAviao;
    }

    public static void inserirFilaDeEspera(int limiteAviao, int resposta, Passagem passagem, Queue<Passagem> passageirosAviao,
            Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);

        if (limiteAviao < 3) {
            System.out.printf("\nAinda tem vaga para o avião! Voltar e registrar normalmente.\n");
            scanner.nextLine();
            menu(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
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
    }

    public static void mostrarPassagemAviao(Queue<Passagem> passagens) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n---- Passagens do Avião ----\n");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.toString());
        }
        System.out.println("");
        scanner.nextLine();
    }

    public static void mostrarFilaDeEspera(Queue<Passagem> passagens) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n---- Fila de Espera ----\n");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.toString());
        }
        System.out.println("");
        scanner.nextLine();
    }
}
