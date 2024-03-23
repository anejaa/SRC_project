package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String doGetRequest(String uri) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        return res.body();
    }
}