package com.dmoram.componentes;

import com.dmoram.modelos.ConversionAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public static ConversionAPI hacerConversion(String monedaOrigen, String monedaDestino, double monto){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/1826aa3615f676f0c293935e/pair/"+monedaOrigen+"/"+monedaDestino+"/"+monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest  request = HttpRequest.newBuilder().uri(url).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e ) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println("Ha ocurrido un problema");
        }
        assert response != null;
        return new Gson().fromJson(response.body(), ConversionAPI.class);
    }
}
