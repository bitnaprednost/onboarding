package hr.bp.aoc.day3;

import hr.bp.aoc.InputUtil;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RucksackReorganization {
    public static void main(String[] args) throws Exception {
        Path inputFilePath = InputUtil.getPath(RucksackReorganization.class, "inputday3.txt");
        Path filePath = inputFilePath.toAbsolutePath();

        System.out.println(getSum(getBasePriorityCounters(args, Arrays.asList(InputUtil.readLines(filePath)))));
    }

    private static int getSum(List<BasePriorityCounter> basePriorityCounters) {
        int sum = 0;
        for (BasePriorityCounter basePriorityCounter : basePriorityCounters) {
            sum += basePriorityCounter.getCharPriority();
        }
        return sum;
    }

    private static List<BasePriorityCounter> getBasePriorityCounters(String[] args, List<String> lines) {
        List<BasePriorityCounter> basePriorityCounters = new ArrayList<>();

        for (int i = 0; i < lines.size(); i += 3) {

            if (Integer.parseInt(args[0]) == 1) {
                basePriorityCounters.add(new Rucksack(lines.get(i)));
                basePriorityCounters.add(new Rucksack(lines.get(i + 1)));
                basePriorityCounters.add(new Rucksack(lines.get(i + 2)));
            } else if (Integer.parseInt(args[0]) == 2) {
                basePriorityCounters.add(new ThreeRucksacks(lines.get(i), lines.get(i + 1), lines.get(i + 2)));
            }
        }
        return basePriorityCounters;
    }
}