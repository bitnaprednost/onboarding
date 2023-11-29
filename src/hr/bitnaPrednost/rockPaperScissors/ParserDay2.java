package hr.bitnaPrednost.rockPaperScissors;

import hr.bitnaPrednost.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParserDay2 implements Parser {

    private ParserDay2(){}

    private static String trimWhiteSpace(String game) {
        return game.strip().trim().replace(" ", "");
    }

    private static boolean checkCorrectFormat(String input){
        return input.matches("[ABC][XYZ]");
    }

    public static List<char[]> parseInputs(String[] inputs) {
        List<char[]> list = new ArrayList<>();

        for(String input : inputs){
            input = trimWhiteSpace(input);

            if(checkCorrectFormat(input)) {
                list.add(input.toCharArray());
            }
            //else throw new IllegalArgumentException();
        }

        return list;
    }
}
