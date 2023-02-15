package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


public class DifferTest {

    private String jsonFilePath1;
    private String jsonFilePath2;
    private String yamlFilePath1;
    private String yamlFilePath2;
    private String resultStylish;
    private String resultPlain;
    private String resultJson;


    public final String getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toFile().getAbsolutePath();
    }

    public final String getContent(String fileName) throws IOException {
        Path filePath = Path.of(getPath(fileName));
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public final void doBeforeEach() throws IOException {
        jsonFilePath1 = getPath("file1.json");
        jsonFilePath2 = getPath("file2.json");
        yamlFilePath1 = getPath("file1.yml");
        yamlFilePath2 = getPath("file2.yml");
        resultStylish = getContent("result_stylish.txt");
        resultPlain = getContent("result_plain.txt");
        resultJson = getContent("result_json.json");
    }

    @Test
    public void generateTest() throws Exception {
        // input format: json
        // output format: stylish
        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "stylish"))
                .isEqualTo(resultStylish);

        // input format: yaml
        // output format: stylish
        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "stylish"))
                .isEqualTo(resultStylish);

        // input format: json
        // output format: plain
        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "plain"))
                .isEqualTo(resultPlain);

        // input format: yaml
        // output format: plain
        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "plain"))
                .isEqualTo(resultPlain);

        // input format: json
        // output format: json
        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "json"))
                .isEqualTo(resultJson);

        // input format: yaml
        // output format: json
        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "json"))
                .isEqualTo(resultJson);
    }
}

