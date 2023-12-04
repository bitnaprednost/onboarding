package hr.bp.rockPaperScissors.shape;

import hr.bp.rockPaperScissors.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
