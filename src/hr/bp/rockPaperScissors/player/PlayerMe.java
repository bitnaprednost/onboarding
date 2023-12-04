package hr.bp.rockPaperScissors.player;

import hr.bp.rockPaperScissors.Status;
import hr.bp.rockPaperScissors.shape.Paper;
import hr.bp.rockPaperScissors.shape.Rock;
import hr.bp.rockPaperScissors.shape.Scissors;
import hr.bp.rockPaperScissors.shape.Shape;

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
        return switch (code){
            case 'X' -> new Rock();
            case 'Y' -> new Paper();
            case 'Z' -> new Scissors();
            default -> throw new UnsupportedOperationException();
        };
    }

    public Status statusToShape(char code){
        return switch (code){
            case 'X' -> Status.LOSE;
            case 'Y' -> Status.DRAW;
            case 'Z' -> Status.WIN;
            default -> throw new UnsupportedOperationException();
        };
    }
}
