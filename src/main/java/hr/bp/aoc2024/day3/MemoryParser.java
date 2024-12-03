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
        Matcher m = Pattern.compile(regex).matcher(memory.get(0));
        List<String> commandsFound = new ArrayList<>();


        while (m.find()) {
            int commandIndStart = m.start();
            commandsFound.add(findCommandFromStartIndex(commandIndStart));
        }

        return commandsFound;
    }

    private String findCommandFromStartIndex(int startIndex) {
        StringBuilder stringBuilder = new StringBuilder();

        char currChar = memory.get(0).charAt(startIndex);
        while(currChar != ')') {
            stringBuilder.append(currChar);
            currChar = memory.get(0).charAt(++startIndex);
        }
        stringBuilder.append(')');

        return stringBuilder.toString();
    }
}