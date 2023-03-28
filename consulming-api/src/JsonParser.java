import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {

        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Item(s) not found.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> data = new ArrayList<>();

        for (String item : items) {

            Map<String, String> itemAttributes = new HashMap<>();


            Matcher jsonMatcherAttributes = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (jsonMatcherAttributes.find()) {
                String attribute = jsonMatcherAttributes.group(1);
                String value = jsonMatcherAttributes.group(2);
                itemAttributes.put(attribute, value);
            }

            data.add(itemAttributes);
        }

        return data;

    }
}