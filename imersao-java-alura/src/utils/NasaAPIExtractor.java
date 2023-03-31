package utils;

import entities.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaAPIExtractor implements APIExtractor{
    @Override
    public List<Content> extractData(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> jsonList = parser.parse(json);

        List<Content> contentList = new ArrayList<>();

        for (Map<String, String> content : jsonList) {
            contentList.add(new Content(content.get("url"), content.get("title")));
        }
        return contentList;
    }
}
