package hr.bp.aoc.supply.stacks;

import hr.bp.aoc.supply.stacks.crane.Crane;
import hr.bp.aoc.supply.stacks.crane.CrateMover9001;
import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day5Data.txt");
        String textFromFile = Reader.getTextFromFile(path);
        String[] inputs = ReaderDay5.splitInput(textFromFile);
        String[] commands = ReaderDay5.parseCommands(inputs[1]);

        Crates crates = new Crates(ReaderDay5.parseToBoxes(inputs[0]));
        Crane crane9000 = new CrateMover9001(crates);

        for(String command : commands){
            crane9000.parseCommand(command);
        }

        String result = crates.getTops();
        System.out.println(result);
    }
}
