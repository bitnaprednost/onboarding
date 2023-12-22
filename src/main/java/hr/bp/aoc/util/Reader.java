package hr.bp.aoc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Parser interface.</p>
 *
 * @author Marko Krišković
 */
public interface Reader {

     static String getTextFromFile(Path filePath) throws IOException {
        String everything = null;
        try (Stream<String> linesStream = Files.lines(filePath)) {
            everything = linesStream.collect(Collectors.joining("\n"));
        }
        //catch?
        return everything;
    }

    static String[] getLinesFromFile(Path filePath) throws IOException {
        String[] everything = null;
        try (Stream<String> linesStream = Files.lines(filePath)) {
            everything = linesStream.toArray(String[]::new);
        }
        //catch?
        return everything;
    }

}
