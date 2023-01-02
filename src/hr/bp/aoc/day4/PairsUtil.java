package hr.bp.aoc.day4;

import java.util.ArrayList;
import java.util.List;

public class PairsUtil {
    static List<Integer> numberOfPairsInEachPart(String[] assignments) {
        List<Integer> numberOfPairs = new ArrayList<>();
        int contains = 0;
        int overlapPart2 = 0;

        for (String assignment : assignments) {
            String task = assignment.trim();

            int firstMinus = task.indexOf("-");
            int positionComma = task.indexOf(",", firstMinus);
            int secondMinus = task.indexOf("-", positionComma);

            String[] first = {task.substring(0, firstMinus).trim(), task.substring(firstMinus + 1, positionComma).trim()};
            String[] second = {task.substring(positionComma + 1, secondMinus).trim(), task.substring(secondMinus + 1).trim()};

            int begFirst = Integer.parseInt(first[0]);
            int endFirst = Integer.parseInt(first[1]);
            int begSecond = Integer.parseInt(second[0]);
            int endSecond = Integer.parseInt(second[1]);
            if (begFirst >= begSecond && endFirst <= endSecond) {
                contains++;
                overlapPart2++;
            } else if (begFirst <= begSecond && endFirst >= endSecond) {
                contains++;
                overlapPart2++;
            } else if (begSecond <= begFirst && endSecond <= endFirst && begFirst <= endSecond) {
                overlapPart2++;
            } else if (begSecond >= begFirst && endSecond >= endFirst && begSecond <= endFirst) {
                overlapPart2++;
            } else if (endFirst == endSecond || begFirst == begSecond || endFirst == begSecond || endSecond == begFirst) {
                overlapPart2++;
            }
        }
        numberOfPairs.add(contains);
        numberOfPairs.add(overlapPart2);
        return numberOfPairs;
    }
}
