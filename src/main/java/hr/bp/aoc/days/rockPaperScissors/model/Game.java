package hr.bp.aoc.days.rockPaperScissors.model;

public record Game(String a, String b) {
    private Shape getShape(String s) {
        return switch (s) {
            case "A", "X" -> Shape.ROCK;
            case "B", "Y" -> Shape.PAPER;
            case "C", "Z" -> Shape.SCISSOR;
            default -> throw new RuntimeException(s);
        };
    }
}
