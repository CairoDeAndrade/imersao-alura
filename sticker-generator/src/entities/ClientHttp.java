package entities;

import entities.excepions.ClientHttpException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    private URI uri;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public ClientHttp(){
    }

    public ClientHttp(URI uri, HttpClient client, HttpRequest request, HttpResponse<String> response) {
        this.uri = uri;
        this.client = client;
        this.request = request;
        this.response = response;
    }

    public URI getUri() {
        return uri;
    }

    public HttpClient getClient() {
        return client;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public String getAllContent(String url){
        uri = URI.create(url);
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(uri).GET().build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ClientHttpException("Error in consulting url");
        }

        return response.body();
    }
}
