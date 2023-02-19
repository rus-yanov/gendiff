package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    // choosing right output depending on preferred data format output
    public static String getOutput(Map<String, Item> differ,
                                   String format) throws Exception {

        return switch (format) {
            case "stylish" -> Stylish.makeStylish(differ);
            case "plain" -> Plain.makePlain(differ);
            case "json" -> Json.makeJson(differ);
            default -> throw new Exception("Formatting error: '" + format + "'");
        };
    }
}
