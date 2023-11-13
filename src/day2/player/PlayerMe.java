package day2.player;

import day2.Status;
import day2.player.Player;
import day2.shape.Paper;
import day2.shape.Rock;
import day2.shape.Scissors;
import day2.shape.Shape;

public class PlayerMe implements Player {
    public Rock throwRock() {
        return new Rock();
    }

    public Paper throwPaper() {
        return new Paper();
    }

    public Scissors throwScissors() {
        return new Scissors();
    }

    @Override
    public Shape getShapeFromChar(char code) {
        Shape shape;
        switch (code){
            case 'X' -> shape = new Rock();
            case 'Y' -> shape = new Paper();
            case 'Z' -> shape = new Scissors();
            default -> shape = null;
        }
        return shape;
    }

    public Status statusToShape(char code){
        Status status;
        switch (code){
            case 'X' -> status = Status.LOSE;
            case 'Y' -> status = Status.DRAW;
            case 'Z' -> status = Status.WIN;
            default -> status = null;
        }
        return status;
    }
}
