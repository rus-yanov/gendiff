package hexlet.code.formatters;

import hexlet.code.Item;

import java.util.List;
import java.util.Map;

import static hexlet.code.Item.ADDED;
import static hexlet.code.Item.CHANGED;
import static hexlet.code.Item.DELETED;
import static hexlet.code.Item.UNCHANGED;

public class Plain {

    // make plain format output
    public static String makePlain(Map<String, Item> differ) throws Exception {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Item> item : differ.entrySet()) {
            String newValue = checkValue(item.getValue().getNewValue());
            String oldValue = checkValue(item.getValue().getOldValue());

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
        return String.valueOf(result).trim();
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
