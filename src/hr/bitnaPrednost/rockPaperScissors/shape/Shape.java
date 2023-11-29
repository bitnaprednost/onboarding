package hr.bitnaPrednost.rockPaperScissors.shape;

import hr.bitnaPrednost.rockPaperScissors.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
