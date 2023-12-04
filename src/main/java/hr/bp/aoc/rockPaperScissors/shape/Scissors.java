package hr.bp.aoc.rockPaperScissors.shape;

import hr.bp.aoc.rockPaperScissors.Status;

public class Scissors implements Shape {
    private final static int score = 3;
    @Override
    public Status simulateAgainst(Shape shape) {
        return switch (shape) {
            case Rock r -> Status.LOSE;
            case Paper p -> Status.WIN;
            case Scissors s -> Status.DRAW;
            default -> throw new UnsupportedOperationException();
        };
    }

    @Override
    public int getScore() {
        return score;
    }

    private static Shape winingMove() {
        return new Rock();
    }

    private static Shape losingMove() {
        return new Paper();
    }

    private static Shape drawingMove() {
        return new Scissors();
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
