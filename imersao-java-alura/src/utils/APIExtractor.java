package utils;

import entities.Content;

public interface Extractor {

    Content extract(){
        return new Content();
    }
}
