package hr.bp.aoc.treetop.treehouse;

import hr.bp.aoc.treetop.treehouse.trees.Tree;
import hr.bp.aoc.treetop.treehouse.trees.TreeManager;
import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day8Data.txt");
        String textFromFile = Reader.getTextFromFile(path);
        List<Tree> forest = ReaderDay8.generateForest(textFromFile);

        int count = TreeManager.countVisibleTrees(forest);
        System.out.println(count);

        int max = TreeManager.calculateHighestScore(forest);
        System.out.println(max);
    }
}
