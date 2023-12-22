package hr.bp.aoc.rucksack.reorganization;

import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Path path = Path.of("src/main/resources/day3Data.txt");
        String input = Reader.getTextFromFile(path);

        // p => 112 - 16 = 96
        // L => 76 - 38 = 38
        // P => 80 - 42 = 38
        // v => 118 - 22 = 96
        // t => 116 - 20 = 96
        // s => 115 - 19 = 96

        int result1 = Arrays.stream(input.split("\n"))
                .map(line -> line.substring(0, line.length() / 2).chars()
                        .filter(l1 -> line.substring(line.length() / 2).chars().anyMatch(l2 -> l1 == l2))
                        .map(ch -> ch > 90 ? ch - 96 : ch - 38).findFirst())
                .mapToInt(OptionalInt::getAsInt).sum();

        System.out.println(result1);

        int result2 = Arrays.stream(input.concat("\n").split("\n(?=(?:.+\n.+\n.+\n)*$)")).map(line -> {
            String[] split = line.split("\n");
            return split[0].chars().filter(l1 -> split[1].chars().anyMatch(l2 -> l1 == l2))
                    .filter(l3 -> split[2].chars().anyMatch(l4 -> l3 == l4))
                    .map(ch -> ch > 90 ? ch - 96 : ch - 38).findFirst();
        }).mapToInt(OptionalInt::getAsInt).sum();

        System.out.println(result2);
    }
}
