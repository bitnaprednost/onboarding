package hr.bp.rockPaperScissors.shape;

import hr.bp.rockPaperScissors.Status;

public class Paper implements Shape {
    private final static int score = 2;
    @Override
    public Status simulateAgainst(Shape shape) {
        return switch (shape) {
            case Rock r -> Status.WIN;
            case Paper p -> Status.DRAW;
            case Scissors s -> Status.LOSE;
            default -> throw new UnsupportedOperationException();
        };
    }

    @Override
    public int getScore() {
        return score;
    }

    private static Shape winingMove() {
        return new Scissors();
    }

    private static Shape losingMove() {
        return new Rock();
    }

    private static Shape drawingMove() {
        return new Paper();
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
