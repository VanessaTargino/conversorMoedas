package Principal;

import java.util.Scanner;

import static Conversores.ConversorMoedas.getTaxaConversao;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        var menu = new MenuPrincipal();
        int opcaoDesejada = 0;
        String moedaBase;
        String moedaDestino;
        String boasVindas = ("Bem vindo ao conversor de Moedas! ");
        System.out.println(boasVindas);

        while (opcaoDesejada != 7) {
            System.out.println(menu.getMenu());
            opcaoDesejada = leitor.nextInt();

            switch (opcaoDesejada) {
                case 1:
                    converter("BRL", "USD");
                    break;
                case 2:
                    converter("USD", "BRL");
                    break;
                case 3:
                    converter("BRL", "EUR");
                    break;
                case 4:
                    converter("EUR", "BRL");
                    break;
                case 5:
                    converter("BRL", "GBP");
                    break;
                case 6:
                    converter("GBP", "BRL");
                    break;
                case 7:
                    System.out.println("Saindo do programa... Muito obrigado ppor estar conosco!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }

    private static void converter(String moedaBase, String moedaDestino) throws Exception {
        System.out.print("Digite o valor em " + moedaBase + ": ");
        double valor = new Scanner(System.in).nextDouble();

        double taxaConversao = getTaxaConversao(moedaBase, moedaDestino);
        double valorConvertido = valor * taxaConversao;

        System.out.println(valor + " " + moedaBase + " equivalem a " + valorConvertido + " " + moedaDestino);
    }
}