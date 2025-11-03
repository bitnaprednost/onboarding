package com.bp.aoc.day2;

public enum Outcome {
    LOSE(0),
    DRAW(3),
    WIN(6);

    private final int score;

    Outcome(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static Outcome getOutcomeFromLetter(String letter) {
        return switch (letter) {
            case "X" -> LOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new IllegalArgumentException("Unsupported outcome letter: " + letter);
        };
    }
}
