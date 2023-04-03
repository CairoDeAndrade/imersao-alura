package enums;

import utils.APIExtractor;
import utils.ImdbAPIExtractor;
import utils.LanguagesAPIExtractor;
import utils.NasaAPIExtractor;

public enum API {
    IMDB_TOP_MOVIES("https://api.nasa.gov/planetary/apod?api_key=KLIb9CAcq8DKLUAEIXVBNSPXoF58URzDOIwxifFn&start_date=2023-03-28&end_date=2023-03-31", new ImdbAPIExtractor()),
    NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new NasaAPIExtractor()),
    LANGUAGES("https://languages-api.fly.dev/languages", new LanguagesAPIExtractor());

    private final String url;
    private final APIExtractor extractor;
    
    API(String url, APIExtractor extractor){
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return url;
    }

    public APIExtractor getExtractor() {
        return extractor;
    }
}
