package utils;

import entities.Content;

import java.util.List;

public interface APIExtractor {

    List<Content> extractData(String json);
}
