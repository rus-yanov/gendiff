package hexlet.code;

import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Objects;

import static hexlet.code.Item.ADDED;
import static hexlet.code.Item.DELETED;
import static hexlet.code.Item.UNCHANGED;
import static hexlet.code.Item.CHANGED;

public class Differ {
    // getting altogether all data and generating result
    public static String generate(String filePath1,
                                  String filePath2,
                                  String format)
            throws Exception {

        String content1 = Utils.getContent(filePath1);
        String content2 = Utils.getContent(filePath2);

        String extension1 = Utils.getFileExtension(filePath1);
        String extension2 = Utils.getFileExtension(filePath2);

        Map<String, Object> data1 = Parse.parseContent(content1, extension1);
        Map<String, Object> data2 = Parse.parseContent(content2, extension2);

        Map<String, Item> differ = getDiff(data1, data2);

        return Output.getOutput(differ, format);
    }

    // getting difference between parsed data
    public static Map<String, Item> getDiff(Map<String, Object> parsedData1,
                                            Map<String, Object> parsedData2) {

        // the key of differ contains the key from parsed data (which is also a map)
        // the value contains special class Item, which represents condition of a key
        Map<String, Item> differ = new HashMap<>();

        // creating a set of keys from both parsed files
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(parsedData1.keySet());
        allKeys.addAll(parsedData2.keySet());


        for (String key : allKeys) {
            Object oldValue = parsedData1.get(key);
            Object newValue = parsedData2.get(key);

            if (!parsedData1.containsKey(key)) {
                differ.put(key, new Item(newValue, ADDED));
            } else if (!parsedData2.containsKey(key)) {
                differ.put(key, new Item(oldValue, DELETED));
            } else if (Objects.equals(oldValue, newValue)) {
                differ.put(key, new Item(oldValue, newValue, UNCHANGED));
            } else {
                differ.put(key, new Item(oldValue, newValue, CHANGED));
            }
        }
        return differ;
    }
}
