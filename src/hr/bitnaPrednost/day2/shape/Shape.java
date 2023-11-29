package hr.bitnaPrednost.day2.shape;

import hr.bitnaPrednost.day2.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
