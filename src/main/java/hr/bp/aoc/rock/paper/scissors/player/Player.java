package hr.bp.aoc.rock.paper.scissors.player;

import hr.bp.aoc.rock.paper.scissors.shape.Paper;
import hr.bp.aoc.rock.paper.scissors.shape.Rock;
import hr.bp.aoc.rock.paper.scissors.shape.Scissors;
import hr.bp.aoc.rock.paper.scissors.shape.Shape;

/**
 * <p>Player interface.</p>
 *
 * @author Marko Krišković
 */
public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
