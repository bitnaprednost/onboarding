package hr.bp.aoc.distress.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SignalParser {

    private static int countBrackets(String source){
        int counter = 0;
        counter += (int) source.chars().filter(ch -> ch == '[').count();
        counter -= (int) source.chars().filter(ch -> ch == ']').count();
        return counter;
    }

    private static int combineStrings(String[] split, int i, StringBuilder builder) {
        int counter = 0;
        do{
            counter += countBrackets(split[i]);
            builder.append(split[i++]).append(",");
        }while(counter!=0 && i<split.length);
        builder.deleteCharAt(builder.length()-1);
        return i;
    }

    private static List<Object> parseToList(String commandsString) {
        List<Object> list = new ArrayList<>();

        commandsString = commandsString.substring(1, commandsString.length()-1);
        String[] split = commandsString.split(",(?![^\\[]*\\])");

        for(int i=0;i<split.length;i++) {
            if(split[i].matches("^\\[.*\\]$")) {
                if(countBrackets(split[i]) == 0) list.add(parseToList(split[i]));
                else{
                    StringBuilder builder = new StringBuilder();
                    i = combineStrings(split, i, builder) - 1;

                    list.add(parseToList(builder.toString()));
                }
            }
            else if(split[i].matches("\\d+")) list.add(Integer.valueOf(split[i]));
            else if(split[i].matches("^\\[+[\\d\\]]+")) {
                StringBuilder builder = new StringBuilder();
                i = combineStrings(split, i, builder) - 1;

                list.add(parseToList(builder.toString()));
            }
            else if(split[i].matches("")) continue;
            else throw new UnsupportedOperationException();
        }

        return list;
    }

    private static Object parseToObject(String commandsString) {
        Object object;

        if(commandsString.matches("^\\[.*\\]$")) object = parseToList(commandsString);
        else if(commandsString.matches("\\d+")) object = Integer.valueOf(commandsString);
        else throw new UnsupportedOperationException();

        return object;
    }

    private static Object[] parseToCommand(String[] commandsString) {
        Object[] objects = new Object[2];
        for(int i=0;i<objects.length;i++) objects[i] = parseToObject(commandsString[i]);
        return objects;
    }

    public static List<Object[]> stringToCommands(String text) {
        List<Object[]> list = new ArrayList<>();

        String[] split = text.split("\n\n");
        for (String commandPairString : split){
            String[] commandsString = commandPairString.split("\n");
            Object[] commandPair = parseToCommand(commandsString);
            list.add(commandPair);
        }

        return list;
    }

    public static int sumCorrectSignals(List<Object[]> commands) {
        int sum = 0;
        for(int i=0;i<commands.size();i++){
            Optional<Boolean> compared = IntegerComparator.compare(commands.get(i)[0], commands.get(i)[1]);
            if(compared.isPresent() && Boolean.TRUE.equals(compared.get())) sum += i+1;
        }
        return sum;
    }
}
