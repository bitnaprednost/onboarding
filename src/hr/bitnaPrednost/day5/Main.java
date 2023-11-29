package hr.bitnaPrednost.day5;

import hr.bitnaPrednost.day5.crane.Crane;
import hr.bitnaPrednost.day5.crane.CrateMover9001;
import hr.bitnaPrednost.util.Parser;

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
