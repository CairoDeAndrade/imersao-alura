package utils;

import entities.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImdbAPIExtractor implements APIExtractor{

    @Override
    public List<Content> extractData(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> jsonList = parser.parse(json);

        List<Content> contentList = new ArrayList<>();

        for (Map<String, String> content : jsonList) {
            contentList.add(new Content(content.get("image"), content.get("title")));
        }
        return contentList;
    }
}
