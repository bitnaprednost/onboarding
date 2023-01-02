package hr.bp.aoc.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MarkerUtil {
    static int numberOfCharactersMarker4(String input) {
        List<Character> bufferPart1 = new ArrayList<>();
        int count = 0;

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

            count++;
        }
        return count;
    }

    static int numberOfCharactersMarker14(String input) {
        List<Character> bufferPart2 = new ArrayList<>();
        int count = 0;

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
            count++;
        }
        return count;
    }
}
