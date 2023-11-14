package day5;

import util.Parser;

import java.util.*;

public class ParserDay5 extends Parser {

    public String[] splitInput(String input) {
        return input.split("\n\n");
    }

    public int extractBoxNumber(String boxStringLastLine) {
        String trimmed = boxStringLastLine.replaceAll("\s", "");
        return Integer.parseInt(trimmed.substring(trimmed.length()-1));
    }

    public List<Stack<String>> createStacks(int numberOfWantedBoxes) {
        List<Stack<String>> list = new ArrayList<>();
        for(int i=0;i<numberOfWantedBoxes;i++){
            list.add(new Stack<>());
        }
        return list;
    }

    private void fillStacksWithBoxes(String[] lines, List<Stack<String>> stacks) {
        for(int l=lines.length-2;l>=0;l--){
            for(int i=0;i<lines[l].length()/4+1;i++){
                String value = extractValue(lines[l], i);
                if(!value.equals(" ")) stacks.get(i).push(value);
            }
        }
    }

    private static String extractValue(String boxLine, int i) {
        String substring = boxLine.substring(i * 4, (i + 1) * 4 - 1);
        return substring.substring(1, 2);
    }

    private void fillMapWithStacks(Map<Integer, Stack<String>> map, List<Stack<String>> stacks) {
        for(Integer i = 1; i <= stacks.size(); i++){
            map.put(i, stacks.get(i-1));
        }
    }

    public Map<Integer, Stack<String>> parseBoxes(String boxesString) {
        Map<Integer, Stack<String>> map = new HashMap<>();
        String[] lines = boxesString.split("\n");

        int stacksSize = extractBoxNumber(lines[lines.length-1]);
        List<Stack<String>> stacks = createStacks(stacksSize);

        fillStacksWithBoxes(lines, stacks);
        fillMapWithStacks(map, stacks);

        return map;
    }

    public String[] parseCommands(String commandsString) {
        return commandsString.split("\n");
    }
}
