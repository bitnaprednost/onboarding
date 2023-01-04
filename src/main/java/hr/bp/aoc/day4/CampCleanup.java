package hr.bp.aoc.day4;

import hr.bp.aoc.InputUtil;
import java.util.List;

public class CampCleanup {

    public static void main(String[] args) {

        String filePath = "src/hr/bp/aoc/day4/inputday4.txt";
        String[] assignments = InputUtil.readLines(filePath);

        List<Integer> result = PairsUtil.numberOfPairsInEachPart(assignments);
        System.out.println(result.get(0) + "\n" + result.get(1));
    }

}