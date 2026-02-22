package lad.com.alura.conversormoneda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioTasaCambio {
    public static double obtenerTasa(String origen, String destino) {
        String url = "https://v6.exchangerate-api.com/v6/c162a869563e51222a3fa051/latest/" + origen;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return conversionRates.get(destino).getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}