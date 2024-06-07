import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.concurrent.CompletableFuture;

public class ApiService {

    private static final String CHAVE_API = "b86236aee1a93e371769aa06"; // Chave API
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/latest/BRL";
    private static final Gson gson = new Gson();
    private static final HttpClient cliente = HttpClient.newHttpClient();

    public static String obterTaxasDeCambio() throws Exception {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_API))
                .build();

        CompletableFuture<HttpResponse<String>> respostaFutura = cliente.sendAsync(requisicao, HttpResponse.BodyHandlers.ofString());
        return respostaFutura.thenApply(HttpResponse::body).join();
    }

    public static double parseTaxaDeCambio(String respostaJson, String moedaDestino) {
        JsonObject objetoJson = gson.fromJson(respostaJson, JsonObject.class);
        JsonObject taxasDeCambio = objetoJson.getAsJsonObject("conversion_rates");
        return taxasDeCambio.get(moedaDestino).getAsDouble();
    }
}
