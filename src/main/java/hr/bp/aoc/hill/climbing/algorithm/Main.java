package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.AntColonyAlgorithm;
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
		Path path = Path.of("src/main/resources/day12Data.txt");
		String[] textFromFile = Reader.getLinesFromFile(path);
		State startingState = ReaderDay12.createStartingState(textFromFile);
		Ant startingAnt = new Ant(startingState);

		Algorithm<Ant> algorithm = new AntColonyAlgorithm(startingAnt);
		Ant endState = algorithm.runMultiple(startingAnt, 100);

		logger.info(String.valueOf(algorithm.getCount()));
		logger.info(endState.toString());
	}

}