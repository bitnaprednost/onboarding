package hr.bp.aoc.supply.stacks.crane;

/**
 * <p>Crane interface.</p>
 *
 * @author Marko Krišković
 */
public interface Crane {
    void move(int amount, int from, int to);
    void parseCommand(String command);
}
