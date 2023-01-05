package hr.bp.aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class InputUtil {
    public static String[] readLines(String filePath) {
        try {
            String input = new String(Files.readAllBytes(Paths.get(filePath)));

            if ((input != null) && !input.isEmpty()) {
                return input.split("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return new String[]{};
    }

    public static Path getPath(Class clazz, String fileName) throws URISyntaxException {
        URL fileURL = clazz.getResource(fileName);

        return Paths.get(fileURL.toURI());
    }
    public static String[] readLines(Path filePath) {
        try {
            String input = new String(Files.readAllBytes(filePath));

            if ((input != null) && !input.isEmpty()) {
                return input.split("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return new String[]{};
    }

}