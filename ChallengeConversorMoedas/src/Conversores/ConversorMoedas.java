package Conversores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoedas {
    private static final String API_KEY = "7b175877d8196731f0944279";
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getTaxaConversao(String moedaBase, String moedaDestino) throws Exception {
        URL url = new URL(BASE_URL + moedaBase);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("apikey", API_KEY);

        if (connection.getResponseCode() != 200) {
            throw new Exception("Erro ao obter taxa de conversão: " + connection.getResponseCode());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String linha;
        StringBuilder resposta = new StringBuilder();
        while ((linha = reader.readLine()) != null) {
            resposta.append(linha);
        }
        reader.close();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(resposta.toString(), JsonObject.class);
        double taxaConversao = jsonObject.getAsJsonObject("rates").get(moedaDestino).getAsDouble(); // Obter a taxa de conversão para a moeda destino

        return taxaConversao; // Retorna a taxa de conversão
    }

    public static void main(String[] args) throws Exception {
        double taxaConversao = getTaxaConversao("BRL", "USD");
        System.out.println("Taxa de conversão BRL para USD: " + taxaConversao);
    }
}