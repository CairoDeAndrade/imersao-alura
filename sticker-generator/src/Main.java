import entities.ClientHttp;
import entities.Content;
import enums.API;
import utils.APIExtractor;
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
        API api = API.NASA;
        String url = api.getUrl();
        
        APIExtractor apiExtractor = api.getExtractor();

        var clientHttp = new ClientHttp();
        String json = clientHttp.getAllContent(url);
        List<Content> contentList = apiExtractor.extractData(json);

        // Display and manipulate the data
        var folderPath = new File("assets/img/");
        folderPath.mkdir();

        var stickerFactory = new StickerFactory();
        for (Content content : contentList) {
            System.out.println(content.title());

            String imageUrl = content.url();
            String fileName = folderPath + content.title() + ".png";
            InputStream inputStream = new URL(imageUrl).openStream();

            stickerFactory.createSticker(inputStream, fileName);
        }
        }
    }
