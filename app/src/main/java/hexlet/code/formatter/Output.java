package hexlet.code.formatter;

import hexlet.code.Item;

import java.util.Map;

public class Output {

    // choosing right output depending on preferred data format output
    public static String getOutput(Map<String, Item> differ,
                                   String format) throws Exception {

        return switch (format) {
            case "stylish" -> Stylish.makeStylish(differ);
            case "plain" -> Plain.makePlain(differ);
            case "json" -> Json.makeJson(differ);
            default -> throw new Exception("Formatting error" + format);
        };
    }
}
