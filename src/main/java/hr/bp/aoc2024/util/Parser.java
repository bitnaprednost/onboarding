package hr.bp.aoc2024.util;

import java.util.List;

public abstract class Parser {
    private List<String> input;

    public Parser(List<String> input) {
        this.input = input;
    }

    public List<String> getInput() {
        return input;
    }

    public abstract List<String> parseInput();
}
