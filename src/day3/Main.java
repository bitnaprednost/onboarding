package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static String getTextFromFile(String file) throws IOException {
        String everything = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        return everything;
    }
    public static void main(String args[]) throws IOException {
        String input = getTextFromFile("Resources/day3Data.txt");

        // p => 112 - 16 = 96
        // L => 76 - 38 = 38
        // P => 80 - 42 = 38
        // v => 118 - 22 = 96
        // t => 116 - 20 = 96
        // s => 115 - 19 = 96
        int result1 = Arrays.stream(input.split("\n")).map(line -> {
            String line1 = line.substring(0, line.length() / 2);
            String line2 = line.substring(line.length() / 2);
            return line1.chars().filter(l1 -> line2.chars().anyMatch(l2 -> l1 == l2))
                    .map(ch -> ch = ch > 90 ? ch - 96 : ch - 38).findFirst();
        }).mapToInt(OptionalInt::getAsInt).sum();

        System.out.println(result1);

        int result2 = Arrays.stream(input.concat("\n").split("\n(?=(?:.+\n.+\n.+\n)*$)")).map(line -> {
            String[] split = line.split("\n");
            return split[0].chars().filter(l1 -> split[1].chars().anyMatch(l2 -> l1 == l2))
                    .filter(l3 -> split[2].chars().anyMatch(l4 -> l3 == l4))
                    .map(ch -> ch = ch > 90 ? ch - 96 : ch - 38).findFirst();
        }).mapToInt(OptionalInt::getAsInt).sum();

        System.out.println(result2);
    }
}
