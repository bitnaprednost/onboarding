package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static String getTextFromFile(String fileName) throws IOException {
        String everything = null;
        try (Stream<String> linesStream = Files.lines(new File(fileName).toPath())) {
            everything = linesStream.collect(Collectors.joining("\n"));
        }
        return everything;
    }
}
