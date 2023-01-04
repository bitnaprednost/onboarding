package hr.bp.aoc.day2;

import hr.bp.aoc.InputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors {

    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day2/inputday2.txt";

        List<String> lines = new ArrayList<>();
        Collections.addAll(lines, InputUtil.readLines(filePath));

        List<Integer> firstAndSecondScore = calculateBothScores(lines);
        System.out.println(firstAndSecondScore);
    }

    public static List<Integer> calculateBothScores(List<String> lines) {
        int firstScore = 0;
        int secondScore = 0;

        for (String line : lines) {
            char opponentChoice = line.charAt(0);
            char myChoice = line.charAt(2);
            if (opponentChoice == 'A' && myChoice == 'X') {
                firstScore += 1 + 3;
                secondScore += 3;
            } else if (opponentChoice == 'A' && myChoice == 'Y') {
                firstScore += 2 + 6;
                secondScore += 3 + 1;
            } else if (opponentChoice == 'A' && myChoice == 'Z') {
                firstScore += 3;
                secondScore += 6 + 2;
            } else if (opponentChoice == 'B' && myChoice == 'X') {
                firstScore += 1;
                secondScore += 1;
            } else if (opponentChoice == 'B' && myChoice == 'Y') {
                firstScore += 2 + 3;
                secondScore += 3 + 2;
            } else if (opponentChoice == 'B' && myChoice == 'Z') {
                firstScore += 3 + 6;
                secondScore += 6 + 3;
            } else if (opponentChoice == 'C' && myChoice == 'X') {
                firstScore += 1 + 6;
                secondScore += 2;
            } else if (opponentChoice == 'C' && myChoice == 'Y') {
                firstScore += 2;
                secondScore += 3 + 3;
            } else if (opponentChoice == 'C' && myChoice == 'Z') {
                firstScore += 3 + 3;
                secondScore += 6 + 1;
            }
        }

        List<Integer> scores = new ArrayList<>();
        scores.add(firstScore);
        scores.add(secondScore);
        return scores;
    }
}