package hr.bp.aoc.rockPaperScissors.shape;

import hr.bp.aoc.rockPaperScissors.Status;

public class Rock implements Shape {
    private final static int score = 1;
    @Override
    public Status simulateAgainst(Shape shape) {
        return switch (shape) {
            case Rock r -> Status.DRAW;
            case Paper p -> Status.LOSE;
            case Scissors s -> Status.WIN;
            default -> null;
        };
    }

    @Override
    public int getScore() {
        return score;
    }

    private static Shape winingMove() {
        return new Paper();
    }

    private static Shape losingMove() {
        return new Scissors();
    }

    private static Shape drawingMove() {
        return new Rock();
    }

    @Override
    public Shape elfStrategy(Status status) {
        return switch (status){
            case WIN -> winingMove();
            case LOSE -> losingMove();
            case DRAW -> drawingMove();
        };
    }
}
