package hr.bp.aoc.rope.bridge;

import hr.bp.aoc.util.Parser;

import java.io.IOException;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] textFromFile = Parser.getLinesFromFile("src/main/resources/day9Data.txt");

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
