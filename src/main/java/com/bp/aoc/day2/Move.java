package com.bp.aoc.day2;

public enum Move {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int score;

    Move(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static Move getMoveFromLetter(String letter) {
        return switch (letter) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSORS;
            default -> throw new IllegalArgumentException("Unsupported move letter: " + letter);
        };
    }

    public Outcome versus(Move opponent) {
        if (this == opponent) return Outcome.DRAW;

        return switch (this) {
            case ROCK -> (opponent == SCISSORS) ? Outcome.WIN : Outcome.LOSE;
            case PAPER -> (opponent == ROCK) ? Outcome.WIN : Outcome.LOSE;
            case SCISSORS -> (opponent == PAPER) ? Outcome.WIN : Outcome.LOSE;
        };
    }

    public Move thatBeatsMe() {
        return switch (this) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }

    public Move thatIBeat() {
        return switch (this) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    public Move moveForOutcomeAgainst(Outcome desired, Move opponent) {
        return switch (desired) {
            case DRAW -> opponent;
            case WIN -> opponent.thatBeatsMe();
            case LOSE -> opponent.thatIBeat();
        };
    }
}
