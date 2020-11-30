// Integrantes do grupo "Passagens Aéreas e Fila de Espera"
// Andre Barbosa Coura Valverde 
// Gustavo Guilherme Soares Garcia Moreira 
// Matheus Braga Zanon Vitoriano 

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
    }

    // Função que retorna um menu 
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
                    limiteAviao = inserirPassagemAviao(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
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
        } while (resposta < 6);
    }

    // Função que inseri uma nova passagem em um Vôo
    public static int inserirPassagemAviao(int limiteAviao, int resposta, Passagem passagem,
        Queue<Passagem> passageirosAviao, Queue<Passagem> filaAviao) {
         Scanner scanner = new Scanner(System.in);

        // O valor 3 foi pré-definido como o valor máximo de passageiros do Avião
        if (limiteAviao == 3) {
            System.out.printf("\nNão pode inserir mais passageiros, deve ir pra fila de espera!\n");
            scanner.nextLine();
            menu(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
        } else {
            // While que vai inserir novos passageiros até o "limite do avião"
            while (limiteAviao < 3) {
                System.out.printf("\nOlá, quer comprar uma passagem? (1 - Sim, 2 - Não): ");
                resposta = scanner.nextInt();

                if (resposta == 1) {
                    passagem = new Passagem();
                    passageirosAviao.add(passagem.emitirPassagem());
                    // passageirosAviao.add(passagem);
                    limiteAviao++;
                } else {
                    System.out.printf("Okay, tenha um bom dia!\n");
                    menu(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
                }
            }
        }
        return limiteAviao;
    }

    // Função que remove uma nova passagem em um Vôo
    public static int removerPassagemAviao(int limiteAviao, int resposta, Passagem passagem,
        Queue<Passagem> passageirosAviao, Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);
        Passagem aux = new Passagem();
        int valorClasseVoo = 0;

        // Do While que vai remover passagens do Vôo
        // e adicionar passagens que estão em fila de espera, a passagens do Vôo
        do {
            System.out.printf("\nOlá, quer cancelar a sua passagem?");
            System.out.printf("\nEscreva o código da passagem para remoção: ");
            String codigoPassagem = scanner.nextLine();

            for (Passagem passagem2 : passageirosAviao) {
                if (passagem2.codigoPassagem.equals(codigoPassagem)) {
                    valorClasseVoo = passagem2.classeVoo;
                    passageirosAviao.remove(passagem2);
                    limiteAviao--;
                }
            }

            for (Passagem passagem3 : filaAviao) {
                aux = passagem3;
                aux.classeVoo = valorClasseVoo;
                filaAviao.remove();
                passageirosAviao.add(aux);
            }

            System.out.printf("Existe mais cancelamentos de passagens? (1 - Sim, 2 - Não): ");
            resposta = scanner.nextInt();

        } while (resposta == 1);

        return limiteAviao;
    }

    // Função que inseri uma nova passagem em uma fila de espera
    public static void inserirFilaDeEspera(int limiteAviao, int resposta, Passagem passagem, Queue<Passagem> passageirosAviao,
        Queue<Passagem> filaAviao) {
        Scanner scanner = new Scanner(System.in);

        // Esse teste verifica se o Vôo está lotado, se não estiver, deve registrar normalmente
        if (limiteAviao < 3) {
            System.out.printf("\nAinda tem vaga para o avião! Voltar e registrar normalmente.\n");
            scanner.nextLine();
            menu(limiteAviao, resposta, passagem, passageirosAviao, filaAviao);
        }

        // Esse teste verifica se o Vôo está lotado e registra na fila de espera
        System.out.printf("\n---- (Avião está Lotado) ----\n");
        if (limiteAviao == 3) {
            System.out.printf("\nBem, o avião está lotado!\nMas você pode ficar em uma fila de espera.");
            System.out.printf("\nVocê quer ficar em uma fila de espera? (1 - Sim, 2 - Não): ");
            resposta = scanner.nextInt();

            if (resposta == 1) {
                System.out.printf("Okay, passe o seus dados, vou registrá-lo!\n");
                passagem = new Passagem();
                filaAviao.add(passagem.emitirPassagemFilaEspera());
            } else {
                System.out.printf("Okay, tenha um bom dia!");
            }
        }
    }

    // Função que mostra passagem de um Vôo
    public static void mostrarPassagemAviao(Queue<Passagem> passagens) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n---- Passagens do Avião ----\n");
        for (Passagem passagem : passagens) {
            System.out.println(passagem.toString());
        }
        System.out.println("");
        scanner.nextLine();
    }

    // Função que mostra passagem da fila de espera
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
