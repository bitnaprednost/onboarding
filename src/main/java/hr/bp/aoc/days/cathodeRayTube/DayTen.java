package hr.bp.aoc.days.cathodeRayTube;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayTen implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DayTen.class);
    List<Instruction> program;

    {
        try {
            program = parseProgram(Files.readString(Path.of("src/main/resources/cathodeRayTube.txt")));
        } catch (IOException e) {
            logger.error("Unable to parse program from Path");
        }
    }


    @Override
    public void executePartOne() {
        logger.info("cathodeRayTube PART 1: {}", part1(program));
    }

    @Override
    public void executePartTwo() {
        logger.info("cathodeRayTube PART 2: {}", part2(program));
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Ten";
    }

    String part2(List<Instruction> program) {
        return IntStream.range(1, 6 * 40 + 1)
                .mapToObj(cycle -> pixelAtCycle(cycle, program) + (cycle % 40 == 0 ? "\n" : ""))
                .collect(Collectors.joining());
    }

    String pixelAtCycle(int cycle, List<Instruction> program) {
        int middle = getState(cycle, program).x;
        Set<Integer> sprite = Set.of(middle, middle - 1, middle + 1);
        return sprite.contains((cycle - 1) % 40) ? "#" : " ";
    }

    int part1(List<Instruction> program) {
        return IntStream.of(20, 60, 100, 140, 180, 220).map(c -> c * getState(c, program).x).sum();
    }

    State getState(int atCycle, List<Instruction> program) {
        State state = new State(1, 1);
        for (var i : program) {
            State newState = run(i, state);
            if (newState.cycle > atCycle) {
                break;
            }
            state = newState;
        }
        return state;
    }

    State run(Instruction i, State state) {
        return switch (i.op) {
            case "noop" -> new State(state.cycle + 1, state.x);
            case "addx" -> new State(state.cycle + 2, state.x + i.value);
            default -> throw new IllegalArgumentException("invalid operation");
        };
    }

    List<Instruction> parseProgram(String input) {
        return input.lines().map(l -> Instruction.parse(l.split(" "))).toList();
    }

    record State(int cycle, int x) {
    }

    record Instruction(String op, int value) {
        static Instruction parse(String... parts) {
            return new Instruction(parts[0], parts[0].equals("noop") ? 0 : Integer.parseInt(parts[1]));
        }
    }
}
