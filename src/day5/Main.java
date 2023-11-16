package day5;

import day5.crane.Crane;
import day5.crane.CrateMover9001;
import util.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String textFromFile = Parser.getTextFromFile("Resources/day5Data.txt");
        String[] inputs = ParserDay5.splitInput(textFromFile);
        String[] commands = ParserDay5.parseCommands(inputs[1]);

        Crates crates = new Crates(ParserDay5.parseBoxes(inputs[0]));
        Crane crane9000 = new CrateMover9001(crates);

        for(String command : commands){
            crane9000.parseCommand(command);
        }

        String result = crates.getTops();
        System.out.println(result);
    }
}
