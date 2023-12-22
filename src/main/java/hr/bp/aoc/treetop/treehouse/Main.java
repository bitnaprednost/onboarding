package hr.bp.aoc.treetop.treehouse;

import hr.bp.aoc.treetop.treehouse.trees.Tree;
import hr.bp.aoc.treetop.treehouse.trees.TreeManager;
import hr.bp.aoc.util.Parser;

import java.io.IOException;
import java.util.List;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String textFromFile = Parser.getTextFromFile("src/main/resources/day8Data.txt");
        List<Tree> forest = ParserDay8.generateForest(textFromFile);

        int count = TreeManager.countVisibleTrees(forest);
        System.out.println(count);

        int max = TreeManager.calculateHighestScore(forest);
        System.out.println(max);
    }
}
