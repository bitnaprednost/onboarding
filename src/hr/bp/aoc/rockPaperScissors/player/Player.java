package hr.bp.aoc.rockPaperScissors.player;

import hr.bp.aoc.rockPaperScissors.shape.Paper;
import hr.bp.aoc.rockPaperScissors.shape.Rock;
import hr.bp.aoc.rockPaperScissors.shape.Scissors;
import hr.bp.aoc.rockPaperScissors.shape.Shape;

public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
