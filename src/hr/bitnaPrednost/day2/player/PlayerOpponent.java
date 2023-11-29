package hr.bitnaPrednost.day2.player;

import hr.bitnaPrednost.day2.shape.Paper;
import hr.bitnaPrednost.day2.shape.Rock;
import hr.bitnaPrednost.day2.shape.Scissors;
import hr.bitnaPrednost.day2.shape.Shape;

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
