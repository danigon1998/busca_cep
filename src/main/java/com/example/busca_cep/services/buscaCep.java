package com.example.busca_cep.services;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpResponse;

public class buscaCep {
    private final String URL = "https://viacep.com.br/ws/";
    private final String formato = "/json/";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String buscaEndereco(String cep) {
        try {
            String url = URL + cep + formato;
            System.out.println(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            validarResposta(response.body());
            return response.body();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private void validarResposta(String resposta) {
        JsonObject json = gson.fromJson(resposta, JsonObject.class);

        if(json.has("erro") && json.get("erro").getAsBoolean()) {
            throw new IllegalArgumentException("CEP não encontrado");
        }
    }
}
