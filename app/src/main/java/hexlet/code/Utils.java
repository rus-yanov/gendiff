package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    // getting absolute path to file and reading content
    public static String getContent(String pathToFile)
            throws Exception {

        File file = new File(pathToFile);
        String absolutePath = file.getAbsolutePath();
        Path pathFile = Path.of(absolutePath);
        return Files.readString(pathFile);
    }

    // getting file extension
    public static String getFileExtension(String pathToFile) {

        int index = pathToFile.lastIndexOf('.');
        return index > 0 ? pathToFile.substring(index + 1) : "";
    }
}
