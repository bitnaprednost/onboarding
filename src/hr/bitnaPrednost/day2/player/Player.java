package hr.bitnaPrednost.day2.player;

import hr.bitnaPrednost.day2.shape.Paper;
import hr.bitnaPrednost.day2.shape.Rock;
import hr.bitnaPrednost.day2.shape.Scissors;
import hr.bitnaPrednost.day2.shape.Shape;

public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
