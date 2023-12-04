package hr.bp.aoc.rockPaperScissors.shape;

import hr.bp.aoc.rockPaperScissors.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
