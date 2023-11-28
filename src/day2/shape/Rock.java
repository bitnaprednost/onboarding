package day2.shape;

import day2.Status;
import day2.shape.Shape;

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
