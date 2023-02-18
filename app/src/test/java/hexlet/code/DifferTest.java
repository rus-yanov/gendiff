package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

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

        resultStylish = getContent("result_stylish.txt");
        resultPlain = getContent("result_plain.txt");
        resultJson = getContent("result_json.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public final void generateTest(String format) throws Exception {

        String filePath1 = getPath("file1." + format);
        String filePath2 = getPath("file2." + format);

        // output format: default
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(resultStylish);

        // output format: stylish
        assertThat(Differ.generate(filePath1, filePath2, "stylish"))
                .isEqualTo(resultStylish);

        // output format: plain
        assertThat(Differ.generate(filePath1, filePath2, "plain"))
                .isEqualTo(resultPlain);

        // output format: json
        assertThat(Differ.generate(filePath1, filePath2, "json"))
                .isEqualTo(resultJson);
    }
}
