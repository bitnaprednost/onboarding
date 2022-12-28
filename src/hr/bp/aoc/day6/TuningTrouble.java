package hr.bp.aoc.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class TuningTrouble {

    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day6/inputday6.txt";
        String input = readFile(filePath);
        System.out.println(input);
        input.trim();

        //Part1
        ArrayList<Character> bufferPart1 = new ArrayList<Character>();
        int idxPart1 = 0;

        for (int i = 0; i < input.length(); i++) {
            if (bufferPart1.size() == 4) {
                if (new HashSet<>(bufferPart1).size() == 4) {
                    break;
                }
                bufferPart1.add(input.charAt(i));
                bufferPart1.remove(0);
            } else {
                bufferPart1.add(input.charAt(i));
            }

            idxPart1++;
        }
        System.out.println(idxPart1);

        //Part2
        ArrayList<Character> bufferPart2 = new ArrayList<Character>();
        int idxPart2 = 0;

        for (int i = 0; i < input.length(); i++) {
            if (bufferPart2.size() == 14) {
                if (new HashSet<>(bufferPart2).size() == 14) {
                    break;
                }
                bufferPart2.add(input.charAt(i));
                bufferPart2.remove(0);
            } else {
                bufferPart2.add(input.charAt(i));
            }
            idxPart2++;
        }

        System.out.println(idxPart2);
    }

    private static String readFile(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }
}
