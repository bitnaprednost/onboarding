package day2.player;

import day2.shape.Paper;
import day2.shape.Rock;
import day2.shape.Scissors;
import day2.shape.Shape;

public interface Player {
    Rock throwRock();
    Paper throwPaper();
    Scissors throwScissors();
    Shape getShapeFromChar(char myCode);
}
