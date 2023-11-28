package org.example.days.D02_RockPaperScissors.model;

import static org.example.days.D02_RockPaperScissors.model.Shape.*;

public record Game(String a, String b) {
    private Shape getShape(String s) {
        return switch (s) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSOR;
            default -> throw new RuntimeException(s);
        };
    }
}
