package hr.bp.supplyStacks.crane;

public interface Crane {
    void move(int amount, int from, int to);
    void parseCommand(String command);
}
