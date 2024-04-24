package com.dmoram.componentes;

import com.dmoram.modelos.Conversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public static Conversion hacerConversion(String monedaOrigen, String monedaDestino, double monto){
        URI url = URI.create("https://api.fastforex.io/convert?api_key=fa2bb11ff3-5e488c368f-sc87h3&from="+monedaOrigen+"&to="+monedaDestino+"&amount="+monto);
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
        System.out.println(response.body());
        return new Gson().fromJson(response.body(), Conversion.class);
    }
}
