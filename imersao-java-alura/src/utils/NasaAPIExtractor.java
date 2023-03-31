package utils;

import entities.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NasaAPIExtractor implements APIExtractor{
    @Override
    public List<Content> extractData(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> jsonList = parser.parse(json);

        return jsonList.stream().map(content -> new Content(content.get("url"), content.get("title"))).collect(Collectors.toList());
    }
}
