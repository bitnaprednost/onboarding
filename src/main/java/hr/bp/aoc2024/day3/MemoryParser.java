package hr.bp.aoc2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryParser {
    private final String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
    private List<String> memory;

    public MemoryParser(List<String> memory) {
        this.memory = memory;
    }

    public List<String> getCommands() {
        List<String> commandsFound = new ArrayList<>();

        for (String commandLine : memory) {
            Matcher m = Pattern.compile(regex).matcher(commandLine);
            while (m.find()) {
                int commandIndStart = m.start();
                commandsFound.add(findCommandFromStartIndex(commandIndStart, commandLine));
            }

        }

        return commandsFound;
    }

    private String findCommandFromStartIndex(int startIndex, String commandLine) {
        StringBuilder stringBuilder = new StringBuilder();

        char currChar = commandLine.charAt(startIndex);
        while(currChar != ')') {
            stringBuilder.append(currChar);
            currChar = commandLine.charAt(++startIndex);
        }
        stringBuilder.append(')');

        return stringBuilder.toString();
    }
}