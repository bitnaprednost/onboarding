package hr.bp.rockPaperScissors.player;

import hr.bp.rockPaperScissors.shape.Paper;
import hr.bp.rockPaperScissors.shape.Rock;
import hr.bp.rockPaperScissors.shape.Scissors;
import hr.bp.rockPaperScissors.shape.Shape;

public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
