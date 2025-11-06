package com.bp.aoc.day2;

import java.util.List;

/**
 * @author Ivona Pavela
 */
public class Tournament {

    private final List<String> firstPlayerMoves;
    private final List<String> secondPlayerMoves;

    public Tournament(List<String> firstPlayerMoves, List<String> secondPlayerMoves) {
        this.firstPlayerMoves = firstPlayerMoves;
        this.secondPlayerMoves = secondPlayerMoves;
    }

    public int play(boolean isFirstMode) {
        int score = 0;

        for (int i = 0; i < firstPlayerMoves.size(); i++) {
            Move opponent = Move.getMoveFromLetter(firstPlayerMoves.get(i));

            if (isFirstMode) {
                Move player = Move.getMoveFromLetter(secondPlayerMoves.get(i));
                Outcome outcome = player.versus(opponent);

                score += outcome.getScore() + player.getScore();
            } else {
                Outcome desired = Outcome.getOutcomeFromLetter(secondPlayerMoves.get(i));
                Move player = opponent.moveForOutcomeAgainst(desired, opponent);

                score += desired.getScore() + player.getScore();
            }
        }

        return score;
    }
}
