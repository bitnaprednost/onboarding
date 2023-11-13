package day2.player;

import day2.player.Player;
import day2.shape.Paper;
import day2.shape.Rock;
import day2.shape.Scissors;
import day2.shape.Shape;

public class PlayerOpponent implements Player {
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
            case 'A' -> shape = new Rock();
            case 'B' -> shape = new Paper();
            case 'C' -> shape = new Scissors();
            default -> shape = null;
        }
        return shape;
    }
}
