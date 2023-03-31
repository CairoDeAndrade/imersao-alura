package entities;

public class Content {

    private final String url;
    private final String title;

    public Content(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
