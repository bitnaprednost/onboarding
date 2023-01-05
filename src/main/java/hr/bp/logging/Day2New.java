package hr.bp.logging;

import hr.bp.aoc.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2New {

    private static final Logger logger = LoggerFactory.getLogger(Day2New.class);

    public static void main(String[] args) throws Exception {

        Path inputFilePath = InputUtil.getPath(hr.bp.aoc.day2.RockPaperScissors.class, "inputday2.txt");
        Path filePath = inputFilePath.toAbsolutePath();

        List<String> lines = new ArrayList<>();
        Collections.addAll(lines, InputUtil.readLines(filePath));
        calculateBothScores(lines);
    }

    public static void calculateBothScores(List<String> lines) {
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

        if(logger.isInfoEnabled()){
            logger.info("First score {}",firstScore);
            logger.info("Second score {}",secondScore);
        }

    }
}
