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
        return switch (code){
            case 'A' -> new Rock();
            case 'B' -> new Paper();
            case 'C' -> new Scissors();
            default -> throw new UnsupportedOperationException();
        };
    }
}
