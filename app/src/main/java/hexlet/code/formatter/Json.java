package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Item;

import java.util.Map;

public class Json {

    // make json format output
    public static String makeJson(Map<String, Item> differ) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(differ);
    }
}
