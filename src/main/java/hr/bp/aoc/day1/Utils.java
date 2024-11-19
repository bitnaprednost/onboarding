package hr.bp.aoc.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> readFromFile(String filepath) {
        BufferedReader reader;
        List<String> document = new ArrayList<>();

        try {
            Utils utils = new Utils();
            File file = utils.getFileFromResource(filepath);

            document = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return document;
    }

    private File getFileFromResource(String filepath) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filepath);

        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + filepath);
        } else {
            return new File(resource.toURI());
        }
    }
}
