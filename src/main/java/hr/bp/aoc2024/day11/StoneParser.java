package hr.bp.aoc2024.day11;

import hr.bp.aoc2024.util.Parser;

import java.util.Arrays;
import java.util.List;

public class StoneParser extends Parser {

    public StoneParser(List<String> input) {
        super(input);
    }

    @Override
    public List<String> parseInput() {
        return Arrays.stream(super.getInput().get(0).strip().split(" ")).toList();
    }
}
