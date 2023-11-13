package day2.shape;

import day2.Status;
import day2.shape.Shape;

public class Paper implements Shape {
    private final static int score = 2;
    @Override
    public Status simulateAgainst(Shape shape) {
        if (shape.getClass().equals(Rock.class)) {
            return Status.WIN;
        } else if (shape.getClass().equals(Paper.class)) {
            return Status.DRAW;
        } else if (shape.getClass().equals(Scissors.class)) {
            return Status.LOSE;
        }
        return null;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Shape winingMove() {
        return new Scissors();
    }

    @Override
    public Shape losingMove() {
        return new Rock();
    }

    @Override
    public Shape drawingMove() {
        return new Paper();
    }

    @Override
    public Shape elfStrategy(Status status) {
        if(status==Status.WIN) return winingMove();
        else if(status==Status.DRAW) return drawingMove();
        else if(status==Status.LOSE) return losingMove();
        return null;
    }
}
