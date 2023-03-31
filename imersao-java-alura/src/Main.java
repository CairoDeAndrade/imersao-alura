import entities.ClientHttp;
import entities.Content;
import utils.APIExtractor;
import utils.ImdbAPIExtractor;
import utils.NasaAPIExtractor;
import utils.StickerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //  Make an HTTP connection consuming the API

        // Nasa API
         String url = "https://api.nasa.gov/planetary/apod?api_key=KLIb9CAcq8DKLUAEIXVBNSPXoF58URzDOIwxifFn&start_date=2023-03-28&end_date=2023-03-31";
         APIExtractor apiExtractor = new NasaAPIExtractor();

        // Imdb API
//        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
//        APIExtractor apiExtractor = new ImdbAPIExtractor();

        var clientHttp = new ClientHttp();
        String json = clientHttp.getAllContent(url);
        List<Content> contentList = apiExtractor.extractData(json);

        // Display and manipulate the data
        var folderPath = new File("assets/img/");
        folderPath.mkdir();

        var stickerFactory = new StickerFactory();
        for (Content content : contentList) {
            System.out.println(content.getTitle());

            String imageUrl = content.getUrl();
            String fileName = folderPath + content.getTitle() + ".png";
            InputStream inputStream = new URL(imageUrl).openStream();

            stickerFactory.createSticker(inputStream, fileName);
        }
        }
    }
