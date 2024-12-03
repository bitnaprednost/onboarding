package hr.bp.aoc2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryParser {
    private final String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
    private String memory;

    public MemoryParser(List<String> memory) {
        this.memory = convertToOneString(memory);
    }

    private String convertToOneString(List<String> memory) {
        StringBuilder sb = new StringBuilder();

        for(String s : memory) {
            sb.append(s.strip());
        }

        return sb.toString();
    }

    public List<String> getCommands() {
        List<String> commandsFound = new ArrayList<>();

        Matcher m = Pattern.compile(regex).matcher(memory);
        while (m.find()) {
            int commandIndStart = m.start();
            commandsFound.add(findCommandFromStartIndex(commandIndStart));
        }

        return commandsFound;
    }

    private String findCommandFromStartIndex(int startIndex) {
        StringBuilder stringBuilder = new StringBuilder();

        char currChar = memory.charAt(startIndex);
        while(currChar != ')') {
            stringBuilder.append(currChar);
            currChar = memory.charAt(++startIndex);
        }
        stringBuilder.append(')');

        return stringBuilder.toString();
    }
}