package hr.bp.rockPaperScissors.player;

import hr.bp.rockPaperScissors.shape.Paper;
import hr.bp.rockPaperScissors.shape.Rock;
import hr.bp.rockPaperScissors.shape.Scissors;
import hr.bp.rockPaperScissors.shape.Shape;

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
