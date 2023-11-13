package day2.shape;

import day2.Status;

public interface Shape {
    Status simulateAgainst(Shape shape);

    int getScore();
    Shape winingMove();
    Shape losingMove();
    Shape drawingMove();
    Shape elfStrategy(Status status);
}
