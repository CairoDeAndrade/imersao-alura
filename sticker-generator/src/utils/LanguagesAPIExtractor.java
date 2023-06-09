package utils;

import entities.Content;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LanguagesAPIExtractor implements APIExtractor{
    @Override
    public List<Content> extractData(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> jsonList = parser.parse(json);

        return jsonList.stream().map(content -> new Content(content.get("image"), content.get("name"))).collect(Collectors.toList());
    }
}
