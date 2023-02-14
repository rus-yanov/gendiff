package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parse {
    // getting result of parsing
    public static Map<String, Object> parseContent(String content,
                                                   String dataFormat)
            throws Exception {

        switch (dataFormat) {
            case "json" -> {
                return parseJson(content);
            }
            case "yml" -> {
                return parseYaml(content);
            }
        }
        throw new Exception("Unknown format: '" + dataFormat + "'");
    }

    // parsing json file
    private static Map<String, Object> parseJson(String content)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content,
                new TypeReference<HashMap<String, Object>>() {
                });
    }

    // parsing yaml file
    private static Map<String, Object> parseYaml(String content)
            throws JsonProcessingException {

        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content,
                new TypeReference<HashMap<String, Object>>() {
                });
    }
}
