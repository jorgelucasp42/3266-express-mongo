import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class ConversorMoedas {

    private static final String CHAVE_API = "b86236aee1a93e371769aa06"; // Chave API
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/latest/BRL";
    private static final Gson gson = new Gson();
    private static final HttpClient cliente = HttpClient.newHttpClient();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();

            if (escolha == 7) {
                System.out.println("Saindo...");
                break;
            }

            String moedaDestino = obterMoedaDestino(escolha);
            if (moedaDestino != null) {
                realizarConversao(moedaDestino);
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("1. BRL (Real) para USD (Dólar Americano)");
        System.out.println("2. BRL (Real) para EUR (Euro)");
        System.out.println("3. BRL (Real) para GBP (Libra Esterlina)");
        System.out.println("4. BRL (Real) para JPY (Iene Japonês)");
        System.out.println("5. BRL (Real) para AUD (Dólar Australiano)");
        System.out.println("6. BRL (Real) para CAD (Dólar Canadense)");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static String obterMoedaDestino(int escolha) {
        return switch (escolha) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "JPY";
            case 5 -> "AUD";
            case 6 -> "CAD";
            default -> null;
        };
    }

    private static void realizarConversao(String moedaDestino) {
        try {
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .build();

            CompletableFuture<HttpResponse<String>> respostaFutura = cliente.sendAsync(requisicao, HttpResponse.BodyHandlers.ofString());

            respostaFutura.thenApply(HttpResponse::body)
                    .thenAccept(respostaJson -> {
                        double taxaDeCambio = parseTaxaDeCambio(respostaJson, moedaDestino);
                        System.out.print("Insira o valor em BRL: ");
                        double valor = scanner.nextDouble();
                        double valorConvertido = valor * taxaDeCambio;
                        System.out.println("Valor convertido: " + valorConvertido + " " + moedaDestino);
                    }).join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double parseTaxaDeCambio(String respostaJson, String moedaDestino) {
        JsonObject objetoJson = gson.fromJson(respostaJson, JsonObject.class);
        JsonObject taxasDeCambio = objetoJson.getAsJsonObject("conversion_rates");
        return taxasDeCambio.get(moedaDestino).getAsDouble();
    }
}
