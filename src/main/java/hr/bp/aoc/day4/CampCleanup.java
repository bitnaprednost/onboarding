package hr.bp.aoc.day4;

import hr.bp.aoc.InputUtil;
import java.nio.file.Path;
import java.util.List;

public class CampCleanup {

    public static void main(String[] args) throws Exception {

        Path inputFilePath = InputUtil.getPath(CampCleanup.class, "inputday4.txt");
        Path filePath = inputFilePath.toAbsolutePath();

        String[] assignments = InputUtil.readLines(filePath);

        List<Integer> result = PairsUtil.numberOfPairsInEachPart(assignments);
        System.out.println(result.get(0) + "\n" + result.get(1));
    }

}