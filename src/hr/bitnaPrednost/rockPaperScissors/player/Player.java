package hr.bitnaPrednost.rockPaperScissors.player;

import hr.bitnaPrednost.rockPaperScissors.shape.Paper;
import hr.bitnaPrednost.rockPaperScissors.shape.Rock;
import hr.bitnaPrednost.rockPaperScissors.shape.Scissors;
import hr.bitnaPrednost.rockPaperScissors.shape.Shape;

public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
