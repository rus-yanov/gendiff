package hexlet.code;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

    private static String file1Path;
    private static String file2Path;
    private static String stylishContent;

    @BeforeAll
    public static String getPath(String fileName) {
        return Paths.get("src","test","resources", fileName)
                .toFile().getAbsolutePath();
    }

    @BeforeAll
    public static String getContent(String fileName) throws IOException {
        Path filePath = Path.of(getPath(fileName));
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void doBeforeAll() throws IOException {
        file1Path = getPath("file1.json");
        file2Path = getPath("file2.json");
        stylishContent = getContent("result_stylish.txt");
    }

    @Test
    public void generateTest() throws Exception {

        assertThat(Differ.generate(file1Path, file2Path, "stylish"))
                .isEqualTo(stylishContent);
    }

    private <SELF extends AbstractBigDecimalAssert<SELF>>
    AbstractBigDecimalAssert<SELF> assertThat(String stylish) {
        return null;
    }
}
