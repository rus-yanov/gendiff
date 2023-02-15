package hexlet.code;

import java.util.Map;
import java.util.List;

import static hexlet.code.Item.ADDED;
import static hexlet.code.Item.CHANGED;
import static hexlet.code.Item.DELETED;
import static hexlet.code.Item.UNCHANGED;

public class Formatter {

    private static String newValue;
    private static String oldValue;

    // choosing right output depending on preferred data format output
    public static String getOutput(Map<String, Item> differ,
                                   String format) throws Exception {

        return switch (format) {
            case "stylish" -> makeStylish(differ);
            case "plain" -> makePlain(differ);
            // case "json"
            default -> throw new Exception("Formatting error");
        };
    }

    // make stylish format output
    public static String makeStylish(Map<String, Item> differ) throws Exception {

        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map.Entry<String, Item> item : differ.entrySet()) {
            result.append("\n").append(" ".repeat(2));
            switch (item.getValue().getStatus()) {
                case ADDED -> result.append("+").append(" ")
                        .append(item.getKey()).append(": ")
                        .append(item.getValue().getOldValue());
                case DELETED -> result.append("-").append(" ")
                        .append(item.getKey()).append(": ")
                        .append(item.getValue().getOldValue());
                case CHANGED -> {
                    result.append("-").append(" ")
                            .append(item.getKey()).append(": ")
                            .append(item.getValue().getOldValue());
                    result.append("\n").append(" ".repeat(2))
                            .append("+").append(" ")
                            .append(item.getKey()).append(": ")
                            .append(item.getValue().getNewValue());
                }
                case UNCHANGED -> result.append(" ".repeat(2))
                        .append(item.getKey()).append(": ")
                        .append(item.getValue().getOldValue());
                default -> throw new Exception("Incorrect status: '" + item.getValue().getStatus() + "'");
            }
        }
        return String.valueOf(result.append("\n}"));
    }

    // make plain format output
    public static String makePlain(Map<String, Item> differ) throws Exception {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Item> item : differ.entrySet()) {
            newValue = checkValue(item.getValue().getNewValue());
            oldValue = checkValue(item.getValue().getOldValue());

            switch (item.getValue().getStatus()) {
                case ADDED -> result.append("Property '").append(item.getKey())
                        .append("' was added with value: ").append(oldValue).append("\n");
                case DELETED -> result.append("Property '").append(item.getKey())
                        .append("' was removed").append("\n");
                case CHANGED -> result.append("Property '").append(item.getKey())
                        .append("' was updated. From ").append(oldValue)
                        .append(" to ").append(newValue).append("\n");
                case UNCHANGED -> { }
                default -> throw new Exception("Incorrect status: '" + item.getValue().getStatus() + "'");
            }
        }
        return result.toString().trim();
    }

    // check if value is complex
    public static String checkValue(Object value) {

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
