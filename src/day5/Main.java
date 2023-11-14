package day5;

import day5.crane.Crane;
import day5.crane.CrateMover9001;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParserDay5 parser = new ParserDay5();
        String textFromFile = ParserDay5.getTextFromFile("Resources/day5Data.txt");
        String[] inputs = parser.splitInput(textFromFile);
        String[] commands = parser.parseCommands(inputs[1]);

        Crates crates = new Crates(parser.parseBoxes(inputs[0]));
        Crane crane9000 = new CrateMover9001(crates);

        for(String command : commands){
            crane9000.parseCommand(command);
        }

        String result = crates.getTops();
        System.out.println(result);
    }
}
