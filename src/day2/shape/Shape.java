package day2.shape;

import day2.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
