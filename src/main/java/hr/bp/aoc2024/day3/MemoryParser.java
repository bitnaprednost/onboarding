package hr.bp.aoc2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryParser {
    private final String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
    private String memory;
    private boolean enabledDoDont;

    public MemoryParser(List<String> memory, boolean enabled) {
        this.memory = convertToOneString(memory);
        this.enabledDoDont = enabled;
    }

    public MemoryParser(List<String> memory) {
        this(memory, false);
    }

    private String convertToOneString(List<String> memory) {
        StringBuilder sb = new StringBuilder();

        for (String s : memory) {
            sb.append(s.strip());
        }

        return sb.toString();
    }

    public List<String> getCommands() {
        List<String> commandsFound = new ArrayList<>();

        Matcher m = Pattern.compile(regex).matcher(memory);
        while (m.find()) {
            if (!enabledDoDont) {
                commandsFound.add(m.group());
            } else {
                int commandIndStart = m.start();
                if (checkIfEnabled(commandIndStart)) {
                    commandsFound.add(m.group());
                }
            }
        }

        return commandsFound;
    }

    private boolean checkIfEnabled(int commandStartIndex) {
        String stringBeforeCommand = memory.substring(0, commandStartIndex);
        Matcher doMatches = Pattern.compile("do\\(\\)").matcher(stringBeforeCommand);
        Matcher dontMatches = Pattern.compile("don't\\(\\)").matcher(stringBeforeCommand);

        if (dontMatches.find()) {
            int endIndexDont = dontMatches.end();
            while(dontMatches.find()) {
                endIndexDont = dontMatches.end();
            }
            if (!doMatches.find()) {
                return false;
            } else{
                int endIndexDo = doMatches.end();
                while(doMatches.find()) {
                    endIndexDo = doMatches.end();
                }
                return endIndexDo > endIndexDont;
            }
        }

        return true;
    }
}