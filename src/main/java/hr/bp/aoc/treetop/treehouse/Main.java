package hr.bp.aoc.treetop.treehouse;

import hr.bp.aoc.treetop.treehouse.trees.Tree;
import hr.bp.aoc.treetop.treehouse.trees.TreeManager;
import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day8Data.txt");
        String textFromFile = Reader.getTextFromFile(path);
        List<Tree> forest = ReaderDay8.generateForest(textFromFile);

        int count = TreeManager.countVisibleTrees(forest);
        logger.info(String.valueOf(count));

        int max = TreeManager.calculateHighestScore(forest);
        logger.info(String.valueOf(max));
    }
}
