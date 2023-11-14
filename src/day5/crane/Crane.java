package day5.crane;

import java.util.Arrays;

public interface Crane {
    void move(int amount, int from, int to);
    void parseCommand(String command);
}
