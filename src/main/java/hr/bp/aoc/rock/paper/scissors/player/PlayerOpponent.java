package hr.bp.aoc.rock.paper.scissors.player;

import hr.bp.aoc.rock.paper.scissors.shape.Paper;
import hr.bp.aoc.rock.paper.scissors.shape.Rock;
import hr.bp.aoc.rock.paper.scissors.shape.Scissors;
import hr.bp.aoc.rock.paper.scissors.shape.Shape;

/**
 * <p>PlayerOpponent class.</p>
 *
 * @author Marko Krišković
 */
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
