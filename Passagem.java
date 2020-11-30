// Integrantes do grupo "Passagens Aéreas e Fila de Espera"
// Andre Barbosa Coura Valverde 
// Gustavo Guilherme Soares Garcia Moreira 
// Matheus Braga Zanon Vitoriano 

import java.util.Random;
import java.util.Scanner;

public class Passagem {

    public String codigoPassagem;
    public int classeVoo;
    public String horaVoo;
    public String dataVoo;
    public String partidaVoo;
    public String chegadaVoo;
    public String nomePassageiroVoo;

    // Construtor Padrão
    Passagem() {
        codigoPassagem = "00000000";
        classeVoo = 0;
        horaVoo = "00" + ":" + "00";
        dataVoo = "00" + "/" + "00" + "/" + "0000";
        partidaVoo = "None";
        chegadaVoo = "None";
        nomePassageiroVoo = "None";
    }

    // Cadastra uma nova passagem, coletando dados de um novo passageiro
    public Passagem emitirPassagem() {
        Scanner scanner = new Scanner(System.in);
        Passagem passagem = new Passagem();
        Random random = new Random();

        System.out.printf("\nNome completo: ");
        passagem.nomePassageiroVoo = scanner.nextLine();

        System.out.printf("\nLocal de saída: ");
        passagem.partidaVoo = scanner.nextLine();

        System.out.printf("\nLocal de chegada: ");
        passagem.chegadaVoo = scanner.nextLine();

        System.out.printf("\nQual a classe? Digite 1 para 1° Classe, 2 para Executiva ou 3 para Econômica): ");
        passagem.classeVoo = scanner.nextInt();

        passagem.codigoPassagem = random.nextInt(2000000) + "0";
        passagem.horaVoo = random.nextInt(13) + ":" + random.nextInt(60);
        passagem.dataVoo = random.nextInt(32) + "/" + random.nextInt(13) + "/" + "2020";

        return passagem;
    }

    // Cadastra uma nova passagem, coletando dados de um novo passageiro da fila de espera
    public Passagem emitirPassagemFilaEspera() {
        Scanner scanner = new Scanner(System.in);
        Passagem passagem = new Passagem();
        Random random = new Random();

        System.out.printf("\nNome completo: ");
        passagem.nomePassageiroVoo = scanner.nextLine();

        System.out.printf("\nLocal de saída: ");
        passagem.partidaVoo = scanner.nextLine();

        System.out.printf("\nLocal de chegada: ");
        passagem.chegadaVoo = scanner.nextLine();

        passagem.codigoPassagem = random.nextInt(2000000) + "0";
        passagem.horaVoo = random.nextInt(13) + ":" + random.nextInt(60);
        passagem.dataVoo = random.nextInt(32) + "/" + random.nextInt(13) + "/" + "2020";

        return passagem;
    }

    // Função para mostrar todas as informações de uma passagem de avião
    @Override
    public String toString() {
        String nomeClasse = "";

        switch (classeVoo) {
            case 1:
                nomeClasse = "1° Classe";
                break;

            case 2:
                nomeClasse = "Executiva";
                break;

            case 3:
                nomeClasse = "Econômica";
                break;
        }

        return  "\nCódigo da Passagem: " + codigoPassagem + 
                "\nNome do Passageiro: " + nomePassageiroVoo +
                "\nClasse Escolhida: " + nomeClasse + 
                "\nHorário do Voo: " + horaVoo + 
                "\nData do Voo: " + dataVoo + 
                "\nLocal Partida Voo: " + partidaVoo + 
                "\nLocal Chega Voo: " + chegadaVoo;
    }
}