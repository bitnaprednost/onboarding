package hr.bp.aoc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Parser {

     static String getTextFromFile(String fileName) throws IOException {
        String everything = null;
        try (Stream<String> linesStream = Files.lines(new File(fileName).toPath())) {
            everything = linesStream.collect(Collectors.joining("\n"));
        }
        //catch?
        return everything;
    }

    static String[] getLinesFromFile(String fileName) throws IOException {
        String[] everything = null;
        try (Stream<String> linesStream = Files.lines(new File(fileName).toPath())) {
            everything = linesStream.toArray(String[]::new);
        }
        //catch?
        return everything;
    }

}
