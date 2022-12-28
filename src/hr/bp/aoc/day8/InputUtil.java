package hr.bp.aoc.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputUtil {
    static String[] readLines(String filePath) {
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
}