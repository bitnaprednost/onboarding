package hr.bp.aoc.proboscidea.volcanium;

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
        Path path = Path.of("src/main/resources/day16Data.txt");
        String[] textFromFile = Reader.getLinesFromFile(path);

        Graph graph = GraphParser.parseGraph(textFromFile);
        VulcanoManager manager = new VulcanoManager(graph.copy(), graph.findValve("AV").get());
        Algorithm algorithm = new Algorithm(manager);

        algorithm.nextSteps(30, 7);
        long pressureReleased = manager.getPressureReleased();

        logger.info(String.valueOf(pressureReleased));
    }
}
