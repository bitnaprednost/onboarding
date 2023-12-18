package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.TabooSearch;
import hr.bp.aoc.util.Parser;

import java.io.IOException;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] textFromFile = Parser.getLinesFromFile("src/main/resources/day12Data.txt");

        Algorithm algorithm = new TabooSearch(15);
        State startingState = ParserDay12.parseStartingState(textFromFile);
        State endState = algorithm.run(startingState);

        System.out.println(algorithm.getCount());
        System.out.println(endState);
    }


}
