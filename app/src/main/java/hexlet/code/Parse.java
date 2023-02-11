package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Parse {
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
                new TypeReference<HashMap<String, Object>>() {
                });
    }

}
