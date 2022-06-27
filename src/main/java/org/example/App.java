package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App  {
    public static void main( String[] args ) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name!");
        String name = scanner.nextLine();

        String jsonInputString = "\"{\"name\":\""+ name +"\",\"salary\":\"123\",\"age\":\"23\"}\"";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://dummy.restapiexample.com/api/v1/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
