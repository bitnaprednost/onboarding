package hr.bp.aoc.tuning.trouble;

import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
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

        System.out.println(firstSolution(textFromFile, 4));
        System.out.println(secondSolution(textFromFile, 4));
        System.out.println(thirdSolution(textFromFile, 4));
        System.out.println(thirdSolution(textFromFile, 15));

    }
}
