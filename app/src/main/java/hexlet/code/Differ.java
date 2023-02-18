package hexlet.code;

import java.util.Map;

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

        Map<String, Object> data1 = Parser.parseContent(content1, extension1);
        Map<String, Object> data2 = Parser.parseContent(content2, extension2);

        Map<String, Item> differ = Difference.getDiff(data1, data2);

        return Formatter.getOutput(differ, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
