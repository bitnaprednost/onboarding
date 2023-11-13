package day2.shape;

import day2.Status;
import day2.shape.Shape;

public class Scissors implements Shape {
    private final static int score = 3;
    @Override
    public Status simulateAgainst(Shape shape) {
        if (shape.getClass().equals(Rock.class)) {
            return Status.LOSE;
        } else if (shape.getClass().equals(Paper.class)) {
            return Status.WIN;
        } else if (shape.getClass().equals(Scissors.class)) {
            return Status.DRAW;
        }
        return null;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Shape winingMove() {
        return new Rock();
    }

    @Override
    public Shape losingMove() {
        return new Paper();
    }

    @Override
    public Shape drawingMove() {
        return new Scissors();
    }

    @Override
    public Shape elfStrategy(Status status) {
        if(status==Status.WIN) return winingMove();
        else if(status==Status.DRAW) return drawingMove();
        else if(status==Status.LOSE) return losingMove();
        return null;
    }
}
