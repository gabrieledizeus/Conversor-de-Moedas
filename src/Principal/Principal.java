package Principal;

import Modelo.Moeda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);


        String buscaMoeda = "https://v6.exchangerate-api.com/v6/9867bb764e32728ec61c4103/latest/BRL";



        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buscaMoeda))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();


        Gson gson = new Gson();
        Moeda moeda = gson.fromJson(json, Moeda.class);



        String opcao = "";

        while (true) {
            System.out.println("Escolha o câmbio de conversão ou digite '7' para sair:");
            System.out.println("1) USD para BRL");
            System.out.println("2) BRL para USD");
            System.out.println("3) EUR para USD");
            System.out.println("4) USD para EUR");
            System.out.println("5) EUR para BRL");
            System.out.println("6) BRL para EUR");
            System.out.println("7) Sair");

            opcao = leitura.nextLine();

            if (opcao.equalsIgnoreCase("7") || opcao.equalsIgnoreCase("sair")) {
                break;  // Encerra o loop imediatamente
            }

            System.out.print("Digite um valor para conversão: ");
            double valorConverte = leitura.nextDouble();
            leitura.nextLine();  // limpa buffer

            double resultado;
            switch (opcao) {
                case "1":
                    resultado = moeda.converterPara("USD", "BRL", valorConverte);
                    System.out.printf("USD → BRL: R$ %.2f%n", resultado);
                    break;
                case "2":
                    resultado = moeda.converterPara("BRL", "USD", valorConverte);
                    System.out.printf("BRL → USD: $ %.2f%n", resultado);
                    break;
                case "3":
                    resultado = moeda.converterPara("EUR", "USD", valorConverte);
                    System.out.printf("EUR → USD: $ %.2f%n", resultado);
                    break;
                case "4":
                    resultado = moeda.converterPara("USD", "EUR", valorConverte);
                    System.out.printf("USD → EUR: € %.2f%n", resultado);
                    break;
                case "5":
                    resultado = moeda.converterPara("EUR", "BRL", valorConverte);
                    System.out.printf("EUR → BRL: R$ %.2f%n", resultado);
                    break;
                case "6":
                    resultado = moeda.converterPara("BRL", "EUR", valorConverte);
                    System.out.printf("BRL → EUR: € %.2f%n", resultado);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        leitura.close();
        System.out.println("Programa Encerrou.");
    }
}