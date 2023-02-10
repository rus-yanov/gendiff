package hexlet.code;

import java.util.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        String content1 = getContent(filePath1);
        String content2 = getContent(filePath2);

        String extension1 = getFileExtension(filePath1);
        String extension2 = getFileExtension(filePath2);

        assert extension1 != null;
        assert extension2 != null;
        Map<String, Object> data1 = parseContent(content1, extension1);
        Map<String, Object> data2 = parseContent(content2, extension2);

        Map<String, Item> differ = getDiff(data1, data2);

        return Output.getOutput(differ, format);

    }

    // getting absolute path to file and reading content
    public static String getContent(String pathToFile)
            throws Exception {

        String content;
        Path pathFile;
        File file = new File(pathToFile);
        String absolutePath = file.getAbsolutePath();
        pathFile = Path.of(absolutePath);
        content = Files.readString(pathFile);
        return content;
    }

    // getting file extension
    public static String getFileExtension(String pathToFile) {

        int index = pathToFile.lastIndexOf('.');
        return index > 0 ? pathToFile.substring(index + 1) : null;
    }

    // getting result of parsing
    public static Map<String, Object> parseContent(String content,
                                            String dataFormat)
            throws Exception {

        if (dataFormat.equals("json")) {
            return parseJson(content);
        }
        throw new Exception("Unknown format: '" + dataFormat + "'");
    }

    // parsing json file
    private static Map<String, Object> parseJson(String content)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content,
                        new TypeReference<HashMap<String, Object>>() {});
    }

    // getting difference between parsed data
    public static Map<String, Item> getDiff(Map<String, Object> dataFileOne,
                                            Map<String, Object> dataFileTwo) {

        Map<String, Item> differ = new HashMap<>();
        Set<String> allKey = new HashSet<>();
        allKey.addAll(dataFileOne.keySet());
        allKey.addAll(dataFileTwo.keySet());

        for (String key : allKey) {
            Object oldValue = dataFileOne.get(key);
            Object newValue = dataFileTwo.get(key);

            if (!dataFileOne.containsKey(key)) {
                differ.put(key, new Item(newValue, ADDED));
            } else if (!dataFileTwo.containsKey(key)) {
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
