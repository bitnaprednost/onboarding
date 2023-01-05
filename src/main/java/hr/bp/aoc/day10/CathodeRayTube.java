package hr.bp.aoc.day10;

import hr.bp.aoc.InputUtil;
import java.nio.file.Path;
import java.util.*;

public class CathodeRayTube {
    static List<Integer> X = new ArrayList<>();
    private final static Integer[] A = {20, 60, 100, 140, 180, 220};

    public static void main(String[] args) throws Exception{

        Path inputFilePath = InputUtil.getPath(CathodeRayTube.class, "inputday10.txt");
        Path filePath = inputFilePath.toAbsolutePath();
        List<String> input = new ArrayList<>(Arrays.asList(InputUtil.readLines(filePath)));
        X.add(1);
        Set<Integer> set = new HashSet<>(Arrays.asList(A));

        //Part One
        int sumOfSignalStrengths = sumSixSignalStrengths(input, set);
        System.out.println(sumOfSignalStrengths);

        //Part Two
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                int currentCycle = i * 40 + j + 1;
                if(Math.abs(X.get(currentCycle-1)-j)<=1){
                    System.out.print("##");
                }else{
                    System.out.print("..");
                }
            }
            System.out.println();
        }
    }

    private static int sumSixSignalStrengths(List<String> input, Set<Integer> set) {
        int currentX = X.get(0);
        int sum = 0;
        int cycle = 0;
        for (String s : input) {
            String[] parts = s.split(" ");
            if (parts[0].equals("noop")) {
                cycle++;
                X.add(cycle, currentX);
                if (set.contains(cycle)) {
                    sum += cycle * X.get(cycle);
                }
            } else if (parts[0].equals("addx")) {
                int V = Integer.parseInt(parts[1]);
                X.add(cycle + 1, currentX);
                currentX += V;
                cycle++;
                if (set.contains(cycle)) {
                    sum += cycle * (currentX - V);
                }
                cycle++;
                if (set.contains(cycle)) {
                    sum += cycle * (currentX - V);
                }
                X.add(cycle, currentX);
            }
        }
        return sum;
    }

}
