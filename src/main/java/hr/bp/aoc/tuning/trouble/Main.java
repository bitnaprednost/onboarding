package hr.bp.aoc.tuning.trouble;

import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static int firstSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .map(subStream -> textFromFile.substring(subStream).chars()
                        .limit(consecutive)
                        .distinct()
                        .count() == consecutive ? subStream + consecutive : -1)
                .filter(count -> count > 0)
                .findFirst().getAsInt();
    }

    public static int secondSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .takeWhile(subStream -> textFromFile.substring(subStream).chars()
                        .limit(consecutive)
                        .distinct()
                        .count() < consecutive)
                .max().getAsInt() + consecutive + 1;
    }

    public static int thirdSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .dropWhile(subStream -> textFromFile.substring(subStream).chars()
                        .limit(consecutive)
                        .distinct()
                        .count() < consecutive)
                .findFirst().getAsInt() + consecutive;
    }

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day6Data.txt");
        String textFromFile = Reader.getTextFromFile(path);

        logger.info(String.valueOf(firstSolution(textFromFile, 4)));
        logger.info(String.valueOf(secondSolution(textFromFile, 4)));
        logger.info(String.valueOf(thirdSolution(textFromFile, 4)));
        logger.info(String.valueOf(thirdSolution(textFromFile, 14)));

    }
}
