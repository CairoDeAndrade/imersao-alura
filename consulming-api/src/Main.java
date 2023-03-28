import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import static java.lang.Double.valueOf;
import static java.lang.Math.round;


public class Main {
    public static void main(String[] args) {

        // Make an HTTP connection consuming the API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String body = response.body();

        // We will get only the useful data (Title, Poster and Rating)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);

        // Display and manipulate the data
        for(Map<String, String> movie: moviesList){
            System.out.println("\u001b[1mTitle: " + movie.get("title") + "\u001b[m");
            System.out.println("Image url:" + movie.get("image"));
            System.out.println("Rating: \u001b[3m" + movie.get("imDbRating") + "\u001b[m");

            int maxRate = 10;
            int imDbRating = (int) round(valueOf(movie.get("imDbRating")));
            for (int i = 0; i < maxRate; i++){
                if (imDbRating == i) {
                    String star = "⭐";
                    System.out.println(star.repeat(i));
                }
            }
            System.out.println();
        }
    }
}