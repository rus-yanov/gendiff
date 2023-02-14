package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class DifferTest {

    private String file1Path;
    private String file2Path;
    private String stylishContent;

    @BeforeAll
    public String getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toFile().getAbsolutePath();
    }

    @BeforeAll
    public String getContent(String fileName) throws IOException {
        Path filePath = Path.of(getPath(fileName));
        return Files.readString(filePath).trim();
    }

    @BeforeEach
    public void doBeforeEach() throws IOException {
        file1Path = getPath("file1.json");
        file2Path = getPath("file2.json");
        stylishContent = getContent("result_stylish.txt");
    }

    @Test
    public void generateTest() throws Exception {

        assertThat(Differ.generate(file1Path, file2Path, "stylish"))
                .isEqualTo(stylishContent);
    }
}

