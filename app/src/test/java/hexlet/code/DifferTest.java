package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
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
    private String stylishContent;

    public String getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toFile().getAbsolutePath();
    }

    public String getContent(String fileName) throws IOException {
        Path filePath = Path.of(getPath(fileName));
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public void doBeforeEach() throws IOException {
        jsonFilePath1 = getPath("file1.json");
        jsonFilePath2 = getPath("file2.json");
        yamlFilePath1 = getPath("file1.yml");
        yamlFilePath2 = getPath("file2.yml");
        stylishContent = getContent("result_stylish.txt");

    }

    @Test
    public void generateTest() throws Exception {
        // test json format
        assertThat(Differ.generate(jsonFilePath1, jsonFilePath2, "stylish"))
                .isEqualTo(stylishContent);

        // test yaml format
        assertThat(Differ.generate(yamlFilePath1, yamlFilePath2, "stylish"))
                .isEqualTo(stylishContent);
    }
}

