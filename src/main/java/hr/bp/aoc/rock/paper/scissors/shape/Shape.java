package hr.bp.aoc.rock.paper.scissors.shape;

import hr.bp.aoc.rock.paper.scissors.Status;

/**
 * <p>Shape interface.</p>
 *
 * @author Marko Krišković
 */
public interface Shape {
    Status simulateAgainst(Shape shape);
    int getScore();
    Shape elfStrategy(Status status);
}
