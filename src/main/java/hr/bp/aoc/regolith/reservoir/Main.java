package hr.bp.aoc.regolith.reservoir;

import hr.bp.aoc.regolith.reservoir.cave.Cave;
import hr.bp.aoc.regolith.reservoir.cave.CaveParser;
import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/day14Data.txt");
        String[] linesFromFile = Reader.getLinesFromFile(path);

        Cave cave = CaveParser.parseLines(linesFromFile, true);
        int capacity = cave.countMaxSand();
        logger.info(String.valueOf(capacity));

        cave = CaveParser.parseLines(linesFromFile, false);
        capacity = cave.countMaxSand();
        logger.info(String.valueOf(capacity));
    }
}
