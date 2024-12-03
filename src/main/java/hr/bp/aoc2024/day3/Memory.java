package hr.bp.aoc2024.day3;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<Command> comands;

    public Memory(List<String> comands) {
        this.comands = getCommandsFromString(comands);
    }

    private static List<Command> getCommandsFromString(List<String> commandsString) {
        List<Command> commands = new ArrayList<>();

        for (String commandString : commandsString) {
            commands.add(new Command(commandString));
        }

        return commands;
    }

    public long getMultiplicationSum() {
        long mulSum = 0;

        for (Command command : comands) {
            mulSum += command.getResultOfMul();
        }

        return mulSum;
    }
}
