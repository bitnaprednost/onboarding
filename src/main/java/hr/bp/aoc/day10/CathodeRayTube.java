package hr.bp.aoc.day10;

import hr.bp.aoc.InputUtil;

import java.util.*;

public class CathodeRayTube {
    static int X = 1;
    static Integer[] A = {20, 60, 100, 140, 180, 220};
    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day10/inputday10.txt";
        List<String> input = new ArrayList<>(Arrays.asList(InputUtil.readLines(filePath)));
        Set<Integer> set = new HashSet<>(Arrays.asList(A));

        int sumOfSignalStrengths = sumSixSignalStrengths(input,set);
        System.out.println(sumOfSignalStrengths);
    }

    private static int sumSixSignalStrengths(List<String> input, Set<Integer> set) {
        int sum = 0;
        int cycle = 0;
        for (String s : input) {
            String[] parts = s.split(" ");
            if (parts[0].equals("noop")) {
                cycle++;
                if (set.contains(cycle)) {
                    sum += cycle * X;
                }
            } else if (parts[0].equals("addx")) {
                int V = Integer.parseInt(parts[1]);
                X += V;
                cycle++;
                if (set.contains(cycle)) {
                    sum += cycle * (X - V);
                }
                cycle++;
                if (set.contains(cycle)) {
                    sum += cycle * (X - V);
                }
            }
        }
        return sum;
    }

}
