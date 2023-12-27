package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.hill.climbing.algorithm.algorithms.Algorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.AntColonyAlgorithm;
import hr.bp.aoc.hill.climbing.algorithm.algorithms.TabooSearch;
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

		Algorithm<State> algorithmStarting = new TabooSearch(30);
		State endState = algorithmStarting.runMultiple(startingState, 2000);
		logger.info(endState.toString());

		AntColonyAlgorithm algorithm = new AntColonyAlgorithm(startingAnt);
		algorithm.initialUpdatePharomones(endState, 10);
		Ant endAnt = algorithm.runMultiple(startingAnt, 1000);

		logger.info(String.valueOf(algorithm.getCount()));
		logger.info(endAnt.toString());
	}

}