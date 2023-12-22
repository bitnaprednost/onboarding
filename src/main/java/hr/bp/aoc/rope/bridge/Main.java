package hr.bp.aoc.rope.bridge;

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
        Path path = Path.of("src/main/resources/day9Data.txt");
        String[] textFromFile = Reader.getLinesFromFile(path);

        RopeManager manager1 = new RopeManager(2);

        for(String command : textFromFile){
            manager1.parse(command);
        }

        int result1 = manager1.countTailTrail();

        System.out.println(manager1.print(15));
        System.out.println(result1);


        RopeManager manager2 = new RopeManager(10);

        for(String command : textFromFile){
            manager2.parse(command);
        }

        int result2 = manager2.countTailTrail();

        System.out.println(manager2.print(60));
        System.out.println(result2);
    }
}
