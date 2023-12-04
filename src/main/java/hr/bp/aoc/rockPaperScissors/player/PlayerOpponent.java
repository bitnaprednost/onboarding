package hr.bp.aoc.rockPaperScissors.player;

import hr.bp.aoc.rockPaperScissors.shape.Paper;
import hr.bp.aoc.rockPaperScissors.shape.Rock;
import hr.bp.aoc.rockPaperScissors.shape.Scissors;
import hr.bp.aoc.rockPaperScissors.shape.Shape;

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
