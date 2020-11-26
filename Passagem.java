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

    // Construtor Gerado para testes
    // Passagem() {
    // Random random = new Random();
    // NameGenerator nameGenerator = new NameGenerator(10);

    // codigoPassagem = random.nextInt(2000000) + "0";
    // classeVoo = random.nextInt(3);

    // while (classeVoo == 0) {
    // classeVoo = random.nextInt(3);
    // }

    // horaVoo = random.nextInt(13) + ":" + random.nextInt(60);
    // dataVoo = random.nextInt(32) + "/" + random.nextInt(13) + "/" + "2020";
    // partidaVoo = "" + nameGenerator.getName();
    // chegadaVoo = "" + nameGenerator.getName();
    // nomePassageiroVoo = "" + nameGenerator.getName();
    // }

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

        codigoPassagem = random.nextInt(2000000) + "0";
        horaVoo = random.nextInt(13) + ":" + random.nextInt(60);
        dataVoo = random.nextInt(32) + "/" + random.nextInt(13) + "/" + "2020";

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
                "\nClasse Escolhida: " + nomeClasse + 
                "\nHorário do Voo: " + horaVoo + 
                "\nData do Voo: " + dataVoo + 
                "\nLocal Partida Voo: " + partidaVoo + 
                "\nLocal Chega Voo: " + chegadaVoo + 
                "\nNome do Passageiro: " + nomePassageiroVoo;
    }
}