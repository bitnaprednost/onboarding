package com.bp.aoc.day2;

import java.util.List;

/**
 * @author Ivona Pavela
 */
public class Tournament {

    public static int play(List<String> firstColumn, List<String> secondColumn, boolean isFirstMode) {
        int score = 0;

        for (int i = 0; i < firstColumn.size(); i++) {
            int opponentMove = NumberFromMove.getNumberFromMove(firstColumn.get(i));
            int secondInput = NumberFromMove.getNumberFromMove(secondColumn.get(i));

            score += isFirstMode ? scoreFirstMode(opponentMove, secondInput) : scoreSecondMode(opponentMove, secondInput);
        }

        return score;
    }

    public static int scoreFirstMode(int opponentMove, int playerMove) {
        int difference = playerMove - opponentMove;

        return switch (difference) {
            case 0 -> 3 + playerMove;
            case -2, 1 -> 6 + playerMove;
            case 2, -1 -> playerMove;
            default -> throw new IllegalArgumentException("Invalid difference: " + difference);
        };
    }

    public static int scoreSecondMode(int opponentMove, int endOfRound) {
        return switch (endOfRound) {
            case 2 -> 3 + opponentMove;
            case 1 -> (opponentMove == 1) ? 3 : (opponentMove - 1);
            case 3 -> 6 + ((opponentMove == 3) ? 1 : (opponentMove + 1));
            default -> throw new IllegalArgumentException("Invalid end of round");
        };
    }
}
